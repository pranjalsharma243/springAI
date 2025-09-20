package com.springai.service.impl;

import com.springai.entity.Tutorial;
import com.springai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }


    @Override
    public List<Tutorial> chat(String query) {
        String prompt = "tell me about virat kohli?";
        //return chatClient.prompt().user(prompt).system("As an expert in cricket").call().content();
        Prompt prompt1 = new Prompt(query);
        /*var response = chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                //.getMetadata();
                .getResult()
                .getOutput()
                .getText();

         */
        List<Tutorial> tutorial = chatClient.prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tutorial>>() {
                });

        return tutorial;

    }
}
