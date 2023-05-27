package com.example.controller;

import com.example.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/show-message")
public class ShowMessageController {
    @Autowired
    private SenderService senderService;

    @GetMapping("/public/sender/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        senderService.send(message);
    }
}
