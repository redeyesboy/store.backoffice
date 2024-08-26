package co.kr.store.bo.core.config.web.view.template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class ThymeleafConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.thymeleaf")
	SpringResourceTemplateResolver springResourceTemplateResolver() {
		return new SpringResourceTemplateResolver();
	}

	@Bean
	SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
		springTemplateEngine.addDialect(new LayoutDialect());
		springTemplateEngine.addDialect(new DataAttributeDialect());
		springTemplateEngine.addDialect(new SpringSecurityDialect());
		return springTemplateEngine;
	}

}
