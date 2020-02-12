package com.email;

import com.task.SpringBootTaskApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author non human
 * on 2020/2/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTaskApplication.class)
public class MailTest {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 发送简单邮件
     */
    @Test
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("开会");
        message.setText("测试邮件发送");
        message.setTo("email00zhj@qq.com");
        message.setFrom("zhj00email@163.com");

        mailSender.send(message);
    }

    @Test
    public void sendComplexMail() throws MessagingException {
        // 1、创建一个复杂消息邮件
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // 邮件设置
        helper.setSubject("开会");
        helper.setText("<b style='color:red'>时间 20:14</b>", true);

        helper.setTo("email00zhj@qq.com");
        helper.setFrom("zhj00email@163.com");

        // 上传文件
//        helper.addAttachment("",new File());

        mailSender.send(message);
    }
}
