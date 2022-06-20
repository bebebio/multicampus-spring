package aop02.bean;

import java.util.Random;

import org.springframework.stereotype.Component;

import aop02.exception.FireException;

@Component
public class Boy implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("��ǻ�ͷ� ������ �Ѵ�.");
		
		if(new Random().nextBoolean()) {
			throw new FireException("ȭ�� �߻�");
		}
		
		return "Boy";
	}

}
