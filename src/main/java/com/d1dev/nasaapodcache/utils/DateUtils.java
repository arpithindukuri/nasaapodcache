package com.d1dev.nasaapodcache.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
  public static long getUnixDateToday() {
    Date date = new Date(System.currentTimeMillis());

    return date.getTime();
  }

  public static long getUnixDateOffset(int offset) {
    long DAY_IN_MS = 1000 * 60 * 60 * 24;

    Date date = new Date(System.currentTimeMillis() + (offset * DAY_IN_MS));

    return date.getTime();
  }

  public static String formatUnixDateToString(long epochMs) {
    String pattern = "MM-dd-yyyy";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    String result = simpleDateFormat.format(new Date(epochMs));

    return result;
  }
}
