package di01.bean;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTest {
	
	public static void main(String[] args) {
		String configPath = "/di01/context/applicationContext.xml";
		ApplicationContext context = new GenericXmlApplicationContext(configPath);
		
		Car car = context.getBean("car", Car.class);
		car.drive();
		
		System.out.println("***** array *****");
		for(Object arrayObj : car.getArray()) {
			System.out.println("value=" + arrayObj + ", type=" + arrayObj.getClass().getName());
		}
		
		System.out.println("***** list *****");
		for(Object listObj : car.getList()) {
			System.out.println("value=" + listObj + ", type=" + listObj.getClass().getName());
		}
		
		System.out.println("***** map *****");
		Map<String, Object> map = car.getMap();
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			Object value = map.get(key);
			String type = value.getClass().getName();
			System.out.println("key=" + key + ", value=" + value + ", type=" + type);
		}
		
		System.out.println("***** set *****");
		for(Object setObj : car.getSet()) {
			System.out.println("value=" + setObj + ", type=" + setObj.getClass().getName());
		}
	}
	
}
