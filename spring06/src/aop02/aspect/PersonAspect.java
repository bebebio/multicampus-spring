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
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	@AfterReturning(value = "pt()", returning = "rt")
	public void doAfterReturning(String rt) {
		System.out.println("불을 끄고 잔다. " + rt);
	}
	
	@AfterThrowing(value = "pt()", throwing = "th")
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119에 신고한다.");
	}
	
	@After(value = "pt()")
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
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
