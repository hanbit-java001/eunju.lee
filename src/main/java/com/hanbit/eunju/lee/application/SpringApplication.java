package com.hanbit.eunju.lee.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.eunju.lee.core.dao.MybatisExampleDAO;
import com.hanbit.eunju.lee.core.service.SchedulerService;
import com.hanbit.eunju.lee.core.vo.ScheduleVO;


public class SpringApplication {

	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");

			ApplicationContext applicationContext =
					new ClassPathXmlApplicationContext("spring/applicationContext-core.xml",
							"spring/applicationContext-dao.xml");

			SchedulerService schedulerService = applicationContext.getBean(SchedulerService.class);

			ScheduleVO schedule = new ScheduleVO();
			schedule.setScheduleId(String.valueOf(System.currentTimeMillis()));
			schedule.setTitle("Àú³á");
			schedule.setMemo("¹ÝÂù ¹»±î");
			schedule.setStartDt("201609131830");
			schedule.setEndDt("201609131930");

			int result = schedulerService.addSchedule(schedule);

			/*MybatisExampleDAO mybatisExampleDAO = applicationContext.getBean(MybatisExampleDAO.class);
			mybatisExampleDAO.logSystdate();*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}