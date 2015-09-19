package br.com.antoniosergius.chequemate.obj;

import br.com.antoniosergius.lib.tools.Format;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Holiday implements Comparable<Holiday>, Serializable {
    private static final long serialVersionUID = 1L;    
    
    private int id;
    private int day;
    private int month;
    private Integer year;
    private String description;
    private GregorianCalendar date;
    
    
    
    public Holiday(int day, int month, String description) {
        this.day = day;
        this.month = month;
        this.description = description;
        date = new GregorianCalendar();
        year = 0;
        date.set(GregorianCalendar.DAY_OF_MONTH, day);
        date.set(GregorianCalendar.MONTH, month-1);
    }

    public Holiday(int day, int month, Integer year, String description) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
        date = new GregorianCalendar();
        date.set(GregorianCalendar.DAY_OF_MONTH, day);
        date.set(GregorianCalendar.MONTH, month-1);
        date.set(GregorianCalendar.YEAR, year);
    }
    
    public Holiday(GregorianCalendar date, String description) {
        this.date = date;
        this.year = date.get(GregorianCalendar.YEAR);
        this.month = date.get(GregorianCalendar.MONTH)+1;
        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
        this.description = description;
    }

    public Holiday() {
        date = new GregorianCalendar();
        this.year = date.get(GregorianCalendar.YEAR);
        this.month = date.get(GregorianCalendar.MONTH)+1;
        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
        description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public GregorianCalendar getDate() {
        date.set(GregorianCalendar.DAY_OF_MONTH, day);
        date.set(GregorianCalendar.MONTH, month-1);
        if (year != 0) {
            date.set(GregorianCalendar.YEAR, year); 
        }
        return date;
    }

    public void setDate(GregorianCalendar date, boolean allYears) {
        this.date = date;
        if (allYears) {
            this.year = 0;
        } else {
            this.year = date.get(GregorianCalendar.YEAR);
        }
        this.month = date.get(GregorianCalendar.MONTH)+1;
        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    public void setDate(GregorianCalendar date) {
        this.date = date;
        this.year = date.get(GregorianCalendar.YEAR);
        this.month = date.get(GregorianCalendar.MONTH)+1;
        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.day;
        hash = 47 * hash + this.month;
        hash = 47 * hash + Objects.hashCode(this.year);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Holiday other = (Holiday) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder(description);
        tmp.append(" - ");
        tmp.append(Format.number("00", day));
        tmp.append("/");
        tmp.append(Format.number("00", month));
        tmp.append("/");
        tmp.append(year != 0 ? year : "****");
        
        return tmp.toString();
    }

    

    @Override
    public int compareTo(Holiday o) {
        return date.compareTo(o.date);
    }
    
   
    
}
