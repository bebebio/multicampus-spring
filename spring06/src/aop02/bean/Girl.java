package aop02.bean;

import org.springframework.stereotype.Component;

@Component
public class Girl implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("TV�� ��󸶸� ����.");
		return "Girl";
	}
	
}
