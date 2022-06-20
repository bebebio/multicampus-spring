package di02.bean;

import org.springframework.stereotype.Component;

@Component
public class KoreaTire implements Tire {
	
	@Override
	public String getTire() {
		return "국산타이어";
	}
	
}
