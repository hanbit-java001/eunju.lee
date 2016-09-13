package com.hanbit.eunju.lee.application;

import com.hanbit.eunju.lee.core.service.SchedulerService;
import com.hanbit.eunju.lee.core.vo.ScheduleVO;

public class SimpleApplication {

	public static void main(String[] args) {
		SchedulerService schedulerService = new SchedulerService();

		ScheduleVO schedule = new ScheduleVO();
		schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
		schedule.setTitle("aaa");
		schedule.setMemo("bbb");
		schedule.setStartDt("201609131830");
		schedule.setEndDt("201609131930");

		int result = schedulerService.addSchedule(schedule);

		System.out.println("°á°ú: " + result);
	}

}
