package aop01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class PersonAspect implements Aspect {

	@Override
	public void doBefore(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("문을 열고 집에 들어간다.");
	}

	@Override
	public void doAfterReturning(String rt) {
		System.out.println("불을 끄고 잔다. " + rt);
	}

	@Override
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119에 신고한다.");
	}

	@Override
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}

	@Override
	public void doAround(ProceedingJoinPoint jp) {
		doBefore(jp);
		try {
			String rt = (String) jp.proceed();
			doAfterReturning(rt);
		} catch(Throwable e) {
			doAfterThrowing(e);
		} finally {
			doAfter();
		}
	}

}
