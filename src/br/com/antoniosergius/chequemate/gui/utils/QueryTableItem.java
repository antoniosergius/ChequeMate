package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.lib.tools.Format;

public class QueryTableItem extends CheckTableItem {

    private String client;
    private String inputDate;

    public QueryTableItem() {
    }

    public QueryTableItem(int row) {
        super(row);
    }

    public QueryTableItem(String client, String inputDate, String number, String bank, String agency, String gross, String registryNumber, String expiration, int row) {
        super(number, bank, agency, gross, registryNumber, expiration, row);
        this.client = client;
        this.inputDate = inputDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
    
    @Override
    public Check toObject() {
        Check check = super.toObject();
        Client clientObject = Client.getFromString(client, Client.ID_PREFIX);
        check.setIdClient(clientObject.getId());
        check.setClientName(clientObject.getName());
        return check;
    }

    @Override
    public void set(Check check) {
        super.set(check);
        inputDate = Format.date(check.getInputDate());
        client = Client.format(check.getIdClient(), check.getClientName(), Client.ID_PREFIX);
    }

    
}
