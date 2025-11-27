package com.siyuan.deepseek_chat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    @Value("${openai.api.key}")
    private String API_KEY ;
    @Value("${openai.api.url}")
    private  String API_URL ;
    @Value("${openai.api.model}")
    private String MODEL_NAME;


    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 聊天
     * @param prompt 内容
     * @return
     */
    public String chat(String prompt,int maxTokens) {
        // 1.设置请求头
        HttpHeaders headers = new HttpHeaders();
        // 2.构造请求头
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 3.构造消息队列
        Map<String,String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        //4.构造请求体
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("messages", Arrays.asList(message));
        requestBody.put("model", MODEL_NAME);
        requestBody.put("max_token", maxTokens);
        requestBody.put("temperature", 0.7);
        requestBody.put("stream", false);

        //5.封装请求
        HttpEntity<Map<String,Object>> request = new HttpEntity<>(requestBody, headers);

        System.out.println(request);

        try {
            return restTemplate.postForObject(API_URL, request, String.class);
        }catch (Exception e){
            return "{\"error\":\"" + e.getMessage() + "\"}";
        }

    }
}
