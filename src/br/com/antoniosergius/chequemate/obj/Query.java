package br.com.antoniosergius.chequemate.obj;

import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.tools.Days;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Query {
    private double lowestValue;
    private double highestValue;
    private int bank;
    private int number;
    private Payee payee;
    private GregorianCalendar lowestExpiration;
    private GregorianCalendar highestExpiration;
    private GregorianCalendar lowestInput;
    private GregorianCalendar highestInput;
    private int idClient;

    public Query() {
        this.lowestValue = 0.0;
        this.highestValue = 2000000.0;
        this.bank = 0;
        this.number = 0;
        this.payee = new Payee("", "");
        this.lowestExpiration = ChequeMate.getMinExpirationDate();
        this.highestExpiration = ChequeMate.getMaxDate();
        this.lowestInput = ChequeMate.getMinInputDate();
        this.highestInput = Days.TODAY;
        Days.setToLastMinute(this.highestInput);
        this.idClient = 0;
    }

    public Query(double lowestValue, double highestValue, int bank, int number, Payee payee,
            GregorianCalendar lowestExpiration, GregorianCalendar highestExpiration, int idClient) {
        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
        this.bank = bank;
        this.number = number;
        this.payee = payee;
        this.lowestExpiration = lowestExpiration;
        this.highestExpiration = highestExpiration;
        this.lowestInput = ChequeMate.getMinInputDate();
        this.highestInput = Days.TODAY;
        Days.setToLastMinute(this.highestInput);
        this.idClient = idClient;
    }

    public Query(double lowestValue, double highestValue, int bank, int number, Payee payee,
            GregorianCalendar lowestExpiration, GregorianCalendar highestExpiration, 
            GregorianCalendar lowestInput, GregorianCalendar highestInput, int idClient) {
        this.lowestValue = lowestValue;
        this.highestValue = highestValue;
        this.bank = bank;
        this.number = number;
        this.payee = payee;
        this.lowestExpiration = lowestExpiration;
        this.highestExpiration = highestExpiration;
        this.lowestInput = lowestInput;
        this.highestInput = highestInput;
        this.idClient = idClient;
    }
    
    public void setMaxExpirationDate() {
        this.highestExpiration = ChequeMate.getMaxDate();
    }
    
    public void setMinExpirationDate() {
        this.lowestExpiration = ChequeMate.getMinExpirationDate();
    }
    
    public void setMaxInputDate() {
        this.highestInput = Days.TODAY;
        Days.setToLastMinute(this.highestInput);
    }
    
    public void setMinInputDate() {
        this.lowestInput = ChequeMate.getMinInputDate();
    }
    
    public double getLowestValue() {
        return lowestValue;
    }

    public void setLowestValue(double lowestValue) {
        this.lowestValue = lowestValue;
    }

    public double getHighestValue() {
        return highestValue;
    }

    public void setHighestValue(double highestValue) {
        this.highestValue = highestValue;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public GregorianCalendar getLowestExpiration() {
        return lowestExpiration;
    }

    public void setLowestExpiration(GregorianCalendar lowestExpiration) {
        this.lowestExpiration = lowestExpiration;
    }
    
    public void setLowestExpiration(long time) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(time);
        this.lowestExpiration = date;
    }

    public GregorianCalendar getHighestExpiration() {
        return highestExpiration;
    }

    public void setHighestExpiration(GregorianCalendar highestExpiration) {
        this.highestExpiration = highestExpiration;
    }
    
    public void setHighestExpiration(long time) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(time);
        this.highestExpiration = date;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public GregorianCalendar getLowestInput() {
        return lowestInput;
    }

    public void setLowestInput(GregorianCalendar lowestInput) {
        this.lowestInput = lowestInput;
    }

    public GregorianCalendar getHighestInput() {
        return highestInput;
    }

    public void setHighestInput(GregorianCalendar highestInput) {
        this.highestInput = highestInput;
    }
    
    public void setLowestInput(long time) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(time);
        this.lowestInput = date;
    }
    
    public void setHighestInput(long time) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(time);
        this.highestInput = date;
    }
    
    public boolean isEmpty() {
        return idClient == 0 &&
               Days.equals(highestExpiration, ChequeMate.getMaxDate()) && 
               Days.equals(lowestExpiration, ChequeMate.getMinExpirationDate()) && 
               Days.equals(highestInput, Days.TODAY) &&
               Days.equals(lowestInput, ChequeMate.getMinInputDate()) &&
               highestValue == 2000000.0 &&
               lowestValue == 0.0 &&
               bank == 0 &&
               number == 0 &&
               payee.getRegistryNumber().equals("") &&
               payee.getName().equals(""); 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.lowestValue) ^ (Double.doubleToLongBits(this.lowestValue) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.highestValue) ^ (Double.doubleToLongBits(this.highestValue) >>> 32));
        hash = 89 * hash + this.bank;
        hash = 89 * hash + this.number;
        hash = 89 * hash + Objects.hashCode(this.payee);
        hash = 89 * hash + Objects.hashCode(this.lowestExpiration);
        hash = 89 * hash + Objects.hashCode(this.highestExpiration);
        hash = 89 * hash + Objects.hashCode(this.lowestInput);
        hash = 89 * hash + Objects.hashCode(this.highestInput);
        hash = 89 * hash + this.idClient;
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
        final Query other = (Query) obj;
        if (Double.doubleToLongBits(this.lowestValue) != Double.doubleToLongBits(other.lowestValue)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highestValue) != Double.doubleToLongBits(other.highestValue)) {
            return false;
        }
        if (this.bank != other.bank) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.payee, other.payee)) {
            return false;
        }
        if (!Objects.equals(this.lowestExpiration, other.lowestExpiration)) {
            return false;
        }
        if (!Objects.equals(this.highestExpiration, other.highestExpiration)) {
            return false;
        }
        if (!Objects.equals(this.lowestInput, other.lowestInput)) {
            return false;
        }
        if (!Objects.equals(this.highestInput, other.highestInput)) {
            return false;
        }
        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Query{" + "lowestValue=" + lowestValue + ", highestValue=" +
                highestValue + ", bank=" + bank + ", number=" + number + 
                ", payee=" + payee + ", lowestExpiration=" + lowestExpiration + 
                ", highestExpiration=" + highestExpiration + ", lowestInput=" + 
                lowestInput + ", highestInput=" + highestInput +
                ", idClient=" + idClient + '}';
    }

    

    
    
}
