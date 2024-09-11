package co.kr.store.bo.common.utils;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return org.apache.commons.lang3.StringUtils.isEmpty(org.apache.commons.lang3.StringUtils.trim(str));
	}

	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}

	public static boolean equals(String str, String compareStr) {
		return org.apache.commons.lang3.StringUtils.equals(str, compareStr);
	}

	public static String nvl(String str) {
		return StringUtils.nvl(str, org.apache.commons.lang3.StringUtils.EMPTY);
	}

	public static String nvl(String str, String compareStr) {
		if ( StringUtils.isEmpty(str) ) {
			return compareStr;
		}
		return str;
	}

}
