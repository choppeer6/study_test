package com.siyuan.annotation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "my.map.data")
@Data
public class MyMapConfig {
    private Map<String, String> map;

}
