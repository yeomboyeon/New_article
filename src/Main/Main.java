<<<<<<< HEAD
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

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

				int id = lastArticleId + 1;
				lastArticleId = id;

				String regDate = Util.getNowDateStr(); // 스테틱 메서드로 바로 사용할 수 있도록 구현
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
				System.out.println("  번호 |    제목     |  조회수 |       작성한 날짜       ");  // 깔끔하게 보이도록 추가
				System.out.println("---------------------------------------------------");  // 깔끔하게 보이도록 추가
				
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%5d | %10s | %5d | %s  \n", article.id, article.title, article.hit,
							article.regDate); // 조회수 구현 추가
					System.out.println("---------------------------------------------------");  // 깔끔하게 보이도록 추가
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
}

class Article { // 클래스를 우선 Main에 나오도록 다시 작성 추후 별도 클래스로 재구현 예정
	int id;
	String title;
	String body;
	String regDate;
	int hit; // 조회수를 구현할 수 있도록 변수값 추가

	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.hit = 0; // 조회수 초기값 0

	}

	public void increaseHit() { // 함수가 실행될 때마다 조회수가 증가되는 함수 추가
		hit++;
		
	}
}
=======
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

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
				
				int id = lastArticleId + 1;
				lastArticleId = id;
				
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

				System.out.println("번호 | 제목 ");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%d   | %s\n", article.id, article.title);
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
					System.out.println("-----------------------------");
					System.out.printf("번호 : %d\n", foundArticle.id);
					System.out.printf("날짜 : %s\n", foundArticle.regDate); // 날짜를 출력하기 위해 보완
					System.out.printf("제목 : %s\n", foundArticle.title);
					System.out.printf("내용 : %s\n", foundArticle.body);
					System.out.println("-----------------------------");
				}
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
}

class Article { // 클래스를 우선 Main에 나오도록 다시 작성 추후 별도 클래스로 재구현 예정
	int id;
	String title;
	String body;
	String regDate; // 날짜 구현을 위한 추가

	public Article(int id, String regDate, String title, String body) {  // 날짜 구현을 위한 추가
		this.id = id;
		this.regDate = regDate;   // 날짜 구현을 위한 추가
		this.title = title;
		this.body = body;

	}

}
>>>>>>> 7fdfd4eac88b11854633306ec0ec8dbf3cda0557
