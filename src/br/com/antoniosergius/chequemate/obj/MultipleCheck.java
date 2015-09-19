package br.com.antoniosergius.chequemate.obj;

import java.util.GregorianCalendar;

public class MultipleCheck extends Check{
    public static final String BIWEEKLY = "QUINZENAL";
    public static final String MONTHLY = "MENSAL";
    public static final String QUARTERLY = "TRIMESTRAL";
    
    private int count;
    private String periodType;
    private boolean promissoryNote;

    public MultipleCheck() {
    }

    public MultipleCheck(int count, String periodType, 
            boolean promissoryNote, int number, int bank, int agency, 
            double gross, Payee payee, GregorianCalendar expiration) {
        super(number, bank, agency, gross, payee, expiration);
        this.count = count;
        this.periodType = periodType;
        this.promissoryNote = promissoryNote;
    }

    public boolean isPromissoryNote() {
        return promissoryNote;
    }

    public void setPromissoryNote(boolean promissoryNote) {
        this.promissoryNote = promissoryNote;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }
}
