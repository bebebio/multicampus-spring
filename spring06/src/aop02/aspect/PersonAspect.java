package aop02.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonAspect {
	
	@Pointcut(value = "execution(public * aop02..*Something(..))")
	public void pt() {
		
	}
	
	@Before(value = "pt()")
	public void doBefore(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("���� ���� ���� ����.");
	}
	
	@AfterReturning(value = "pt()", returning = "rt")
	public void doAfterReturning(String rt) {
		System.out.println("���� ���� �ܴ�. " + rt);
	}
	
	@AfterThrowing(value = "pt()", throwing = "th")
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119�� �Ű��Ѵ�.");
	}
	
	@After(value = "pt()")
	public void doAfter() {
		System.out.println("���� ���� ���� ���´�.");
	}
	
	/*
	@Around("pt()")
	public void doAround(ProceedingJoinPoint jp) {
		doBefore();
		try {
			jp.proceed();
			doAfterReturning();
		} catch(Throwable e) {
			doAfterThrowing();
		} finally {
			doAfter();
		}
	}
	*/
	
}
