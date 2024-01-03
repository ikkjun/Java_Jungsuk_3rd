import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_1 {

	public static void main(String[] args) {
		/*
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.");
		for(int i=0; i<12;i++) {
			for(int j=1;j<=31;j++) {
				cal.set(2010, i, j);
				if(cal.get(Calendar.DAY_OF_WEEK)==1 && cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)==2) {
					System.out.println(sdf.format(cal.getTime()));
				}
			}
		}
		*/
		Calendar cal = Calendar.getInstance();
		cal.set(2010,0,1);
		for(int i=0;i<12;i++) {
			int weekday = cal.get(Calendar.DAY_OF_WEEK);	// 1일의 요일을 구한다.
			
			// 두 번째 일요일은 1일의 요일에 따라 달라진다.
			// 1일이 일요일인 경우에는 두 번째 일요일은 8일이고,
			// 1일이 다른 요일일 때는 16에서 1일의 요일(weekday)을 빼면 알 수 있다.
			int secondSunday = (weekday==1)?8:16-weekday;
			
			// 두 번째 일요일(secondSunday)로 cal의 날짜(DAY_OF_MONTH)를 바꾼다.
			cal.set(Calendar.DAY_OF_MONTH, secondSunday);
			
			Date d = cal.getTime();	// Calendar을 Date로 변환한다.
			System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));
			
			// 날짜를 다음달 1일로 변경한다.
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_MONTH,1);
		}
	}

}
