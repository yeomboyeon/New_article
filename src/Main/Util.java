package Main;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util { // 자주 쓰는 함수로 메서드 저장하기
	public static String getNowDateStr() { // 메서드 추가

		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:22");

		Date time = new Date();

		return now.format(time); // 리턴하면 날짜 나옴

	}
}
