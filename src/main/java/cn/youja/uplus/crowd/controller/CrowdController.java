package cn.youja.uplus.crowd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.youja.uplus.crowd.model.Crowd;
import cn.youja.uplus.crowd.service.CrowdService;

@RestController
public class CrowdController{

	@Autowired
	private CrowdService crowdService;

	/**
	 * 新注册的用户
	 * @param gender
	 * @param count
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/new")
	Crowd newRegister(
			@RequestParam(value="gender",required=false) Byte gender,
			@RequestParam(value="count") Integer count) {

		return crowdService.newUsersByGender(null != gender ? gender : 0, count);

	}
	
	/**
	 * 日活跃用户.
	 * @param gender
	 * @param count
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dau")
	Crowd dau(
			@RequestParam(value="gender",required=false) Byte gender,
			@RequestParam(value="count") Byte count) {
		
		return crowdService.dauByGender(null != gender ? gender : 0, count);
		
	}
	

}
