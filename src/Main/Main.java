package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import App.Article;

public class Main {
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>(); // 글생성시 보관하는 창고 역할 list 생성

		while (true) {

			System.out.printf("명령어) ");

			String command = sc.nextLine().trim(); // 빈칸 적용을 없애주는 함수 추가
			
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
				
				Article article = new Article(id,title,body); // 글 생성시 article 을 생성하고 인자 3가지를 불러온다.
				articles.add(article); //article에 추가한다.
				
				System.out.printf(id + "번 글이 생성되었습니다.\n");
				
			} else if (command.equals("article list")) {
				if(articles.size() == 0) { // 글이 저장되는 articles에 글이 있다 없다에 따라 게시글이 있다 없다를 표현
					System.out.println("게시글이 없습니다.");
					continue;
				}else {
					System.out.println("게시글이 있습니다.");
				}
				
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		sc.close();
		System.out.println("===== 프로그램 종료 =====");
	}
}
