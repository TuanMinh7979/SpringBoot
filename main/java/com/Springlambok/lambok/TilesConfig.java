package com.Springlambok.lambok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {

	@Bean("viewResolver") 
	public ViewResolver getViewResolver() {
           UrlBasedViewResolver viewResolver= new UrlBasedViewResolver();
           viewResolver.setViewClass(TilesView.class);
           return viewResolver;
	}
	@Bean("tilesConfigure")
	public TilesConfigurer getTileConfiger() {
		TilesConfigurer configure= new TilesConfigurer();
		configure.setDefinitions("/WEB-INF/tiles.xml");
		return configure;
		
	}
}
