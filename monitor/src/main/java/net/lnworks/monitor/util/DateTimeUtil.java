package net.lnworks.monitor.util;

import org.springframework.web.servlet.tags.EditorAwareTag;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateTimeUtil {
    public static String getNowDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }
}
