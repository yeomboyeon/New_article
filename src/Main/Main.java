package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("===== 프로그램 시작 =====");

		Scanner sc = new Scanner(System.in); // 스캐너 불러오는 함수
		int lastArticleId = 0;

		while (true) { // 무조건 반복하는 반복문

			System.out.printf("명령어) "); // 입력하기 위한 명령어 제목

			String command = sc.nextLine(); // 입력하는 부분

			if (command.length() == 0) {
				System.out.println("명령어를 입력해 주세요.");
				continue; // if 문 바로 위로 빠져나가는 함수
				// break; 반복문을 완전 빠져나가는 함수
			}
			if (command.equals("system exit")) { // command 변수 입력시 프로그램 종료되도록 작성
				break;
			}
			if (command.equals("article write")) { // 글 작성시 글번호가 생성되어야 하기에 lastArticleId를 int로 정의
				int id = lastArticleId + 1; // 생성하는 글 번호는 마지막에 작성된 글 마지막 번호 +1이 되어야 생성
				lastArticleId = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine(); // 입력하는 부분
				System.out.printf("내용 : ");
				String body = sc.nextLine(); // 입력하는 부분

				System.out.printf(id + "번 글이 생성되었습니다.\n");
			} else if (command.equals("article list")) { 
				System.out.println("게시글이 없습니다.");
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		sc.close(); // 스캐너 구문 종료 버튼

		System.out.println("===== 프로그램 종료 =====");
	}
}
