package proxy;

import person.IPerson;

public class PersonProxy implements IPerson {
	
	private IPerson person;
	
	public void setPerson(IPerson person) {
		this.person = person;
	}
	
	@Override
	public void doSomething() {
		System.out.println("���� ���� ���� ����.");
		try {
			person.doSomething();
			System.out.println("���� ���� �ܴ�.");
		} catch(Exception e) {
			System.out.println("119�� �Ű��Ѵ�.");
		} finally {
			System.out.println("���� ���� ���� ���´�.");
		}
	}
	
}
