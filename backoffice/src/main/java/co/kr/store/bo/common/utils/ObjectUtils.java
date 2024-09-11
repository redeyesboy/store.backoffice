package co.kr.store.bo.common.utils;

public class ObjectUtils {

	public static boolean isEmpty(Object obj) {
		return org.springframework.util.ObjectUtils.isEmpty(obj);
	}

	public static boolean isNotEmpty(Object obj) {
		return !ObjectUtils.isEmpty(obj);
	}

}
