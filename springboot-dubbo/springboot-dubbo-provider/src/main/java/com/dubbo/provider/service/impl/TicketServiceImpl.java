package com.dubbo.provider.service.impl;

import com.dubbo.api.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lovely
 * on 2020/2/13
 */
@Service
@Component
public class TicketServiceImpl implements TicketService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String getTickets() {
        logger.info("{}", serviceName);
        return "《哪吒》";
    }

}
