package di01.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Car {
	
	private Tire tire;
	
	private Object[] array;
	
	private List<Object> list;
	
	private Map<String, Object> map;
	
	private Set<Object> set;
	
	public Car() {
		
	}
	
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("생성자 주입");
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("설정자 주입");
	}
	
	public Tire getTire() {
		return tire;
	}
	
	public void setArray(Object[] array) {
		this.array = array;
	}
	
	public Object[] getArray() {
		return array;
	}
	
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	public List<Object> getList() {
		return list;
	}
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	
	public void setSet(Set<Object> set) {
		this.set = set;
	}
	
	public Set<Object> getSet() {
		return set;
	}
	
	public void drive() {
		System.out.println(tire.getTire() + "로 주행합니다.");
	}
	
}
