package com.ahmad.delete.controller;

import com.ahmad.delete.model.DeletedFile;
import com.ahmad.delete.repository.DeletedfilesRepository;
import com.ahmad.delete.service.S3Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delete")
public class StorageController {

    @Value("${server.port}")
    int port;



    @Autowired
    private DeletedfilesRepository deletedfilesRepository;

    @Autowired
    private S3Service s3Service;;

    @DeleteMapping("/{filename}")
    public  String deleteFile(@PathVariable("filename") String filename){

        DeletedFile deletedFile = new DeletedFile();
        deletedFile.setName(filename);
        s3Service.deleteFile(filename);
        deletedfilesRepository.save(deletedFile);
        return ("file"+filename+"deleted and was added to deleted files in-memory database");

    }




    @GetMapping("/getDeletedFiles")
    public List<DeletedFile> getAll(){
        return deletedfilesRepository.findAll();
    }



}
