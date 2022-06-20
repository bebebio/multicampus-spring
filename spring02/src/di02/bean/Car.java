package di02.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("singleton")
public class Car implements InitializingBean, DisposableBean {
	
	@Autowired
	@Qualifier("koreaTire")
	private Tire tire;
	
	public Car() {
		System.out.println("Car 생성자 호출");
	}
	
	/*
	@Autowired(required = false)
	public Car(Tire tire) {
		System.out.println("생성자 주입");
		this.tire = tire;
	}
	
	@Autowired
	@Qualifier("koreaTire")
	public void setTire(Tire tire) {
		System.out.println("설정자 주입");
		this.tire = tire;
	}
	*/
	
	public void drive() {
		System.out.println(tire.getTire() + "로 주행합니다.");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 초기화 메소드는 빈 객체 생성과 의존성 주입이 완료된 후 getBean() 실행이 가능할 때 호출됨
		System.out.println("afterPropertiesSet 호출 : 객체 생성됨");	
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy 호출 : 객체 소멸됨");
	}
	
	/*
	@PostConstruct
	public void initializeObj() {
		System.out.println("initializeObj 호출 : 객체 생성됨");
	}
	
	@PreDestroy
	public void destroyObj() {
		System.out.println("destroyObj 호출 : 객체 소멸됨");
	}
	*/
	
}
