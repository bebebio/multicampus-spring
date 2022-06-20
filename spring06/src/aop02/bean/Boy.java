package aop02.bean;

import java.util.Random;

import org.springframework.stereotype.Component;

import aop02.exception.FireException;

@Component
public class Boy implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("컴퓨터로 게임을 한다.");
		
		if(new Random().nextBoolean()) {
			throw new FireException("화재 발생");
		}
		
		return "Boy";
	}

}
