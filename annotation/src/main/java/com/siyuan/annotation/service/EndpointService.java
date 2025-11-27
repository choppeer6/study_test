package com.siyuan.annotation.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EndpointService {

    // 使用 SpEL 表达式 #{${...}} 来解析属性值并转换为 Map
    @Value("#{${api.endpoints.map}}")
    private Map<String, String> endpoints;

    public void listEndpoints() {
        endpoints.forEach((name, url) ->
                System.out.println(name + " -> " + url)
        );
    }
}
