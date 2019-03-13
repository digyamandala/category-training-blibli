package com.company.categoryapp;

import com.company.categoryapp.entity.ApiKeyHandlerArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class CategoryAppApplication implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ApiKeyHandlerArgumentResolver());
	}

	public static void main(String[] args) {
		SpringApplication.run(CategoryAppApplication.class, args);
	}

}
