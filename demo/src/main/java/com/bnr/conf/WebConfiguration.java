package com.bnr.conf;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

	@Bean
	ServletRegistrationBean h2(){
		ServletRegistrationBean b1 = new ServletRegistrationBean(new WebdavServlet());
		b1.addUrlMappings("/console/*");
		return b1;
	}
}
