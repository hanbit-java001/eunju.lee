package com.hanbit.eunju.lee.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.eunju.lee.core.vo.ScheduleVO;

@Repository
public class ScheduleDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleDAO.class);

	@Autowired
	private SqlSession sqlSession;

	public int insertSchedule(ScheduleVO schedule) {
		int result = sqlSession.insert("schedule.insertSchedule", schedule);

		return result;
	}

	public int updateSchedule(ScheduleVO schedule) {
		int result = sqlSession.update("schedule.updateSchedule", schedule);

		return result;
	}

	public int deleteSchedule(String scheduleId, int memberId) {
		Map params = new HashMap();
		params.put("scheduleId", scheduleId);
		params.put("memberId", memberId);

		int result = sqlSession.delete("schedule.deleteSchedule", params);

		return result;
	}

	public List<ScheduleVO> selectSchedules(String startDt, String endDt, int memberId) {
		Map params = new HashMap();
		params.put("startDt", startDt);
		params.put("endDt", endDt);
		params.put("memberId", memberId);

		List<ScheduleVO> result = sqlSession.selectList("schedule.selectSchedules", params);

		return result;
	}

	public ScheduleVO selectSchedule(String scheduleId, int memberId) {
		Map params = new HashMap();
		params.put("scheduleId", scheduleId);
		params.put("memberId", memberId);

		ScheduleVO schedule = sqlSession.selectOne("schedule.selectSchedule", params);

		return schedule;
	}

	public int countSchedule(String startDt, String endDt, int memberId) {
		Map params = new HashMap();
		params.put("startDt", startDt);
		params.put("endDt", endDt);
		params.put("memberId", memberId);

		int result = sqlSession.selectOne("schedule.countSchedule", params);

		return result;
	}

}
