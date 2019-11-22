package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.model.ImageDTO;
import com.audelia.backend.loginregistration.loginregistration.util.ImagePath;
import com.audelia.backend.loginregistration.loginregistration.util.StorageService;
import com.audelia.backend.loginregistration.loginregistration.util.converter.ImageConverter;
import com.audelia.backend.loginregistration.loginregistration.util.enums.ImageType;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/file")
public class FileController {

    @Autowired
    private ImagePath imagePath;

    @Autowired
    private StorageService storageService;

    public String getDirectoryFromType(ImageType imageType){
        String direcory = "";
        switch (imageType){
            case PROFILE_ADMIN:
                direcory = imagePath.getAdminProfileImagePath();
                break;
            case PROFILE_PARENT:
                direcory = imagePath.getParentProfileImagePath();
                break;
            case PROFILE_STUDENT:
                direcory = imagePath.getStudentProfileImagePath();
                break;
            case PROFILE_TEACHER:
                direcory = imagePath.getTeacherProfileImagePath();
                break;
            case NEWS:
                direcory = imagePath.getNewsImagePath();
                break;
            case ARTICLES:
                direcory = imagePath.getArticlesImagePath();
                break;
            case LEARING:
                direcory = imagePath.getLearningMaterialImagePath();
                break;
        }
        return direcory;
    }

    @PostMapping("/upload/image")
    public boolean fileUpload(@RequestBody ImageDTO imageDTO){

        System.out.println(imageDTO.getFile());
        System.out.println(imageDTO.getFileName());
        System.out.println(imageDTO.getImageType().toString());

        byte[] bytes = new byte[0];
        Path path = null;

        if (imageDTO.getFile() != null) {
            String s = imageDTO.getFile();
            try {
                bytes = Base64.decode(s);
            } catch (Base64DecodingException e) {
                e.printStackTrace();
                System.out.println("ERROR : " + e.getMessage());
            }
        }
        System.out.println("image dto:" + imageDTO);
        String directory = getDirectoryFromType(imageDTO.getImageType());

        System.out.println("============== " + directory);

        path = Paths.get(directory + imageDTO.getFileName());
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    @GetMapping(value = "/images/get/{imageType}/{fileName:.+}/", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable("imageType") ImageType imageType, @PathVariable("fileName") String fileName) throws IOException {

        ImageType type = imageType;
        String directory = getDirectoryFromType(type);


        try {
            return readBytesFromFile(directory + fileName);

        } catch (Exception e) {
            System.out.println("=======" + e.getMessage());
        }

        return null;

    }


    @GetMapping(value = "/pdf/get/{imageType}/{fileName:.+}/", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getPdf(@PathVariable("imageType") ImageType imageType, @PathVariable("fileName") String fileName) throws IOException {

        ImageType type = imageType;
        String directory = getDirectoryFromType(type);


        try {
            return readBytesFromFile(directory + fileName);

        } catch (Exception e) {
            System.out.println("=======" + e.getMessage());
        }

        return null;

    }

    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }



//    @PostMapping("/getImage")
//    public ImageDTO getImage(@RequestBody ImageDTO imageDTO){
//        ImageType type = imageDTO.getImageType();
//        String directory = getDirectoryFromType(type);
//
//        BufferedImage bImage = null;
//        try {
//            File file = new File(directory + imageDTO.getFileName());
//            System.out.println(file.getPath());
//            bImage = ImageIO.read(file);
//            imageDTO.setFile(ImageConverter.convertBufferedImageToString(bImage));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("ERROR ======== " + e.getMessage());
//        }
//        return imageDTO;
//    }


//    @PostMapping("/upload")
//    public ResponseEntity<Boolean> fileUploadTest(@RequestBody ImageDTO imageDTO){
//        System.out.println(" ================ Called ============");
//        String message = "";
//        try {
//            storageService.store(imageDTO);
//            return ResponseEntity.status(HttpStatus.OK).body(true);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(false);
//        }
//    }



}
