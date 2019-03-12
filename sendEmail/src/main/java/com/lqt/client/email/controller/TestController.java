package com.lqt.client.email.controller;

import com.lqt.client.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TEST
 *
 * @author lqt77
 * @create 2019-03-05-16:31
 */
@RestController
public class TestController {
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "sendEmail")
    public void sendEmail(){
        //ityouknow@126.com","test simple mail"," hello this is simple mail
        String to = "15801408389@163.com";
        String subject = "this is my test";
        String content = "hello this is simple mail";
        mailService.sendSimpleMail(to,subject,content);
    }
}
