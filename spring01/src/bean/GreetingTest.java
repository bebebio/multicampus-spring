package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {
		// Java �ҽ����� ��ü ����
		// Greeting gr = new Greeting();
		
		// XML �������� ��ü ����
		// <bean id="gr" class="spring01.Greeting" />
		
		String configPath = "/context/applicationContext.xml";
		//ApplicationContext context = new GenericXmlApplicationContext(configPath);
		ApplicationContext context = new FileSystemXmlApplicationContext("/src" + configPath);
		
		System.out.println("?????");
		
		Greeting gr = context.getBean("gr", Greeting.class);
		gr.greeting();
		
		Greeting gr2 = (Greeting) context.getBean("gr", Greeting.class);
		System.out.println(gr);
		System.out.println(gr2);
		
		//((GenericXmlApplicationContext) context).close();
		((FileSystemXmlApplicationContext) context).close();
	}
	
}
