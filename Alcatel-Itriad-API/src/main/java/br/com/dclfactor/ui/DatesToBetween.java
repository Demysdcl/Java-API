/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dclfactor.ui;

/**
 *
 * @author LimaD01
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Getter;
import lombok.SneakyThrows;

public class DatesToBetween implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private Date inicialDate;

    @Getter
    private Date finalDate;

    @Getter
    private Calendar inicialCal;

    @Getter
    private Calendar finalCal;

   

    public DatesToBetween(Date inicialDate, Date finalDate) {
        super();
        this.inicialDate = DateUtil.inicialDate(inicialDate);
        inicialCal = DateUtil.inicialCalendar(inicialDate);
        if (finalDate == null) {
            this.finalDate = DateUtil.finalDate(inicialDate);
            finalCal = DateUtil.finalCalendar(inicialDate);
        } else {
            this.finalDate = DateUtil.finalDate(finalDate);
            finalCal = DateUtil.finalCalendar(finalDate);
        }
    }

    @SneakyThrows
    public DatesToBetween(String[] dates, String roleFormat) {
        inicialCal = Calendar.getInstance();
        finalCal = Calendar.getInstance();
        if (dates != null && dates.length > 0) {
            SimpleDateFormat format = new SimpleDateFormat(roleFormat);
            inicialDate = format.parse(dates[0]);
            inicialDate = DateUtil.inicialDate(inicialDate);
            finalDate = DateUtil.finalDate(inicialDate);
            if (dates.length > 1) {
                finalDate = format.parse(dates[1]);
                finalDate = DateUtil.finalDate(finalDate);
            }
            inicialCal.setTime(inicialDate);
            finalCal.setTime(finalDate);
        }
    }

}
