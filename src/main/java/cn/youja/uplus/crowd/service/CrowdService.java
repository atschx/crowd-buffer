package cn.youja.uplus.crowd.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import cn.youja.uplus.crowd.model.Crowd;

@Service
public class CrowdService {
	
	private static final Integer RAND_LIMIT = 50;
	
	private static final String DEFAULT_PATTERN = "yyyyMMdd";
	
	private static final String REG_USER_PREFIX="uplus:user:reg:%s:%s";
	private static final String DAU_USER_PREFIX="uplus:user:dau:%s:%s";

	@Autowired
	private StringRedisTemplate template;
	
	public Crowd newUsersByGender(byte gender,int count){
		String regKey = String.format(REG_USER_PREFIX, gender,DateTime.now().toString(DEFAULT_PATTERN));
		return new Crowd(template.opsForSet().distinctRandomMembers(regKey,count>RAND_LIMIT?RAND_LIMIT:count));
	}
	
	
	public Crowd dauByGender(byte gender,int count){
		String regKey = String.format(DAU_USER_PREFIX, gender,DateTime.now().toString(DEFAULT_PATTERN));
		return new Crowd(template.opsForSet().distinctRandomMembers(regKey,count>RAND_LIMIT?RAND_LIMIT:count));
	}
}
