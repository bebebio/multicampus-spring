package proxy;

import person.Boy;
import person.IPerson;

public class PersonProxyTest {
	
	public static void main(String[] args) {
		IPerson person = new Boy();
		PersonProxy proxy = new PersonProxy();
		proxy.setPerson(person);
		proxy.doSomething();
	}
	
}
