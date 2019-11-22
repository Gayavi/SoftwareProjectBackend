package com.audelia.backend.loginregistration.loginregistration.util;

import com.audelia.backend.loginregistration.loginregistration.model.ImageDTO;
import com.audelia.backend.loginregistration.loginregistration.util.enums.ImageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {


    @Autowired
    ImagePath imagePath;

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
        }
        return direcory;
    }

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get("upload-dir");

//    public void store(ImageDTO imageDTO) {
//
//        try {
//            String directory = getDirectoryFromType(imageDTO.getImageType()).toString();
//            Path rootLocations = Paths.get(directory);
//            Files.copy(imageDTO.getFile().getInputStream(), this.rootLocation.resolve(imageDTO.getFileName()));
//        } catch (Exception e) {
//            throw new RuntimeException("FAIL!");
//        }
//    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
