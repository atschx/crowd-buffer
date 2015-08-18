package cn.youja.uplus.crowd.schedule;

import java.util.Date;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class PickupScheduledTasks {

	/**
	 * 凌晨零点1分，任务分拣。
	 */
//	@Scheduled(cron = "0 1 0 * * ? ")
	@Scheduled(fixedRate = 200)
	public void splitByGender() {
		//--
		System.out.println("-------"+new Date());
	}
}
