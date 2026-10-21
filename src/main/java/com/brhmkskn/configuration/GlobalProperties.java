package com.brhmkskn.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class GlobalProperties {

	@Value("${spring.datasource.url}") // application.properties
	private String url;

	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
}
