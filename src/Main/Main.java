<<<<<<< HEAD
package Main;

public class Main {

public static void main(String[] args) {
	new App().start();
}
=======
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Article> articles; // private는 외부에서 접근 불가. 스테틱은 스테틱만 연결할 수 있기 때문에 추가

	static { // 스테틱 요소 생성자를 추가해서 구현토록 보완
		articles = new ArrayList<>(); // 다른 객체, 클래스에서도 활용 할 수 있도록 Main 전역변수로 위치 이동
	}

	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		makeTestDate(); // 테스트데이터를 사용할 함수 추가

		Scanner sc = new Scanner(System.in);

		articles.size(); // 0 대신에 테스트데이터를 함으로써 바뀌게 된다.

		while (true) {

			System.out.printf("명령어) ");

			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue;
			}
			if (command.equals("system exit")) {
				break;
			}
			if (command.equals("article write")) {

				int id = articles.size() + 1; // lastArticleId >>> articles.size() 바꿈
				// lastArticleId = id; 필요없는걸로 삭제

				String regDate = util.getNowDateStr(); // 스테틱 메서드로 바로 사용할 수 있도록 구현
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);
				articles.add(article);

				System.out.printf(id + "번 글이 생성되었습니다.\n");

			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("---------------------------------------------------"); // 깔끔하게 보이도록 추가
				System.out.println("  번호 |    제목     |  조회수 |       작성한 날짜       "); // 깔끔하게 보이도록 추가
				System.out.println("---------------------------------------------------"); // 깔끔하게 보이도록 추가

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%5d | %10s | %5d | %s  \n", article.id, article.title, article.hit,
							article.regDate); // 조회수 구현 추가
				}
			} else if (command.startsWith("article detail")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물 존재하지 않습니다.\n", id);
					continue;

				} else {

					foundArticle.increaseHit();

					System.out.println("-----------------------------");
					System.out.printf("번호 : %d\n", foundArticle.id);
					System.out.printf("날짜 : %s\n", foundArticle.regDate);
					System.out.printf("제목 : %s\n", foundArticle.title);
					System.out.printf("내용 : %s\n", foundArticle.body);
					System.out.printf("조회 : %d\n", foundArticle.hit); // 조회수 구현
					System.out.println("-----------------------------");
				}
			} else if (command.startsWith("article modify")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.printf("%d번 게시물 존재하지 않습니다.\n", id);
					continue;

				}
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;

				System.out.printf("%s번 게시물이 수정되었습니다.\n", id);

			} else if (command.startsWith("article delete")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				int foundIndex = -1;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
						foundIndex = i;
						break;
					}
				}
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물을 삭제하였습니다.\n", id);
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		sc.close();
		System.out.println("===== 프로그램 종료 =====");
	}

	private static void makeTestDate() { // 테스트데이터 활용할 함수 구현
		System.out.println("테스트를 위한 데이터를 생성합니다.");

		articles.add(new Article(1, util.getNowDateStr(), "제목1", "내용1", 11)); // new article 가 실행되면 articles 에 저장되어 있는
																				// 데이터를 출력(조회수는 임의 지정)
		articles.add(new Article(2, util.getNowDateStr(), "제목2", "내용2", 22));
		articles.add(new Article(3, util.getNowDateStr(), "제목3", "내용3", 33));
	}
}

class Article { // 클래스를 우선 Main에 나오도록 다시 작성 추후 별도 클래스로 재구현 예정
	int id;
	String title;
	String body;
	String regDate;
	int hit; // 조회수를 구현할 수 있도록 변수값 추가

	public Article(int id, String regDate, String title, String body) { // 인자가 4개일 때 받아가는 함수
		this(id, regDate, title, body, 0); // 한줄로 간단하게 줄이기
	}

	public Article(int id, String regDate, String title, String body, int hit) { // 인자 5개/ 조회수 받도록 인자 추가
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.hit = hit; // 조회수 초기값 0 에서 외부에서 받도록 추가
	}

	public void increaseHit() { // 함수가 실행될 때마다 조회수가 증가되는 함수 추가
		hit++;
	}
>>>>>>> 19bc542107a27039fa6d082a13064b8e6ec721b2
}