package Main.util;  // 클래스와 패키지 분리 작업

import java.text.SimpleDateFormat;
import java.util.Date;

// 자주 쓰는 메서드로 추가
public class util {
	public static String getNowDateStr() { // 현재 날짜 시간 구현
// 객체화를 시켜서 Main 클래스에 구구절절 코드가 늘어나기 때문에 스테틱 메서드로 추가한 사항임
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd, HH:mm:ss");

		Date time = new Date();

		return format1.format(time);

	}
}
