package co.kr.store.bo.core.config.web.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.ToString;

@ToString
public class SystemUser extends User {

	private static final long serialVersionUID = 1L;

	private UserDetail userDetail;
	private List<SimpleGrantedAuthority> authorities;

	public SystemUser(UserDetail userDetail, List<SimpleGrantedAuthority> authorities) {
		super(userDetail.getName(), userDetail.getPassword(), authorities);
	}

	public UserDetail userDetail() {
		return this.userDetail;
	}

	public Integer getId() {
		return this.userDetail.getId();
	}

	public String getEmail() {
		return this.userDetail.getEmail();
	}

}
