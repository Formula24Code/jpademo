package com.example.jpademo.controller;

import com.example.jpademo.result.StFileVo;
import com.example.jpademo.service.PageCount;
import com.example.jpademo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class StorageController {
    private StorageService storageService;
    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping("/test")
    public PageCount<StFileVo> test(){
        return storageService.findStFileVo(new PageCount<>(1,5),"测试目录",null);
    }
}
