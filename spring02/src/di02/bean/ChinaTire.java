package di02.bean;

import org.springframework.stereotype.Component;

@Component
public class ChinaTire implements Tire {
	
	@Override
	public String getTire() {
		return "�߱�Ÿ�̾�";
	}
	
}
