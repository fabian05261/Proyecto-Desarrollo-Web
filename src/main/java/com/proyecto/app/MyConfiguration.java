package com.proyecto.app;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(getListProperty("origins"));		
		config.setAllowedMethods(getListProperty("methods"));		
		config.setAllowedHeaders(getListProperty("allowedHeaders"));
		config.setExposedHeaders(getListProperty("exposedHeaders"));
		config.setAllowCredentials(getBooleanProperty("credentials"));
		config.setMaxAge(getLongProperty("maxage"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	@Bean
	ModelMapper getMapper() {
		return new ModelMapper();
	}
	
	private List<String> getListProperty(String key){
		return Arrays.asList(env.getProperty(key).split(","));
	}
	
	private Boolean getBooleanProperty(String key){
		return Boolean.valueOf(env.getProperty(key));
	}
	
	private Long getLongProperty(String key){
		return Long.valueOf(env.getProperty(key));
	}
}
