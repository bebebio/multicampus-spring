package di02.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTest {
	
	public static void main(String[] args) {
		String configPath = "/di02/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		
		System.out.println("?????");
		
		Car car = context.getBean("car", Car.class);
		car.drive();
		
		Car car2 = context.getBean("car", Car.class);
		System.out.println(car);
		System.out.println(car2);
		
		((GenericXmlApplicationContext) context).close();
	}
	
}
