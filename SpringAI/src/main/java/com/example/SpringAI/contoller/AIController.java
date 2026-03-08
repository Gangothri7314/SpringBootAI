package com.example.SpringAI.contoller;

import com.example.SpringAI.Service.ChatService;
import com.example.SpringAI.Service.ImageService;
import com.example.SpringAI.Service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AIController {

    ChatService chatService;
    @Autowired
    ImageService imageService;
    AudioService speechService;

    public AIController(ChatService chatService, ImageService imageService, AudioService speechService){
        this.chatService = chatService;
        this.imageService = imageService;
        this.speechService = speechService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "this is spring ai application";
    }

    @GetMapping ("/ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getChatResponse(prompt);
    }
    @GetMapping("/generate-image")
    public String generateImage(@RequestParam String prompt){
        return imageService.generateImage(prompt);
    }

    @GetMapping("/generate-audio")
    public String convertTextToSpeech(@RequestParam String prompt){
        return AudioService.convertTextToSpeech(prompt);
    }
}