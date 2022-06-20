package aop02.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aop02.exception.FireException;

public class PersonTest {
	
	public static void main(String[] args) {
		String configPath = "/aop02/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		IPerson person = context.getBean("boy", IPerson.class);
		
		try {
			person.doSomething();						
		} catch(FireException e) {
			
		}
	}
	
}
