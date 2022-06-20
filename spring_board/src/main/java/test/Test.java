package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		String configPath = "/src/main/webapp/WEB-INF/dispatcher-servlet.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(configPath);
		
	}
	
}
