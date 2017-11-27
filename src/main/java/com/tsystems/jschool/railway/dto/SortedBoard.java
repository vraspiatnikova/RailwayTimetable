package com.tsystems.jschool.railway.dto;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortedBoard implements Comparator<Board> {

    private static final Logger LOGGER = Logger.getLogger(SortedBoard.class);
    public final String DATE_FORMAT = "yyyy/MM/dd HH:mm";

    @Override
    public int compare(Board o1, Board o2) {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        int res = 0;
        try{
            Date date1 = format.parse(o1.getArrivaDatelTime());
            Date date2 = format.parse(o2.getArrivaDatelTime());
            res = date1.compareTo(date2);
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return res;
    }
}
