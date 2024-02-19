package com.fatma.books.service;

import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageService {
    public  byte[] decodeBase64(String base64Image) {
        System.out.println("DECODE BASE64");
        return Base64.getDecoder().decode(base64Image);
    }


    public  String saveImage(byte[] imageBytes) throws IOException {
        System.out.println("SAVE IMAGE TO FILE");
        System.out.println("Image Bytes ==>  "+imageBytes);
        String fileName = UUID.randomUUID().toString() + ".png";

//        String filePath = "E:\\Fatma Java Developer\\Projects\\books\\images\\"+fileName;
        String folderPath="src/main/resources/images/";

        try (FileOutputStream fos = new FileOutputStream(folderPath+fileName)) {
            fos.write(imageBytes);
        }
        return folderPath+fileName;
    }
}
