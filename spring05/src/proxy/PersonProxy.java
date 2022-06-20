package proxy;

import person.IPerson;

public class PersonProxy implements IPerson {
	
	private IPerson person;
	
	public void setPerson(IPerson person) {
		this.person = person;
	}
	
	@Override
	public void doSomething() {
		System.out.println("문을 열고 집에 들어간다.");
		try {
			person.doSomething();
			System.out.println("불을 끄고 잔다.");
		} catch(Exception e) {
			System.out.println("119에 신고한다.");
		} finally {
			System.out.println("문을 열고 집을 나온다.");
		}
	}
	
}
