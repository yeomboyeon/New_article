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
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
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
					System.out.printf("날짜 : 2022-06-22, 12:12:12\n"); // 미구현 날짜
					System.out.printf("제목 : %s\n", foundArticle.title);
					System.out.printf("내용 : %s\n", foundArticle.body);
					System.out.println("-----------------------------");
				}
			} else if (command.startsWith("article delete")) { // 삭제 기능 구현

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

//				Article foundArticle = null; // 여건 이제 필요없음
				int foundIndex = -1; // 인덱스보다 -1

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);

					if (article.id == id) {
//						foundArticle = article; // 요건 이제 필요없음
						foundIndex = i; // 인덱스를 i에 덮어쓰기
						break;
					}
				}
				if (foundIndex == -1) { // 여기도 -1과 같다면
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				articles.remove(foundIndex); // 인덱스를 삭제하기
				// articles.remove(id - 1); // 게시물 삭제 함수, 글번호와 인덱스 번호가 다르기에 인덱스를 실제 지워야 함으로 -1를
				// 해준다.
				// 새글을 쓰고 지우고 다시 썼을 때의 치명적 오류 발생
				// 인덱스는 남고 글번호가 안맞게 되는 상황이 발생하기 때문에 다른 방법이 필요
				// 인덱스 기반으로 삭제하는 코드 구현 필요
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

	public Article(int id, String title, String body) { // new Article 할 때 실행되면서 저장된다.
		this.id = id;
		this.title = title;
		this.body = body;

	}

}