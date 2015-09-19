package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Format;

public class HolidayTableItem extends TableItem<Holiday>{
    
    private String date;
    private String description;
    private int day;
    private int month;
    private int year;
    
    public HolidayTableItem() {
    }

    public HolidayTableItem(int id, int day, int month, int year, String description) {
        super(id);
        StringBuilder tmp = new StringBuilder(Format.number("00", day));
        tmp.append("/");
        tmp.append(Format.number("00", month));
        tmp.append("/");
        tmp.append(year != 0? String.valueOf(year) : "****");
        date = tmp.toString();
        this.description = description;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public HolidayTableItem(int day, int month, int year, String description) {
        StringBuilder tmp = new StringBuilder(Format.number("00", day));
        tmp.append("/");
        tmp.append(Format.number("00", month));
        tmp.append("/");
        tmp.append(year != 0? String.valueOf(year) : "----");
        date = tmp.toString();
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Holiday toObject() {
        Holiday holiday = new Holiday();
        holiday.setId(getRow());
        holiday.setDay(day);
        holiday.setMonth(month);
        holiday.setYear(year);
        holiday.setDescription(description);
        return holiday;
    }

    @Override
    public void set(Holiday holiday) {
        StringBuilder tmp = new StringBuilder();
        setRow(holiday.getId());
        day = holiday.getDay();
        month = holiday.getMonth();
        year = holiday.getYear();
        description = holiday.getDescription();
        tmp.append(Format.number("00", day));
        tmp.append("/");
        tmp.append(Format.number("00", month));
        tmp.append("/");
        tmp.append(year != 0 ? String.valueOf(year) : "****");
        date = tmp.toString();
    }

    
    
}
