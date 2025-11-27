package com.siyuan.annotation.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AppService {

    @Value("${app.name}")
    private String appName;
    @Value("${app.user.limit}")
    private int userLimit;


    public void printConfig() {
        System.out.println("AppName: " + appName);
        System.out.println("UserLimit: " + userLimit);
    }
}
