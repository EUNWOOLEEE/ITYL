package part07.ch12.sec08;

import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        char dayOfWeek;
        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY: dayOfWeek = '월'; break;
            case Calendar.TUESDAY: dayOfWeek = '화'; break;
            case Calendar.WEDNESDAY: dayOfWeek = '수'; break;
            case Calendar.THURSDAY: dayOfWeek = '목'; break;
            case Calendar.FRIDAY: dayOfWeek = '금'; break;
            case Calendar.SATURDAY: dayOfWeek = '토'; break;
            case Calendar.SUNDAY: dayOfWeek = '일'; break;
            default: dayOfWeek = ' ';
        }

        String amPm = null;
        if (calendar.get(Calendar.AM_PM) == Calendar.AM)
            amPm = "오전";
        else
            amPm = "오후";

        System.out.println(calendar.get(Calendar.YEAR) + "년 "
                + calendar.get(Calendar.MONTH) + "월 "
                + calendar.get(Calendar.DAY_OF_MONTH) + "일");
        System.out.println(dayOfWeek + "요일 " + amPm);
        System.out.println(calendar.get(Calendar.HOUR) + "시 "
                + calendar.get(Calendar.MINUTE) + "분 "
                + calendar.get(Calendar.SECOND));

    }
}
