package aop01.bean;

public class Girl implements IPerson {

	@Override
	public String doSomething() {
		System.out.println("TV�� ��󸶸� ����.");
		return "Girl";
	}
	
}
