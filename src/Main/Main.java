package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>(); // 코드가 저장할 수 있도록 배열 추가. articles 저장소 구현. 

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
				
				Article article = new Article(id, title, body); // 위 정보를 조립하고 저장한다. // 객체화 // Article 클래스 및 메서드 추가 //   
				articles.add(article); // 배열에 추가 저장하는 코드 구현. // articles 저장소에 add 추가를 article로 조립된 내용을. 
				
				System.out.printf(id + "번 글이 생성되었습니다.\n");
				
			} else if (command.equals("article list")) {
				if(articles.size() == 0) { // articles 저장소에 사이즈 글이 없다면 실행되도록 구현.
					System.out.println("게시글이 없습니다.");
					continue; // 바로 위로 다시 실행되도록 작성.
				} 
			
				System.out.println("번호 | 제목 "); // 글 번호와 제목이 리스트에 나오도록 작성
				
				for(int i = articles.size()-1; i >= 0 ; i--) { // 입력된 글 번호를 저장하고 최신 글이 먼저 나오도록 코드 구현
//					for(int i = 0; i < articles.size(); i++) { // 글 생성하고 리스트에 과거글이 먼저 나오는 코드임. 					
					Article article = articles.get(i); // article에 articles 저장소에 있는 요소를 get 가져온다.
					
					System.out.printf("%d | %s\n", article.id, article.title); // 글 번호와 제목이 출력되도록 작성
					
				}
				
			}
			// equals 메서드에서 startsWith 메서드로 방식 변경(article detail 번호로 시작해서 검색하도록 하기 위해서)
			// 상세보기는 명령어 + 번호가 들어가기 때문에. 번호 전까지는 찾아서 번호를 찾아서 검색할 수 있도록 코드 구현
			// split 문자열 쪼개는 함수 추가 구현 (3등분 : article / detail / 1)
			else if(command.startsWith("article detail")) { // 글 상세페지 보여주기 구현
				
				String[] commandBits = command.split(" "); // 내가 입력한 무언가를 " 공백 "로 쪼갠다.
				// 오류 : 타입 미스매치 / 받아오려는 문자열은 3개이기에 배열로 추가
				// 인덱스 부여 가능
				// commandBits[0]; article
				// commandBits[1]; detail
				// commandBits[2]; ~~
				// String id = commandBits[2]; // commandBits 는 위에 String로 받아야 하기에 정수화를 시켜서 int 화 하기
				int id = Integer.parseInt(commandBits[2]); // 문자를 int에 넣는 방법 "2" -> 2 로 바꾸는 코드
				// 강사 동영상 작업 5, 25분 진행중
				System.out.printf("%d번 게시물 존재하지 않습니다.\n", id);
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