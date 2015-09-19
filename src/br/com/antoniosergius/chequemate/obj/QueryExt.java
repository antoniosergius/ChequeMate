package br.com.antoniosergius.chequemate.obj;

import java.util.GregorianCalendar;

public class QueryExt extends Query {
    private String obs;

    public QueryExt() {
        super();
        this.obs = "";
    }

    public QueryExt(String obs, double lowestValue, double highestValue, int bank, int number, Payee payee, GregorianCalendar lowestExpiration, GregorianCalendar highestExpiration, int idClient) {
        super(lowestValue, highestValue, bank, number, payee, lowestExpiration, highestExpiration, idClient);
        this.obs = obs;
    }

    public QueryExt(String obs, double lowestValue, double highestValue, int bank, int number, Payee payee, GregorianCalendar lowestExpiration, GregorianCalendar highestExpiration, GregorianCalendar lowestInput, GregorianCalendar highestInput, int idClient) {
        super(lowestValue, highestValue, bank, number, payee, lowestExpiration, highestExpiration, lowestInput, highestInput, idClient);
        this.obs = obs;
    }
    
    @Override
    public boolean isEmpty() {
        return super.isEmpty() && obs.isEmpty();
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
