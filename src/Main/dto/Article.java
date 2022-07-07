package Main.dto; // 클래스와 패키지 분리 작업

public class Article {
	// DTO(Data Transfer Object)라고 한다. 여기 있는 객체들
	// 계층간 데이터 교환을 위해 사용하는 객체
	public int id; // public 써줘야 다른 클래스에서 사용 가능
	public String title;
	public String body;
	public String regDate;
	public int hit;

	public Article(int id, String regDate, String title, String body) {
		this(id, regDate, title, body, 0);
	}

	public Article(int id, String regDate, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.hit = hit;

	}

	public void increaseHit() {
		hit++;
	}
}