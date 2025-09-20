package com.springai.controller;

import com.springai.entity.Tutorial;
import com.springai.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {


    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/openai")
    public ResponseEntity<String> chatWithOpenAi(@RequestParam(value = "q", required = true) String prompt) {
        var response = chatService.chat(prompt);
        return ResponseEntity.ok(response);
    }


}