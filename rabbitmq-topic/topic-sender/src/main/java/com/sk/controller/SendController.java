package com.sk.controller;

import com.sk.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class SendController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/send1/{msg}")
    public void send1(@PathVariable String msg) {
        topicService.send1(msg);
    }

    @GetMapping("/send2/{msg}")
    public void send2(@PathVariable String msg) {
        topicService.send2(msg);
    }

    @GetMapping("/send3/{msg}")
    public void send3(@PathVariable String msg) {
        topicService.send3(msg);
    }
}
