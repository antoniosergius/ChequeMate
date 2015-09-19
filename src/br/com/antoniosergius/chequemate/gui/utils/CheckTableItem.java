package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;

public class CheckTableItem extends TableItem<Check>{

    private String number;
    private String bank;
    private String agency;
    private String gross;
    private String payee;
    private String registryNumber;
    private String expiration;

    public CheckTableItem() {
    }
    
    public CheckTableItem(int row) {
        super(row);
    }
    
    public CheckTableItem(String number, String bank, String agency, String gross,
            String registryNumber, String expiration, int row) {
        super(row);
        this.number = number;
        this.bank = bank;
        this.agency = agency;
        this.gross = gross;
        this.registryNumber = registryNumber;
        this.expiration = expiration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    
    
    
    @Override
    public Check toObject() {
        Check check = new Check();
        check.setNumber(Integer.parseInt(number));
        check.setBank(Integer.parseInt(bank));
        check.setAgency(Integer.parseInt(agency));
        check.setPayee(new Payee(payee, Deformat.CPForCNPJ(registryNumber)));
        check.setGross(Deformat.andConvertDecimal(gross));
        check.setExpiration(Convert.toGregorian(expiration));
        return check;
    }

    @Override
    public void set(Check check) {
        number = Format.checkNumber(check.getNumber());
        bank = Format.bank(check.getBank());
        agency = Format.agency(check.getAgency());
        gross = Format.decimal(check.getGross());
        registryNumber = Format.CPForCNPJ(check.getPayee().getRegistryNumber());
        payee = check.getPayee().getName();
        expiration = Format.date(check.getExpiration());
    }
    
}
