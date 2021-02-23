package com.core.servlet;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lovely
 * @version 1.0
 * on 2021/2/3
 */
@Configuration
public class ServletCustomizer {

	@Bean("myWebServerFactoryCustomizer")
	public WebServerFactoryCustomizer configWebServer() {
		WebServerFactoryCustomizer webServerFactoryCustomizer = new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
			@Override
			public void customize(ConfigurableServletWebServerFactory factory) {
				factory.setPort(9000);
			}
		};
		return webServerFactoryCustomizer;
	}

}
