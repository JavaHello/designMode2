package org.lk.springboot.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.lk.springboot.demo.domain.base.Audited;
import org.lk.springboot.demo.exception.ErrorCodeEnum;
import org.lk.springboot.demo.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditedAop {


	@Before("execution(* org.lk.springboot.demo.domain.mapper..*.insert(org.lk.springboot.demo.domain.base.Audited+)) && args(audited)")
	public void auditedAdd(Audited audited){
		if(audited.getVersion() == null){
			audited.setVersion(1);
		}
		if(audited.getCreateTime() == null){
			audited.setCreateTime(new Date());
		}
	}

	@AfterReturning(pointcut = "execution(int org.lk.springboot.demo.domain.mapper..*.updateByPrimaryKey(org.lk.springboot.demo.domain.base.Audited+)) || execution(int org.lk.springboot.demo.domain.mapper..*.updateByPrimaryKeySelective(org.lk.springboot.demo.domain.base.Audited+))", returning = "returnInt")
	public void auditedModify(int returnInt){
		if (returnInt < 1){
			throw new ServiceException(ErrorCodeEnum.ERROR_MODIFY);
		}
	}
}
