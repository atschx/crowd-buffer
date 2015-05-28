package cn.youja.uplus.crowd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.youja.uplus.crowd.redis.CrowdRedis;

@RestController
public class CrowdController {

	@Autowired
	private CrowdRedis crowdRedis;

	@RequestMapping("/")
	String home() {
		crowdRedis.test();
		return "Hello World!";
	}

}
