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

				System.out.println("번호 | 제목         | 작성한 날짜");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%d   | %s         | %s\n", article.id, article.title, article.regDate); // 작성한
																												// 날짜가
																												// 나오도록
																												// 코드 보완
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
			} else if (command.startsWith("article modify")) { // article detail 와 거의 같음.

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

				foundArticle.title = title; // 제목과 내용을 새로 받아서 덮어쓰기 
				foundArticle.body = body;

				System.out.printf("%s번 게시물이 수정되었습니다.\n", id); // 수정이 완료되면 메세지 나오도록 구현

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

	public Article(int id, String regDate, String title, String body) { // 날짜 구현을 위한 추가
		this.id = id;
		this.regDate = regDate; // 날짜 구현을 위한 추가
		this.title = title;
		this.body = body;

	}

}