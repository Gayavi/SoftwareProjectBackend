package com.audelia.backend.loginregistration.loginregistration.util.converter;

import com.audelia.backend.loginregistration.loginregistration.util.enums.ImageType;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageConverter {

    public static String convertBufferedImageToString(BufferedImage bImage) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, ImageType.JPEG.toString().toLowerCase(), bos);
        byte[] bytes = bos.toByteArray();
        return Base64.encode(bytes);
    }


}
