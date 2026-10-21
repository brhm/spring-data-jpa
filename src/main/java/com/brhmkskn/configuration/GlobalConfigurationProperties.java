package com.brhmkskn.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app") // application.propertieste buraya çekmek isteğimiz grubu prefix ile filtreliyoruz.
public class GlobalConfigurationProperties {

	private  List<Server> servers;
	
	@Value("${key}")
	private String key;
	
}
