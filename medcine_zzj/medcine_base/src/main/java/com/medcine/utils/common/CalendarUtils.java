/*
 * $Id:$
 * Copyright 2017 ecarpo.com All rights reserved.
 */
package com.medcine.utils.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * CalendarUtils
 * 
 * @author wkq
 * @since 2020.11.20
 */
public class CalendarUtils extends DateUtils {

  private static final Logger logger = LoggerFactory.getLogger(CalendarUtils.class);

  private static final int SECOND = 1000;

  private static final int MINUTE = SECOND * 60;

  private static final int HOUR = MINUTE * 60;

  private static final int DAY = HOUR * 24;

  private static final int DEFAULT_START_DAY_OF_WEEK = Calendar.MONDAY;

  /**
   * Gets nums between the beginDate and endDate.
   * 
   * @param beginDate
   * @param endDate
   * @return
   * @author riverbo
   * @since 2018.01.10
   */
  private static int getBetweens(final Date beginDate, final Date endDate, int nums) {
    if (beginDate == null || endDate == null) {
      throw new IllegalArgumentException("The begingDate and endDate must both be not null");
    }
    long diff = getDayBegin(endDate).getTime() - getDayBegin(beginDate).getTime();
    return (int) (diff / nums);
  }

  /**
   * Gets days between the beginDate and endDate.
   * 
   * @param beginDate
   * @param endDate
   * @return
   * @author Jades.He
   * @since 2018.01.10
   */
  public static int getBetweenDays(final Date beginDate, final Date endDate) {
    return getBetweens(beginDate, endDate, DAY);
  }

  /**
   * Gets hours between the beginDate and endDate.
   * 
   * @param beginDate
   * @param endDate
   * @return
   * @author riverbo
   * @since 2018.01.10
   */
  public static int getBetweenHours(final Date beginDate, final Date endDate) {
    return getBetweens(beginDate, endDate, HOUR);
  }

  /**
   * Gets minutes between the beginDate and endDate.
   * 
   * @param beginDate
   * @param endDate
   * @return
   * @author riverbo
   * @since 2018.01.10
   */
  public static int getBetweenMinutes(final Date beginDate, final Date endDate) {
    return getBetweens(beginDate, endDate, MINUTE);
  }

  /**
   * Gets seconds between the beginDate and endDate.
   * 
   * @param beginDate
   * @param endDate
   * @return
   * @author riverbo
   * @since 2018.01.10
   */
  public static int getBetweenSeconds(final Date beginDate, final Date endDate) {
    return getBetweens(beginDate, endDate, SECOND);
  }

  /**
   * Gets start of the day with time "00:00:00.000".
   * 
   * @param date Date
   * @return Date
   */
  public static Date getDayBegin(final Date date) {
    if (date == null) {
      return date;
    }
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.set(Calendar.HOUR_OF_DAY, 0);
    gc.set(Calendar.MINUTE, 0);
    gc.set(Calendar.SECOND, 0);
    gc.set(Calendar.MILLISECOND, 0);
    return new Date(gc.getTimeInMillis());
  }

  /**
   * Gets end of the day with time "23:59:59.000".
   *
   * @param date Date
   * @return Date
   */
  public static Date getDayEnd(final Date date) {
    if (date == null) {
      return date;
    }
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.set(Calendar.HOUR_OF_DAY, 23);
    gc.set(Calendar.MINUTE, 59);
    gc.set(Calendar.SECOND, 59);
    gc.set(Calendar.MILLISECOND, 0);
    return new Date(gc.getTimeInMillis());
  }

  /**
   * Gets start of the next day with time "00:00:00.000".
   * 
   * @param date Date
   * @return Date
   */
  public static Date getNextDayBegin(final Date date) {
    if (date == null) {
      return date;
    }
    return getDayBegin(DateUtils.addDays(date, 1));
  }

  /**
   * Checks if two date objects are on the same day ignoring year.
   * 
   * @param date1 the first date, not altered
   * @param date2 the second date, not altered
   * @return true if they represent the same day
   * @author jades.he 2014-9-4
   */
  public static boolean isSameDayIgnoringYear(final Date date1, final Date date2) {
    if (date1 == null || date2 == null) {
      return false;
    }

    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal2.setTime(date2);

    return isSameDayIgnoringYear(cal1, cal2);
  }

