package com.gradgateways.neu;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*
* @author mrunalipawar
* class : GradGatewaysApplication
*/

@SpringBootApplication()
@ComponentScan({"com.gradgateways.neu.controller", "com.gradgateways.neu.dao", "com.gradgateways.neu.validator", "com.gradgateways.neu.config"})
public class GradGatewaysApplication  extends ServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(GradGatewaysApplication.class, args);
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("homepage");
    }

}
