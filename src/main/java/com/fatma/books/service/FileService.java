package com.fatma.books.service;

import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileService {
    public byte [] decodeBase64(String file64){
        return Base64.getDecoder().decode(file64);

    }
    public String saveFile(byte [] fileBytes) throws IOException{
        String fileName= UUID.randomUUID().toString() + ".pdf";
        String filePath = "E:\\Fatma Java Developer\\Projects\\books\\files\\"+fileName;

        try (FileOutputStream fos=new FileOutputStream(filePath)){
            fos.write(fileBytes);
        }
        return filePath;


    }
}
