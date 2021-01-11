package util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateUtility {

    /**
     * Transform string to instant.
     * Expample string would be 2009-03-28
     *
     * @param date - string representation of date.
     * @return - instant.
     */
    public static Instant toInstant(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = String.format("%s 00:00:00", date);
        TemporalAccessor temporalAccessor = format.parse(dateTime);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return Instant.from(zonedDateTime);
    }
}
