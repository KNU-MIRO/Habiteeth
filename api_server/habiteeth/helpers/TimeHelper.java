package habiteeth.helpers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;

public class TimeHelper {
    public static String toISO8601UTC(Date date) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(date);
      }
      
      public static Date fromISO8601UTC(String dateStr) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        dateFormat.setTimeZone(timeZone);
        
        try {
          return dateFormat.parse(dateStr);
        } catch (ParseException error) {
          error.printStackTrace();
        }
        
        return null;
      }

      public static long getDuration(String startTime, String endTime) {
          Date startDate = TimeHelper.fromISO8601UTC(startTime);
          Date endDate = TimeHelper.fromISO8601UTC(endTime);
          return endDate.getTime() - startDate.getTime();
      }
}