  /**
   * Checks if two calendar objects are on the same day ignoring year.
   * 
   * @param cal1 the first calendar, not altered
   * @param cal2 the second calendar, not altered
   * @return true if they represent the same day
   * @author jades.he 2014-9-4
   */
  public static boolean isSameDayIgnoringYear(final Calendar cal1, final Calendar cal2) {
    if (cal1 == null || cal2 == null) {
      return false;
    }

    return (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
        && (cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH));
  }

  /**
   * Gets a date with giving milliseconds.
   * 
   * @param milliseconds the milliseconds since January 1, 1970, 00:00:00 GMT.
   * @return Date
   */
  public static Date parseDate(long milliseconds) {
    return new Date(milliseconds);
  }

  /**
   * 尝试使用以下格式对日期字符串进行转换，转换失败返回null.
   * <ol>
   * <li>yyyy-MM-dd'T'HH:mm:ss.SSSZZ</li>
   * <li>yyyy-MM-dd'T'HH:mm:ss.SSS</li>
   * <li>yyyy-MM-dd'T'HH:mm:ssZZ</li>
   * <li>yyyy-MM-dd'T'HH:mm:ss</li>
   * <li>yyyy-MM-ddZZ</li>
   * <li>yyyy-MM-dd</li>
   * </ol>
   * 
   * @param str 日期字符串
   * @return Date
   */
  public static Date parseDate(String str) {
    if (StringUtils.isBlank(str)) {
      return null;
    }
    if (StringUtils.isNumeric(str)) {
      return parseDate(Long.parseLong(str));
    }
    String[] formats = { // NL
        "yyyy-MM-dd'T'HH:mm:ss.SSSZZ", // NL
        "yyyy-MM-dd'T'HH:mm:ss.SSS", // NL
        "yyyy-MM-dd'T'HH:mm:ssZZ", // NL
        "yyyy-MM-dd'T'HH:mm:ss", // NL
        "yyyy-MM-ddZZ", // NL
        "yyyy-MM-dd" //NL
    };

    Date date = null;
    try {
      date = DateUtils.parseDate(str, formats);
    } catch (ParseException e) {
      logger.error("Cannot parse {} as date.", str);
    }
    return date;
  }

  /**
   * 判断给定日期是否为周末（默认按照周一为每周开始日）
   * 
   * @param date
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isLastDayOfWeek(Date date) {
    return isLastDayOfWeek(date, DEFAULT_START_DAY_OF_WEEK);
  }

  /**
   * 判断给定日期是否为周末
   * 
   * @param date
   * @param startDayOfWeek Calendar.SUNDAY Calendar.MONDAY Calendar.TUESDAY
   *        Calendar.WEDNESDAY Calendar.THURSDAY Calendar.FRIDAY
   *        Calendar.SATURDAY
   * @return
   * @author Emily
   * @since 2020.10.10
   */
  public static boolean isLastDayOfWeek(Date date, int startDayOfWeek) {
    return isDayByField(date, Calendar.DAY_OF_WEEK, startDayOfWeek);
  }

  /**
   * 判断给定日期是否为月末
   * 
   * @param date
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isLastDayOfMonth(Date date) {
    return isDayByField(date, Calendar.DAY_OF_MONTH, DEFAULT_START_DAY_OF_WEEK);
  }

  //  /**
  //   * 季度末所在月份 
  //   */
  //  private static final Map<Integer, Integer> mapQuarter = new HashMap<>();
  //  
  //  static {
  //    mapQuarter.put(3, 1);     // 3月份为一季度末
  //    mapQuarter.put(6, 2);     // 6月份为二季度末
  //    mapQuarter.put(9, 3 );     // 9月份为三季度末
  //    mapQuarter.put(12, 4);    // 12月份为四季度末
  //  }

