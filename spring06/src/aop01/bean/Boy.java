package aop01.bean;

import java.util.Random;

import aop01.exception.FireException;

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
