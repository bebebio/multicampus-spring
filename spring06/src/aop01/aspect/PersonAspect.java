package aop01.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class PersonAspect implements Aspect {

	@Override
	public void doBefore(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("���� ���� ���� ����.");
	}

	@Override
	public void doAfterReturning(String rt) {
		System.out.println("���� ���� �ܴ�. " + rt);
	}

	@Override
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119�� �Ű��Ѵ�.");
	}

	@Override
	public void doAfter() {
		System.out.println("���� ���� ���� ���´�.");
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
