package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		// Java 소스에서 객체 생성
		// Greeting gr = new Greeting();
		
		// XML 설정에서 객체 생성
		// <bean id="gr" class="spring01.Greeting"></bean>
		
		String configPath = "/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		
		System.out.println("?????");
		
		Greeting gr = context.getBean("gr", Greeting.class);
		gr.greeting();
		
		Greeting gr2 = (Greeting) context.getBean("gr", Greeting.class);
		System.out.println(gr);
		System.out.println(gr2);
		
		((GenericXmlApplicationContext) context).close();
	}
	
}
