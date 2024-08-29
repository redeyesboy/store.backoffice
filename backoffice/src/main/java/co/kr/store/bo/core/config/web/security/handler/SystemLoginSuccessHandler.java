package co.kr.store.bo.core.config.web.security.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.kr.store.bo.common.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SystemLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		setDefaultTargetUrl(Constants.MAIN_VIEW_PATH);
		RedirectStrategy redirectStrategy = getRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
	}

}
