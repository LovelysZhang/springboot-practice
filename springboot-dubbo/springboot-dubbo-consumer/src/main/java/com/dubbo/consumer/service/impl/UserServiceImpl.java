package com.dubbo.consumer.service.impl;


import com.dubbo.api.service.TicketService;
import com.dubbo.consumer.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lovely
 * on 2020/2/13
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private TicketService ticketService;

    @Override
    public void bugTicket() {
        logger.info(ticketService.getTickets());
    }


}
