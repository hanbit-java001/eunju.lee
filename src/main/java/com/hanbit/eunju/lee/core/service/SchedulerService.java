package com.hanbit.eunju.lee.core.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.eunju.lee.core.dao.ScheduleDAO;
import com.hanbit.eunju.lee.core.session.SessionHelpler;
import com.hanbit.eunju.lee.core.vo.ScheduleVO;

@Service
public class SchedulerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

	@Autowired
	private ScheduleDAO scheduleDAO;

	public int addSchedule(ScheduleVO schedule) {
		int memberId = SessionHelpler.getSession().getMemberId();
		schedule.setMemberId(memberId);

		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVO schedule) {
		int memberId = SessionHelpler.getSession().getMemberId();
		schedule.setMemberId(memberId);

		return scheduleDAO.updateSchedule(schedule);
	}

	public int removeSchedule(String scheduleId) {
		int memberId = SessionHelpler.getSession().getMemberId();

		return scheduleDAO.deleteSchedule(scheduleId, memberId);
	}

	public List<ScheduleVO> listSchedules(String startDt, String endDt) {
		int memberId = SessionHelpler.getSession().getMemberId();

		return scheduleDAO.selectSchedules(startDt, endDt, memberId);
	}

	public ScheduleVO getSchedule(String scheduleId) {
		int memberId = SessionHelpler.getSession().getMemberId();

		return scheduleDAO.selectSchedule(scheduleId, memberId);
	}

	public String generateId() {
		String time = String.valueOf(System.currentTimeMillis());
		String threadId = String.valueOf(Thread.currentThread().getId());
		threadId = StringUtils.leftPad(threadId, 4, "0");

		String uniqueId = time + threadId;

		return uniqueId;
	}

	public int countSchedule(String startDt, String endDt) {
		int memberId = SessionHelpler.getSession().getMemberId();

		return scheduleDAO.countSchedule(startDt, endDt, memberId);
	}

}
