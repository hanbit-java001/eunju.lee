package com.hanbit.eunju.lee.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.eunju.lee.core.service.SchedulerService;
import com.hanbit.eunju.lee.core.vo.ScheduleVO;
import com.hanbit.eunju.lee.web.controller.ScheduleController;

@Controller
public class ScheduleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private SchedulerService schedulerService;

	@RequestMapping("/schedule/list")
	public String list() {

		return "schedule/list";
	}

	@RequestMapping("/api/schedule/list")
	@ResponseBody
	public List<ScheduleVO> listSchedules(@RequestParam("startDt") String startDt,
			@RequestParam("endDt") String endDt) {

		List<ScheduleVO> result = schedulerService.listSchedules(startDt, endDt);

		return result;
	}

	@RequestMapping("/api/schedule/add")
	@ResponseBody
	public ScheduleVO addSchedule(@RequestBody ScheduleVO schedule) {

		String scheduleId = schedulerService.generateId();
		schedule.setScheduleId(scheduleId);

		int countAdded = schedulerService.addSchedule(schedule);

		if (countAdded == 0) {
			throw new RuntimeException();
		}

		return schedule;
	}

}
/*	@RequestMapping("/api/schedule/list")
	@ResponseBody
	public List<ScheduleVO> listSchedules(HttpServletRequest request) {
		String startDt = request.getParameter("startDt");
		String endDt = request.getParameter("endDt");

		List<ScheduleVO> result = schedulerService.listSchedules(startDt, endDt);

		return result;
	}
*/

