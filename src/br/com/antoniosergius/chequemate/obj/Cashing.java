package br.com.antoniosergius.chequemate.obj;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Cashing implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private GregorianCalendar expiration;
    private double gross;
    private double net;
    private double rate;
    private GregorianCalendar calcDate;

    public Cashing() {
    }

    public Cashing(GregorianCalendar expiration, double gross) {
        this.expiration = expiration;
        this.gross = gross;
    }

    public Cashing(GregorianCalendar expiration, double gross, double net) {
        this.expiration = expiration;
        this.gross = gross;
        this.net = net;
    }

    public Cashing(GregorianCalendar expiration, double gross, double net, double rate) {
        this.expiration = expiration;
        this.gross = gross;
        this.net = net;
        this.rate = rate;
    }

    public Cashing(GregorianCalendar expiration, double gross, double net, double rate, GregorianCalendar calcDate) {
        this.expiration = expiration;
        this.gross = gross;
        this.net = net;
        this.rate = rate;
        this.calcDate = calcDate;
    }
    
    

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public GregorianCalendar getExpiration() {
        return expiration;
    }

    public void setExpiration(GregorianCalendar expiration) {
        this.expiration = expiration;
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

    public GregorianCalendar getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(GregorianCalendar calcDate) {
        this.calcDate = calcDate;
    }
    
    public double getInterest() {
        return gross-net;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.expiration);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.gross) ^ (Double.doubleToLongBits(this.gross) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.net) ^ (Double.doubleToLongBits(this.net) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.rate) ^ (Double.doubleToLongBits(this.rate) >>> 32));
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
        final Cashing other = (Cashing) obj;
        if (!Objects.equals(this.expiration, other.expiration)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gross) != Double.doubleToLongBits(other.gross)) {
            return false;
        }
        if (Double.doubleToLongBits(this.net) != Double.doubleToLongBits(other.net)) {
            return false;
        }
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        return true;
    }
    
    
}
