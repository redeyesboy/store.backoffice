package co.kr.store.bo.common.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import co.kr.store.bo.core.config.web.security.SystemUser;

@Component
public class AuthUtils {

	public static Integer getId() {
		SystemUser user = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getDetails();
		return user.getId();
	}

	public static String getName() {
		SystemUser user = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getDetails();
		return user.getName();
	}

	public static String getEmail() {
		SystemUser user = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getDetails();
		return user.getEmail();
	}

}
