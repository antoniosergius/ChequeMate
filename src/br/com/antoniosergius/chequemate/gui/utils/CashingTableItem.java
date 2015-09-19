package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.util.tools.ConvertMe;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;

public class CashingTableItem extends TableItem<Cashing> {

    private String gross;
    private String net;
    private String expiration;
    private String calcDate;
    private String rate;
    private String interest;

    public CashingTableItem(int row) {
        super(row);
    }

    public CashingTableItem(String gross, String net, String expiration, String rate, int row) {
        super(row);
        this.gross = gross;
        this.net = net;
        this.expiration = expiration;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(String calcDate) {
        this.calcDate = calcDate;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
    
    @Override
    public Cashing toObject() {
        Cashing cashing = new Cashing();
        cashing.setExpiration(Convert.toGregorian(expiration));
        cashing.setGross(Deformat.andConvertDecimal(gross));
        cashing.setNet(Deformat.andConvertDecimal(net));
        cashing.setRate(Deformat.andConvertDecimal(rate));
        cashing.setCalcDate(Convert.toGregorian(calcDate));
        return cashing;
    }

    @Override
    public void set(Cashing cashing) {
        expiration = Format.date(cashing.getExpiration());
        gross = Format.decimal(cashing.getGross());
        net = Format.decimal(cashing.getNet());
        rate = Format.decimal(cashing.getRate());
        calcDate = Format.date(cashing.getCalcDate());
        interest = Format.decimal(cashing.getInterest());
    }

    
}
