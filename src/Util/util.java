package Util;

import java.text.SimpleDateFormat;
import java.util.Date;
// 자주 쓰는 메서드로 추가
public class util {
	public static String getNowDateStr() { // 현재 날짜 시간 구현

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		return format1.format(time);

	}

}
