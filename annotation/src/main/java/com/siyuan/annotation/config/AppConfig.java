package com.siyuan.annotation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app.config")
@Component
@Data
public class AppConfig {

    private String name;
    private int maxUsers;

}
