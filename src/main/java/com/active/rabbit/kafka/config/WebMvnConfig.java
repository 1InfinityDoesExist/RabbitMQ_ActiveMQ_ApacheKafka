package com.active.rabbit.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.active.rabbit.kafka.interceptors.CommonInterceptors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebMvnConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private CommonInterceptors commonInterceptors;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("----Common interceptors registered----");
		registry.addInterceptor(commonInterceptors);
	}

}
