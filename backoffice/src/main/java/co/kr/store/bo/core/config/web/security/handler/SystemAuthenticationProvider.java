package co.kr.store.bo.core.config.web.security.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import co.kr.store.bo.core.config.web.security.SystemUser;
import co.kr.store.bo.core.config.web.security.UserDetail;

@Component
public class SystemAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO open api call

		// TODO grant=role set
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), authorities);
		//TODO chg
		UserDetail userDetail = UserDetail.builder()
			.id(1111)
			.email("test@adm.com")
			.name("테스터")
			.build();
		token.setDetails(new SystemUser(userDetail, authorities));
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
