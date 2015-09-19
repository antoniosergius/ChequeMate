package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;

public class QueryExtTableItem extends QueryTableItem{
    
    private String obs;

    public QueryExtTableItem() {
    }

    public QueryExtTableItem(int row) {
        super(row);
    }
    
    public QueryExtTableItem(String obs, String client, String inputDate, String number, String bank, String agency, String gross, String registryNumber, String expiration, int row) {
        super(client, inputDate, number, bank, agency, gross, registryNumber, expiration, row);
        this.obs = obs;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    @Override
    public Check toObject()  {
        Check check = super.toObject();
        check.setObs(obs);
        return check;
    }    
    
    @Override
    public void set(Check check) {
        super.set(check);
        obs = check.getObs();
    }
    
    
}
