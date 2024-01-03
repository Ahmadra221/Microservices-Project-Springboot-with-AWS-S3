package com.ahmad.delete.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class S3Service {

    @Value("${bucketName}")
    private String bucketName;

    private  final AmazonS3 s3;

    public S3Service(AmazonS3 s3) {
        this.s3 = s3;
    }


    public String deleteFile(String filename) {

        s3.deleteObject(bucketName,filename);
        return "File deleted";
    }

}