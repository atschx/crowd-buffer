package cn.youja.uplus.crowd.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CrowdRedis {

	private StringRedisTemplate template;

	@Autowired
	public CrowdRedis(StringRedisTemplate template) {
		this.template = template;
	}
	
	public void test() {
		template.opsForSet().randomMembers("", 5);
		template.opsForSet().add("albert"+System.currentTimeMillis(), "{name:albert}");
	}

}
