package sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.service.HeaderService;

@RestController
@RequestMapping("/header")
public class SendController {
    @Autowired
    private HeaderService headerService;

    @GetMapping("/send1/{msg}")
    public void send1(@PathVariable String msg) {
        headerService.send1(msg);
    }

    @GetMapping("/send2/{msg}")
    public void send2(@PathVariable String msg) {
        headerService.send2(msg);
    }
}
