package com.springai.service.impl;

import com.springai.entity.Tutorial;
import com.springai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient chatClient){
        this.chatClient = chatClient;
    }


    @Override
    public String chat(String query) {
        String prompt = "tell me about virat kohli?";
        //return chatClient.prompt().user(prompt).system("As an expert in cricket").call().content();
        /*ye promt specific hai Prompt prompt1 = new Prompt(query, OpenAiChatOptions.builder()
                .model("gpt-4o-mini")
                .temperature(0.3)
                .maxTokens(100)
                .build());*/
        Prompt prompt1 = new Prompt(query);
        // modify this prompt and extra things to prompt make it more attractive
        String querystr = "As a expert in coding and programming. always write program in java. " +
                "Now reply to this question :{query}";
        /*var response = chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                //.getMetadata();
                .getResult()
                .getOutput()
                .getText();
         */
        var response = chatClient
                .prompt()
                .user(u -> u.text(querystr).param("query",query))
                .call()
                .content();
        return response;
    }
}
