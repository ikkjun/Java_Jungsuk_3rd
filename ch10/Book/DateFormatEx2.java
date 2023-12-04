import java.util.*;
import java.text.*;

public class DateFormatEx2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 8, 3);	// 2005년 10월 3일
		
		Date day = cal.getTime();	// Calendar를 Date로 변환
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-M-dd E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
	}

}
