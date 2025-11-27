package com.siyuan.deepseek_chat.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatApiTest {

    @Autowired
    private ChatService chatService;


    @Test
    public void testChat(){
        String prompt = "说个关于程序员的幽默笑话";
        int maxTokens = 300;

        System.out.println(">>>>>>正在向DeepSeek发送消息"+ prompt);

        String response = chatService.chat(prompt, maxTokens);

        System.out.println("<<<<<<DeepSeek返回结果："+ response);
        // 如果您使用了 Hutool
         String prettyJson = JSONUtil.toJsonPrettyStr(JSONUtil.parseObj(response));
         System.out.println("<<< 美化后的响应：");
         System.out.println(prettyJson);

    }
}
