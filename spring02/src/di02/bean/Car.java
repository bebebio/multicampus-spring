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
		System.out.println("Car ������ ȣ��");
	}
	
	/*
	@Autowired(required = false)
	public Car(Tire tire) {
		System.out.println("������ ����");
		this.tire = tire;
	}
	
	@Autowired
	@Qualifier("koreaTire")
	public void setTire(Tire tire) {
		System.out.println("������ ����");
		this.tire = tire;
	}
	*/
	
	public void drive() {
		System.out.println(tire.getTire() + "�� �����մϴ�.");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// �ʱ�ȭ �޼ҵ�� �� ��ü ������ ������ ������ �Ϸ�� �� getBean() ������ ������ �� ȣ���
		System.out.println("afterPropertiesSet ȣ�� : ��ü ������");	
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy ȣ�� : ��ü �Ҹ��");
	}
	
	/*
	@PostConstruct
	public void initializeObj() {
		System.out.println("initializeObj ȣ�� : ��ü ������");
	}
	
	@PreDestroy
	public void destroyObj() {
		System.out.println("destroyObj ȣ�� : ��ü �Ҹ��");
	}
	*/
	
}
