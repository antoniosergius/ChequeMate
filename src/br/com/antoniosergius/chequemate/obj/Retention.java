package br.com.antoniosergius.chequemate.obj;

import java.util.GregorianCalendar;

public class Retention {
    private String client;
    private double gross;
    private double net;
    private double retention;
    private GregorianCalendar time;
    private String fileName;

    public Retention(String client, double gross, double net, double retention, GregorianCalendar time,
            String fileName) {
        this.client = client;
        this.gross = gross;
        this.net = net;
        this.retention = retention;
        this.time = time;
        this.fileName = fileName;
    }

    public Retention() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getRetention() {
        return retention;
    }

    public void setRetention(double retention) {
        this.retention = retention;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public void setTime(GregorianCalendar time) {
        this.time = time;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
}
