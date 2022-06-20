package aop01.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import aop01.exception.FireException;

public class PersonTest {
	
	public static void main(String[] args) {
		String configPath = "/aop01/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		IPerson person = context.getBean("boy", IPerson.class);
		
		try {
			person.doSomething();			
		} catch(FireException e) {
			
		}
	}
	
}
