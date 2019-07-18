package sk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.service.SendService;

@RestController
@RequestMapping("/fanout")
class SendController{

    @Autowired
    private SendService sendService;

    @GetMapping("/send/{msg}")
    public void fanoutSend(@PathVariable String msg){
        sendService.send(msg);
    }
}