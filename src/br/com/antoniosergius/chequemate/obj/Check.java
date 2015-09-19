package br.com.antoniosergius.chequemate.obj;

import br.com.antoniosergius.lib.tools.Format;
import java.io.Serializable;
import java.util.*;

public class Check implements Comparable<Check>, Serializable{
    private static final long serialVersionUID = 1L;
    
    public static final int MAX_BANK = 999;
    public static final int MAX_NUMBER = 999999;
    public static final int MIN_BANK = 0;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_AGENCY = 9999;
    public static final int MIN_AGENCY = 0;
    
    private int id;
    private int number;
    private int bank;
    private int agency;
    private double gross;
    private double net;
    private double rate;
    private Payee payee;
    private GregorianCalendar expiration;
    private GregorianCalendar calcDate;
    private GregorianCalendar inputDate;
    private int idClient;
    private String clientName;
    private String obs;
    
    public Check() {
    }

    public Check(int number, int bank, int agency, double gross, Payee payee, GregorianCalendar expiration) {
        id = 0;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.payee = payee;
        this.expiration = expiration;
    }

    public Check(int number, int bank, int agency, double gross, double net, Payee payee, GregorianCalendar expiration) {
        id = 0;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.net = net;
        this.payee = payee;
        this.expiration = expiration;
    }

    public Check(int id, int number, int bank, int agency, double gross, double net, double rate, Payee payee, GregorianCalendar expiration, GregorianCalendar calcDate) {
        this.id = id;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.net = net;
        this.rate = rate;
        this.payee = payee;
        this.expiration = expiration;
        this.calcDate = calcDate;
    }
    
    public Check(int number, int bank, int agency, double gross, double net, Payee payee, GregorianCalendar expiration, GregorianCalendar inputDate, int idClient) {
        id = 0;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.net = net;
        this.payee = payee;
        this.expiration = expiration;
        this.inputDate = inputDate;
        this.idClient = idClient;
    }

    public Check(int number, int bank, int agency, double gross, Payee payee, GregorianCalendar expiration, int idClient, String clientName) {
        id = 0;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.payee = payee;
        this.expiration = expiration;
        this.idClient = idClient;
        this.clientName = clientName;
    }

    //checkRecord
    public Check(int number, int bank, int agency, double gross, double net, double rate, Payee payee, GregorianCalendar expiration, GregorianCalendar calcDate) {
        id = 0;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.net = net;
        this.rate = rate;
        this.payee = payee;
        this.expiration = expiration;
        this.calcDate = calcDate;
    }

    public Check(int id, int number, int bank, int agency, double gross, double net, double rate, Payee payee, GregorianCalendar expiration,
            GregorianCalendar calcDate, GregorianCalendar inputDate, int idClient, String clientName) {
        this.id = id;
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.net = net;
        this.rate = rate;
        this.payee = payee;
        this.expiration = expiration;
        this.calcDate = calcDate;
        this.inputDate = inputDate;
        this.idClient = idClient;
        this.clientName = clientName;
    }

    
    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public void setId(int chave) {
        this.id = chave;
    }
    
    public int getId() {
        return id;
    }
    
    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getClientName() {
        return clientName;
    }
    
    public GregorianCalendar getInputDate() {
        return inputDate;
    }

    public void setInputDate(GregorianCalendar inputDate) {
        this.inputDate = inputDate;
    }
    
    public GregorianCalendar getExpiration() {
        return expiration;
    }

    public void setExpiration(GregorianCalendar expiration) {
        this.expiration = expiration;
    }    

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public GregorianCalendar getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(GregorianCalendar calcDate) {
        this.calcDate = calcDate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    /*@Override
    public boolean equals(Object obj) {
    if (obj == null) {
    return false;
    }
    if (getClass() != obj.getClass()) {
    return false;
    }
    final Check other = (Check) obj;
    if (this.id != other.id) {
    return false;
    }
    if (this.number != other.number) {
    return false;
    }
    if (this.bank != other.bank) {
    return false;
    }
    if (this.agency != other.agency) {
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
    if (!Objects.equals(this.payee, other.payee)) {
    return false;
    }
    if (!Objects.equals(this.expiration, other.expiration)) {
    return false;
    }
    if (!Objects.equals(this.calcDate, other.calcDate)) {
    return false;
    }
    return true;
    }*/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Check other = (Check) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        if (this.bank != other.bank) {
            return false;
        }
        if (this.agency != other.agency) {
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
        if (!Objects.equals(this.payee, other.payee)) {
            return false;
        }
        if (!Objects.equals(this.expiration, other.expiration)) {
            return false;
        }
        if (!Objects.equals(this.calcDate, other.calcDate)) {
            return false;
        }
        if (!Objects.equals(this.inputDate, other.inputDate)) {
            return false;
        }
        if (!Objects.equals(this.obs, other.obs)) {
            return false;
        }
        return true;
    }
    
    
    
    public boolean isTheSame(Check other) {
        return number==other.getNumber() &&
               bank==other.getBank() &&
               agency==other.getAgency() &&
               payee.getRegistryNumber().equals(other.getPayee().getRegistryNumber());
    }
    
    public static boolean areTheSame(Check c1, Check c2) {
        return c1.getNumber()==c2.getNumber() &&
               c1.getBank()==c2.getBank() &&
               c1.getAgency()==c2.getAgency() &&
               c1.getPayee().getRegistryNumber().equals(c2.getPayee().getRegistryNumber());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.number;
        hash = 29 * hash + this.bank;
        hash = 29 * hash + this.agency;
        hash = 29 * hash + Objects.hashCode(this.payee.getRegistryNumber());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("Check{");
        temp.append(id);
        temp.append(", number=");
        temp.append(number);
        temp.append(", bank=");
        temp.append(bank);
        temp.append(", agency=");
        temp.append(agency);
        temp.append(", gross=");
        temp.append(gross);
        temp.append(", net=");
        temp.append(net);
        temp.append(", rate=");
        temp.append(rate);
        temp.append(", payee=");
        temp.append(payee);
        temp.append(", expiration=");
        temp.append(Format.date(expiration));
        temp.append(", calcDate=");
        temp.append(Format.date(calcDate));
        temp.append(", idClient=");
        temp.append(idClient);
        temp.append('}');
        return temp.toString();
    }
    
    @Override
    public int compareTo(Check o) {
        Double grossValue = this.gross;
        return grossValue.compareTo(o.getGross());
    }
    
}
