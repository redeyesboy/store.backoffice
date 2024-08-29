package co.kr.store.bo.core.config.web.security;

import java.io.Serializable;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter @Setter
@ToString
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String name;
	@Builder.Default
	private String password = UUID.randomUUID().toString();

}
