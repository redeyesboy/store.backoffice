package co.kr.store.bo.core.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
@Getter @Setter
@ToString(callSuper = false)
public class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mode;

	private int skip;

	private int take;

	private int page;

	private int pageSize;

	private int totalCount;

}
