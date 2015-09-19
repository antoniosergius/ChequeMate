package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import java.util.GregorianCalendar;

public class PayeeExtTableItem extends TableItem<PayeeExt> {
    
    private String name;
    private String registryNumber;
    private String higherCheckValue;
    private String firstInputDate;
    private String lastInputDate;
    private String numChecks;

    public PayeeExtTableItem() {
    }

    public PayeeExtTableItem(int row) {
        super(row);
    }

    public PayeeExtTableItem(int id, String name, String registryNumber, 
            String higherCheckValue, String firstInputDate, String lastInputDate, String numChecks) {
        super(id);
        this.name = name;
        this.registryNumber = registryNumber;
        this.higherCheckValue = higherCheckValue;
        this.firstInputDate = firstInputDate;
        this.lastInputDate = lastInputDate;
        this.numChecks = numChecks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getHigherCheckValue() {
        return higherCheckValue;
    }

    public void setHigherCheckValue(String higherCheckValue) {
        this.higherCheckValue = higherCheckValue;
    }

    public String getFirstInputDate() {
        return firstInputDate;
    }

    public void setFirstInputDate(String firstInputDate) {
        this.firstInputDate = firstInputDate;
    }

    public String getLastInputDate() {
        return lastInputDate;
    }

    public void setLastInputDate(String lastInputDate) {
        this.lastInputDate = lastInputDate;
    }

    public String getNumChecks() {
        return numChecks;
    }

    public void setNumChecks(String numChecks) {
        this.numChecks = numChecks;
    }
    
    @Override
    public PayeeExt toObject() {
        double higher = Deformat.andConvertDecimal(higherCheckValue);
        GregorianCalendar firstInput = Convert.toGregorian(firstInputDate);
        GregorianCalendar lastInput = Convert.toGregorian(lastInputDate);
        int totChecks = Integer.parseInt(numChecks);
        String unformattedRegistry = Deformat.CPForCNPJ(registryNumber);
        PayeeExt obj = new PayeeExt(name, unformattedRegistry, getRow(), higher, firstInput, lastInput, totChecks);
        return obj;
    }

    @Override
    public void set(PayeeExt payee) {
        super.setRow(payee.getId());
        name = payee.getName();
        registryNumber = Format.CPForCNPJ(payee.getRegistryNumber());
        higherCheckValue = Format.decimal(payee.getHigherCheckValue());
        firstInputDate = Format.date(payee.getFirstCheckInput());
        lastInputDate = Format.date(payee.getLastCheckInput());
        numChecks = String.valueOf(payee.getCheckCount());
    }
    
}