  /**
   * 判断给定日期是否为季末
   * 
   * @param date
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isLastDayOfQuarter(Date date) {
    boolean monthEnd = isLastDayOfMonth(date);
    if (monthEnd) {
      int month = getMonthByDate(date);
      return (month == 3 || month == 6 || month == 9 || month == 12) ? true : false;
    } else {
      return false;
    }
  }

  /**
   * 判断给定日期是否为半年末
   * 
   * @param date
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isLastDayOfHalfYear(Date date) {
    boolean monthEnd = isLastDayOfMonth(date);
    if (monthEnd) {
      int month = getMonthByDate(date);
      return (month == 6) ? true : false;
    } else {
      return false;
    }
  }

  /**
   * 判断给定日期是否为年末
   * 
   * @param date
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isLastDayOfYear(Date date) {
    return isDayByField(date, Calendar.DAY_OF_YEAR, DEFAULT_START_DAY_OF_WEEK);
  }

  /**
   * 判断给定日期为指定的类型
   * 
   * @param date
   * @param field
   * @param startDayOfWeek Calendar.SUNDAY Calendar.MONDAY Calendar.TUESDAY
   *        Calendar.WEDNESDAY Calendar.THURSDAY Calendar.FRIDAY
   *        Calendar.SATURDAY
   * @return true:是|false:不是
   * @author riverbo
   * @since 2018.07.10
   */
  public static boolean isDayByField(Date date, int field, int startDayOfWeek) {
    if (date == null) {
      return false;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.setFirstDayOfWeek(startDayOfWeek);
    calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
    return (calendar.get(field) == 1) ? true : false;
  }

  /**
   * 取昨天
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.13
   */
  public static Date getYesterday(Date date) {
    return getYesterday(date, true);
  }

  /**
   * getYesterday
   * 
   * @param date
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date getYesterday(Date date, boolean clearTime) {
    return addDays(date, -1, clearTime);
  }

  /**
   * getToday
   * 
   * @return
   * @author riverbo
   * @since 2018.07.13
   */
  public static Date getToday() {
    return getToday(true);
  }

  /**
   * getToday
   * 
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date getToday(boolean clearTime) {
    return addDays(new Date(), 0, clearTime);
  }

  /**
   * 取明天
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.13
   */
  public static Date getTomorrow(Date date) {
    return getTomorrow(date, true);
  }

  public static Date getTomorrow(Date date, boolean clearTime) {
    return addDays(date, 1, clearTime);
  }

  /**
   * 取下一年
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.13
   */
  public static Date getNextYear(Date date) {
    return getNextYear(date, true);
  }

  /**
   * 取下一年
   * 
   * @param date
   * @param clearTime
   * @return
   * @author root
   * @since 2018.08.01
   */
  public static Date getNextYear(Date date, boolean clearTime) {
    if (clearTime) {
      return getDayBegin(addYears(date, 1));
    } else {
      return addYears(date, 1);
    }
  }

  /**
   * 取下一月
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.13
   */
  public static Date getNextMonth(Date date) {
    return addMonths(date, 1);
  }

  /**
   * 取下一月
   * 
   * @param date
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date getNextMonth(Date date, boolean clearTime) {
    if (clearTime) {
      return getDayBegin(addMonths(date, 1));
    } else {
      return addMonths(date, 1);
    }
  }

  /**
   * 获取指定年月的第一天
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  public static Date getFirstDayOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    //设置天数
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    //
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取指定年的第一天
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  public static Date getFirstDayOfYear(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    //设置天数
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    //
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取指定年月的最后一天
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  public static Date getLastDayOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    //
    int day = calendar.getActualMaximum(Calendar.DATE);
    //设置天数
    calendar.set(Calendar.DAY_OF_MONTH, day);
    //
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * @param year
   * @param month
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  public static Date getFirstDayOfMonth(int year, int month) {
    return getCalendarDate(year, month, 1);
  }

  /**
   * @param year
   * @param month
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  public static Date getLastDayOfMonth(int year, int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month - 1);
    int day = calendar.getActualMaximum(Calendar.DATE);
    //设置天数
    calendar.set(Calendar.DAY_OF_MONTH, day);
    //
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取当周开始时间
   * 
   * @param date
   * @param startDayOfWeek Calendar.SUNDAY Calendar.MONDAY Calendar.TUESDAY
   *        Calendar.WEDNESDAY Calendar.THURSDAY Calendar.FRIDAY
   *        Calendar.SATURDAY
   * @return
   * @author Emily
   * @since 2020.10.26
   */
  public static Date getFirstDayOfWeek(Date date, int startDayOfWeek) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.setFirstDayOfWeek(startDayOfWeek);

    int calendarDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    int realDayOfWeek = startDayOfWeek
        - (calendarDayOfWeek < startDayOfWeek ? calendarDayOfWeek + 7 : calendarDayOfWeek);
    return getDayBegin(addDays(date, realDayOfWeek));
  }

