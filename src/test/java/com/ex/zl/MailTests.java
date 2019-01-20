package com.ex.zl;

import com.ex.zl.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZlApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class MailTests{
    @Autowired
    private MailService mailService;

    private String to = "ljinyuan10@163.com";

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }
}
