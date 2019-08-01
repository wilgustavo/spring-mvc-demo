package com.ma.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {
    
    private static final String FORMAT_ISO = "yyyy-MM-dd";

    private FechaUtil() {}
    
    public static Date getISODate(String fecha) {
        SimpleDateFormat fomatter = new SimpleDateFormat(FORMAT_ISO);
        try {
            return fomatter.parse(fecha);
        } catch (ParseException e) {
            throw new FechaException(e.getMessage(), e.getCause());
        }
    }

}
