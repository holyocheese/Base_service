package com.base.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSFilter{
	private CorsConfiguration addcorsConfig() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    List<String> list = new ArrayList<>();
	    list.add("*");
	    corsConfiguration.setAllowedOrigins(list);
	    corsConfiguration.addAllowedOrigin("*"); 
	    corsConfiguration.addAllowedHeader("*"); 
	    corsConfiguration.addAllowedMethod("*");
	    corsConfiguration.setAllowCredentials(true);
	    corsConfiguration.setMaxAge(3600L);
	    return corsConfiguration;
	  }
	  @Bean
	  public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", addcorsConfig());
	    return new CorsFilter(source);
	  }
}
