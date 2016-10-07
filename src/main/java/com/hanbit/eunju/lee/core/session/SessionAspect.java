package com.hanbit.eunju.lee.core.session;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SessionAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionAspect.class);
/*   advice  pointcut
	@Before("execution(public * com.hanbit..*(..))")

	@Pointcut("execution(* com.hanbit..*.get*(..))")
	public void hanbitMethod() {
	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
	public void responseBody() {
	}

	@AfterThrowing(value="hanbitMethod() && responseBody()", throwing="ex")
	public void aopTest(Throwable ex) {
		LOGGER.debug("aopTest");
	}
*/
	@Around("@annotation(com.hanbit.eunju.lee.core.session.LoginRequired)")
	public Object checkLogin(ProceedingJoinPoint pjp) throws Throwable {
		Session session = SessionHelpler.getSession();

		if (session.isLoggedIn()) {
			return pjp.proceed();
		}
/*
		LOGGER.debug(pjp.getTarget().toString());
		LOGGER.debug(pjp.getKind().toString());
		LOGGER.debug(pjp.toShortString());
		LOGGER.debug(pjp.toLongString());
*/
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Class returnType = methodSignature.getReturnType();

		if (returnType == String.class) {
			return "login";
		}

		Map result = new HashMap();
		result.put("errorMsg", "로그인이 필요합니다.");

		return result;
	}
}
