package co.kr.store.bo.core.config.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

import co.kr.store.bo.common.Constants;
import co.kr.store.bo.core.config.web.security.handler.SystemAccessDeniedHandler;
import co.kr.store.bo.core.config.web.security.handler.SystemAuthenticationEntryPoint;
import co.kr.store.bo.core.config.web.security.handler.SystemAuthenticationProvider;
import co.kr.store.bo.core.config.web.security.handler.SystemLoginFailureHandler;
import co.kr.store.bo.core.config.web.security.handler.SystemLoginSuccessHandler;
import co.kr.store.bo.core.config.web.security.handler.SystemLogoutSuccessHandler;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final SystemAuthenticationProvider authenticationProvider;
	private final SystemLoginSuccessHandler successHandler;
	private final SystemLoginFailureHandler failureHandler;
	private final SystemLogoutSuccessHandler logoutSuccessHandler;
	private final SystemAuthenticationEntryPoint authenticationEntryPoint;
	private final SystemAccessDeniedHandler accessDeniedHandler;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.csrf((csrf) -> csrf.disable())
			.headers((headers) ->
				headers
					.frameOptions((frameOption) -> frameOption.disable())
					.xssProtection((xssProtection) -> xssProtection.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK))
			)
			.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
					.requestMatchers("/css/**", "/images/**", "/js/**", "/error/**", "/auth/**")
					.permitAll()
					.anyRequest()
					.authenticated()
			)
			.authenticationProvider(authenticationProvider)
			.formLogin((formLogin) ->
				formLogin
					.usernameParameter("name")
					.passwordParameter("password")
					.loginPage(Constants.LOGIN_VIEW_PATH)
					.loginProcessingUrl("/auth/login.do")
					.successHandler(successHandler)
					.failureHandler(failureHandler)
					.permitAll()
			)
			.logout((logout) ->
				logout
					.logoutUrl("/auth/logout.do")
					.logoutSuccessHandler(logoutSuccessHandler)
					.permitAll()
			)
			.exceptionHandling((exceptionHandling) ->
				exceptionHandling
					.authenticationEntryPoint(authenticationEntryPoint)
					.accessDeniedHandler(accessDeniedHandler)
			)
		;

		return httpSecurity.build();
	}

}