  /**
   * 获取当周开始时间（默认周一为每周第一天）
   * 
   * @param date
   * @return
   * @author Emily
   * @since 2020.10.26
   */
  public static Date getFirstDayOfWeek(Date date) {
    return getFirstDayOfWeek(date, DEFAULT_START_DAY_OF_WEEK);
  }

  /**
   * getDate
   * 
   * @param year
   * @param month
   * @param day
   * @return
   * @author riverbo
   * @since 2018.07.24
   */
  //  private static Date getDate(int year, int month, int day) {     
  //    Calendar cal = Calendar.getInstance();
  //    //设置年份 
  //    cal.set(Calendar.YEAR, year);
  //    //设置月份 
  //    cal.set(Calendar.MONTH, month);
  //    //设置天数
  //    cal.set(Calendar.DAY_OF_MONTH, day);
  //    //
  //    cal.set(Calendar.HOUR_OF_DAY, 0);
  //    cal.set(Calendar.MINUTE, 0);
  //    cal.set(Calendar.SECOND, 0);
  //    cal.set(Calendar.MILLISECOND, 0);
  //    //
  //    return cal.getTime();
  //  }

  /**
   * @param year
   * @param month
   * @param day
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date getCalendarDate(int year, int month, int day) {
    return getCalendarDate(year, month, day, 0, 0, 0, 0);
  }

  /**
   * @param year
   * @param month
   * @param day
   * @param hour
   * @param minute
   * @param second
   * @param ms
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date getCalendarDate(int year, int month, int day, int hour, int minute, int second,
      int ms) {
    Calendar cal = Calendar.getInstance();
    //设置年份 
    cal.set(Calendar.YEAR, year);
    //设置月份 
    cal.set(Calendar.MONTH, month - 1);
    //设置天数
    cal.set(Calendar.DAY_OF_MONTH, day);
    //
    cal.set(Calendar.HOUR_OF_DAY, hour);
    cal.set(Calendar.MINUTE, minute);
    cal.set(Calendar.SECOND, second);
    cal.set(Calendar.MILLISECOND, ms);
    //
    return cal.getTime();
  }

  /**
   * getYearByDate
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.16
   */
  public static int getYearByDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.YEAR);
  }

  /**
   * getMonthByDate
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.16
   */
  public static int getMonthByDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH) + 1;
  }

  /**
   * getDayByDate
   * 
   * @param date
   * @return
   * @author riverbo
   * @since 2018.07.16
   */
  public static int getDayByDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.DAY_OF_MONTH);
  }

  /**
   * 给定日期，取其按指定的field
   * 
   * @param date
   * @param field
   * @return
   * @throws Exception
   * @author riverbo
   * @since 2018.07.16
   */
  public static int getDateByField(Date date, int field) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(field);
  }

  /**
   * 给定日期，取其按指定的field加n
   * 
   * @param date
   * @param field
   * @param diff
   * @return
   * @throws Exception
   * @author riverbo
   * @since 2018.07.16
   */
  //  public static Date addDateByField(Date date, int field, int diff) {
  //    if (date == null) {
  //      return null;
  //    }
  //    return add(date, field, diff);
  //  }

  /**
   * @param date
   * @param n
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date addYears(Date date, int n, boolean clearTime) {
    if (clearTime) {
      return getDayBegin(addYears(date, n));
    } else {
      return addYears(date, n);
    }
  }

  /**
   * @param date
   * @param n
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date addMonths(Date date, int n, boolean clearTime) {
    if (clearTime) {
      return getDayBegin(addMonths(date, n));
    } else {
      return addMonths(date, n);
    }
  }

  /**
   * @param date
   * @param n
   * @param clearTime
   * @return
   * @author riverbo
   * @since 2018.08.01
   */
  public static Date addDays(Date date, int n, boolean clearTime) {
    if (clearTime) {
      return getDayBegin(addDays(date, n));
    } else {
      return addDays(date, n);
    }
  }

  /**
   * 取第一个日期年月日，第二个日期的时分秒，合并为一个新的日期
   *
   * @param ymdDate 年月日日期
   * @param hmsDate 时分秒日期
   * @return 合并后的新的日期
   * @author mgz
   * @since 2018.12.29
   */
  public static Date mergeTwoDate(Date ymdDate, Date hmsDate) {
    if (ymdDate == null || hmsDate == null) {
      return null;
    }
    Calendar cal = Calendar.getInstance();
    Calendar hmsCal = Calendar.getInstance();
    hmsCal.setTime(hmsDate);
    cal.set(Calendar.YEAR, getYearByDate(ymdDate));
    cal.set(Calendar.MONTH, getMonthByDate(ymdDate) - 1);
    cal.set(Calendar.DAY_OF_MONTH, getDayByDate(ymdDate));
    cal.set(Calendar.HOUR_OF_DAY, hmsCal.get(Calendar.HOUR_OF_DAY));
    cal.set(Calendar.MINUTE, hmsCal.get(Calendar.MINUTE));
    cal.set(Calendar.SECOND, hmsCal.get(Calendar.SECOND));
    return cal.getTime();
  }

  /**
   * 按照每月最多6周，计算指定日期属于当月的第几周
   * 
   * @param date
   * @param startDayOfWeek Calendar.SUNDAY Calendar.MONDAY Calendar.TUESDAY
   *        Calendar.WEDNESDAY Calendar.THURSDAY Calendar.FRIDAY
   *        Calendar.SATURDAY
   * @return
   * @author Emily
   * @since 2020.02.25
   */
  public static int countWeekIndexOfMonth(Date date, int startDayOfWeek) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(getFirstDayOfMonth(date));
    int startDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
    calendar.setTime(date);
    int calendarDate = calendar.get(Calendar.DATE);
    double weeks = (calendarDate + startDayOfMonth - startDayOfWeek) / 7;
    return (int) Math.ceil(weeks);
  }

  /**
   * 按照每月最多6周，计算指定日期属于当月的第几周（默认按照周一为每周开始日）
   * 
   * @param date
   * @return
   * @author Emily
   * @since 2020.02.25
   */
  public static int countWeekIndexOfMonth(Date date) {
    return countWeekIndexOfMonth(date, DEFAULT_START_DAY_OF_WEEK);
  }

  /**
   * 获取某个日期是当年的第几周
   * 
   * @param date
   * @param startDayOfWeek Calendar.SUNDAY Calendar.MONDAY Calendar.TUESDAY
   *        Calendar.WEDNESDAY Calendar.THURSDAY Calendar.FRIDAY
   *        Calendar.SATURDAY
   * @return
   * @author Emily
   * @since 2020.06.28
   */
  public static int countWeekIndexOfYear(Date date, int startDayOfWeek) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.setFirstDayOfWeek(startDayOfWeek);
    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
    if (weekOfYear == 1 && calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
      // 如果结果得到了一个1而且日期为12月份日期，则重新计算
      // 取上一周同一天的年度周索引 + 1作为结果值
      weekOfYear = countWeekIndexOfYear(CalendarUtils.addDays(date, -7), startDayOfWeek) + 1;
    }
    return weekOfYear;
  }

  /**
   * 获取某个日期是当年的第几周（默认按照周一为每周开始日）
   * 
   * @param date
   * @return
   * @author Emily
   * @since 2020.06.28
   */
  public static int countWeekIndexOfYear(Date date) {
    return countWeekIndexOfYear(date, DEFAULT_START_DAY_OF_WEEK);
  }
}
