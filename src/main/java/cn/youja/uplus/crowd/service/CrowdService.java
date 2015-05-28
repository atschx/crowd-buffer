package cn.youja.uplus.crowd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import cn.youja.uplus.crowd.model.Crowd;

@Service
public class CrowdService {

	@Autowired
	private StringRedisTemplate template;

	public Crowd newUsers() {
		Crowd crowd = new Crowd();
		crowd.setData(template.opsForSet().distinctRandomMembers("albert", 5));
		return crowd;
	}

}
