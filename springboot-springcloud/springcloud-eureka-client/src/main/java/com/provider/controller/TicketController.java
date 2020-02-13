package com.provider.controller;

import com.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Spring cloud 通过轻量级http 进行通信的
 * @author non human
 * on 2020/2/14
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String ticket() {
        return ticketService.getTicket() + " " + new Random().nextInt();
    }
}
