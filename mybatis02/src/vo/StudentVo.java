package vo;

public class StudentVo {
	
	private int sid;
	
	private String name;
	
	private int age;
	
	private int score;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentVo [sid=" + sid + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
}
