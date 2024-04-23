package chap11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static void main(String[] args) {

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy EEE hh:mm:ss",Locale.US);
//		sdf.setTimeZone(null);
		System.out.println(sdf.format(now));
		
		Calendar now2 = Calendar.getInstance();
		int year = now2.get(Calendar.YEAR);
		int month = now2.get(Calendar.MONTH)+1;
		int day = now2.get(Calendar.DAY_OF_MONTH);
		
		int week = now2.get(Calendar.DAY_OF_WEEK);
		int amPm = now2.get(Calendar.AM_PM);
		
		int hour = now2.get(Calendar.HOUR);
		int second = now2.get(Calendar.SECOND);
		
		String strweek=null,strAmPm=null;
		switch(week) {
		case Calendar.MONDAY:strweek="월";break;
		case Calendar.TUESDAY:strweek="화";break;
		case Calendar.WEDNESDAY:strweek="수";break;
		case Calendar.THURSDAY:strweek="목";break;
		case Calendar.FRIDAY:strweek="금";break;
		case Calendar.SATURDAY:strweek="토";break;
		case Calendar.SUNDAY:strweek="일";break;
		}
		if(amPm == Calendar.AM) {strAmPm="오전";}else {strAmPm="오후";}
		
		System.out.print(year+"년 ");
		System.out.print(month+"월 ");
		System.out.println(day+"일");
		System.out.print(strweek+"요일 ");
		System.out.println(strAmPm+" ");
		System.out.print(hour+"시 ");
		System.out.print(now2.get(Calendar.MINUTE)+"분 ");
		System.out.println(second+"초");
		
		System.out.printf("%d년 %02d월 %02d일 %s요일 %d시 %d분",year,month,day,strweek,hour,now2.get(Calendar.MINUTE));
		
	}

}
