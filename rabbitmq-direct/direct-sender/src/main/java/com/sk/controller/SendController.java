package com.sk.controller;

import com.sk.service.DirectSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direct")
public class SendController {

    @Autowired
    private DirectSendService directSendService;

    @GetMapping("/queue1/{msg}")
    public void sendQueue1(@PathVariable String msg) {
        directSendService.sendQueue1(msg);
    }

    @GetMapping("/queue2/{msg}")
    public void sendQueue2(@PathVariable String msg) {
        directSendService.sendQueue2(msg);
    }
}
