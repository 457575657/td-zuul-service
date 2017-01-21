package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class TdZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdZuulServiceApplication.class, args);
	}
	
	@Bean
 public AccessFilter accessFilter() {
  return new AccessFilter();
 }
}
