package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.util.tools.ConvertMe;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;

public class RecordTableItem extends CheckTableItem{

    
    private String net;
    private String calcDate;
    private String rate;
    
    public RecordTableItem(int row) {
        super(row);
    }

    public RecordTableItem(String net, String calcDate, String rate, String number, String bank, String agency, String gross, String registryNumber, String expiration, int row) {
        super(number, bank, agency, gross, registryNumber, expiration, row);
        this.net = net;
        this.calcDate = calcDate;
        this.rate = rate;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(String calcDate) {
        this.calcDate = calcDate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    

    @Override
    public Check toObject() {
        Check check = super.toObject();
        check.setNet(Deformat.andConvertDecimal(net));
        check.setCalcDate(Convert.toGregorian(calcDate, "dd/MM/yy"));
        check.setRate(Deformat.andConvertDecimal(rate));
        return check;
    }


    @Override
    public void set(Check check) {
        super.set(check);
        net = Format.decimal(check.getNet());
        calcDate = Format.date("dd/MM/yy", check.getCalcDate());
        rate = Format.decimal(check.getRate());
    }
    
}
