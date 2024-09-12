package co.kr.store.bo.common.utils;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

	private static RedisTemplate<String, Object> redisTemplate;

	public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
		RedisUtils.redisTemplate = redisTemplate;
	}

	public static void delete(String key) {
		RedisUtils.redisTemplate.delete(key);
	}

	public static void set(String key, Object value) {
		RedisUtils.redisTemplate.opsForValue().set(key, value);
	}

	public static void set(String key, Object value, Duration timeout) {
		RedisUtils.redisTemplate.opsForValue().set(key, value, timeout);
	}

	public static void set(String key, String hashKey, Object value) {
		RedisUtils.redisTemplate.opsForHash().put(key, hashKey, value);
	}

	public static Object get(String key) {
		return RedisUtils.redisTemplate.opsForValue().get(key);
	}

	public static Object get(String key, String hashKey) {
		return RedisUtils.redisTemplate.opsForHash().get(key, hashKey);
	}

}
