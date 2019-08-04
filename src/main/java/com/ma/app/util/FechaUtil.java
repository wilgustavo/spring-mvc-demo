package com.ma.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FechaUtil {
    
    private static final String FORMAT_ISO = "yyyy-MM-dd";

    private FechaUtil() {}
    
    public static String getISOString(Date fecha) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_ISO);
        return formatter.format(fecha);
    }

    public static Date getISODate(String fecha) {
        SimpleDateFormat fomatter = new SimpleDateFormat(FORMAT_ISO);
        try {
            return fomatter.parse(fecha);
        } catch (ParseException e) {
            throw new FechaException(e.getMessage(), e.getCause());
        }
    }

    public static List<String> getNextDays(int count) {
        return IntStream.range(0, count)
                .mapToObj(dia -> LocalDate.now().plusDays(dia).toString())
                .collect(Collectors.toList());
    }

}
