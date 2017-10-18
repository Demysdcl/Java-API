package br.com.dclfactor.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtil implements Serializable{
	
	
	public static ArrayList<Integer> MONTHS;
	
	public static ArrayList<Integer> YEARS;

	static{
		YEARS = new ArrayList<Integer>();
		MONTHS = new ArrayList<Integer>();
		for (int i = 0; i < 100 ; i++) {
			YEARS.add(2015 + i);
			if(i > 0 && i < 13){
				MONTHS.add(i);
			}
		}
	}
	
	public static Integer getIntCurrentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	

	public static String getStringMonth(int i) {
		switch (i) {
		case 1:
			return "JANEIRO";
		case 2:
			return "FEVEREIRO";
		case 3:
			return "MAR�O";
		case 4:
			return "ABRIL";
		case 5:
			return "MAIO";
		case 6:
			return "JUNHO";
		case 7:
			return "JULHO";
		case 8:
			return "AGOSTO";
		case 9:
			return "SETEMBRO";
		case 10:
			return "OUTUBRO";
		case 11:
			return "NOVEMBRO";
		case 12:
			return "DEZEMBRO";
		}
		return "";
	}

	public static String format(String pattern, Date date) {
		if (date != null) {
			return new SimpleDateFormat(pattern).format(date);
		}
		return "";
	}

	public static String formatedDateWithBar(Date date) {
		return format("dd/MM/yyyy", date);
	}

	public static String extMonthYear(Date date, String separator) {
		return format("MM" + separator + "yyyy", date);
	}

	public static String extDay(Date date) {
		return format("dd", date);
	}

	public static String extMonth(Date date) {
		return format("MM", date);
	}

	public static String extYear(Date date) {
		return format("yyyy", date);
	}

	public static String extDayMonthYear(Date date) {
		return format("dd-MM-yyyy", date);
	}

	public static String formatedDatetime24(Date date) {
		return format("dd-MM-yyyy kk:mm:ss", date);
	}

	public static String formatedDatetime(Date date) {
		return format("dd-MM-yyyy HH:mm:ss", date);
	}

	public static String formatedDatetime(Date date, String div) {
		return format("dd" + div + "MM" + div + "yyyy HH" + div + "mm" + div
				+ "ss", date);
	}

	public static String getWeakYear(Date date, String separator) {
		return format("ww" + separator + "yy", date);
	}

	public static String extMonthYear(Date date, char separatorType) {
		return format("MM" + separatorType + "yyyy", date);
	}

	public static Double HourAndMinutoToDouble(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		String s = hour + "." + String.format("%02d", min);
		return Double.parseDouble(s);
	}

	// public static String percent(Number number){
	// return NumberFormat.getPercentInstance().format(number);
	// }

	public static Date inicialDate(Date date) {
		return inicialCalendar(date).getTime();
	}

	public static Calendar inicialCalendar(Date date) {
		Calendar startPeriod = Calendar.getInstance();
		startPeriod.setTime(date);
		startPeriod.set(Calendar.HOUR_OF_DAY, 0);
		startPeriod.set(Calendar.MINUTE, 0);
		startPeriod.set(Calendar.SECOND, 0);
		return startPeriod;
	}

	public static Date finalDate(Date date) {
		return finalCalendar(date).getTime();
	}

	public static Calendar finalCalendar(Date date) {
		Calendar finalPeriod = Calendar.getInstance();
		finalPeriod.setTime(date);
		finalPeriod.set(Calendar.HOUR_OF_DAY, 23);
		finalPeriod.set(Calendar.MINUTE, 59);
		finalPeriod.set(Calendar.SECOND, 59);
		return finalPeriod;
	}

	public static int extHourAsInt(Date date) {
		return extract(date, Calendar.HOUR_OF_DAY);
	}

	public static int extMinuteAsInt(Date date) {
		return extract(date, Calendar.MINUTE);
	}

	public static int extSecondAsInt(Date date) {
		return extract(date, Calendar.SECOND);
	}

	private static int extract(Date date, int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(i);
	}

	public static Date stringToDate(String regex, String date) {
		Date dt = null;
		try {
			dt = new SimpleDateFormat(regex).parse(date);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return dt;
	}

	public static String americanPattern(Date date) {
		return format("yyyyMMdd", date);
	}

	public static String extHourMinSec(Date date) {
		return format("hh:mm:ss", date);
	}

	public static String getMinutesToHour(int minutes) {
		if (minutes > 59) {
			int vl = minutes / 60;
			int min = minutes - (vl * 60);
			return String.format("%02d", vl) + ":" + String.format("%02d", min)
					+ " hrs";
		}
		return "00:" + String.format("%02d", minutes) + " min";
	}


	public static Integer getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static Integer getCurrentMonth() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}
	
	public static Integer getCurrentDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	
	public static Integer getCurrentHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	
	public static Integer getCurrentMinutes() {
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	
	public static String formatDuration(Long duration) {
		String fmt = "";
		if (duration != null) {
			if (duration < 60) {
				fmt = fmtTime(0, 0, duration);
			} else if (duration < 3600) {
				long min = duration / 60;
				long sec = duration % 60;
				fmt = fmtTime(0, min, sec);
			} else {
				long hour = duration / 3600;
				long min = (duration % 3600) / 60;
				long sec = (duration % 3600) % 60;
				return fmtTime(hour, min, sec);
			}
		}
		return fmt;
	}

	public static String fmtTime(long hour, long min, long sec) {
		return String.format("%02d", hour) + ":" + String.format("%02d", min)
				+ ":" + String.format("%02d", sec);
	}
}
