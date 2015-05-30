package cn.youja.uplus.crowd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ResponseBody
	@RequestMapping("/{seed}/{gender}")
	Crowd wildcard(
			@PathVariable("seed") String seed,
			@PathVariable("gender") Byte gender,
			@RequestParam(value="count") Integer count) {
		return crowdService.reg(count);
	}
	
	@ResponseBody
	@RequestMapping("/new")
	Crowd reg(
			@RequestParam(value="count") Integer count) {
		return crowdService.reg(count);
	}
	
	
	@ResponseBody
	@RequestMapping("/dau")
	Crowd dau(
			@RequestParam(value="count") Integer count) {
		return crowdService.dau(count);
	}
	
	
	@ResponseBody
	@RequestMapping("/hot")
	Crowd hot(
			@RequestParam(value="count") Integer count) {
		return crowdService.hot(count);
	}

	@ResponseBody
	@RequestMapping("/new/{gender}")
	Crowd regByGender(
			@PathVariable("gender") Byte gender,
			@RequestParam(value="count") Integer count) {

		return crowdService.newUsersByGender(null != gender ? gender : 0, count);

	}
	
	@ResponseBody
	@RequestMapping("/dau/{gender}")
	Crowd dauByGender(
			@RequestParam(value="gender",required=false) Byte gender,
			@RequestParam(value="count") Byte count) {
		
		return crowdService.dauByGender(null != gender ? gender : 0, count);
		
	}
	
	@ResponseBody
	@RequestMapping("/hot/{gender}")
	Crowd hotByGender(
			@RequestParam(value="gender",required=false) Byte gender,
			@RequestParam(value="count") Byte count) {
		
		return crowdService.hotByGender(null != gender ? gender : 0, count);
		
	}
}
