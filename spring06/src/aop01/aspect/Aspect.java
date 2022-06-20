package aop01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface Aspect {
	
	public void doBefore(JoinPoint jp);
	
	public void doAfterReturning(String rt);
	
	public void doAfterThrowing(Throwable th);
	
	public void doAfter();
	
	public void doAround(ProceedingJoinPoint jp);
	
}
