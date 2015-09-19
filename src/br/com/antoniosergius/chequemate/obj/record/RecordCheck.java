package br.com.antoniosergius.chequemate.obj.record;

import br.com.antoniosergius.chequemate.gui.utils.RecordTableModel;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.tools.Days;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;


public class RecordCheck extends SimpleRecord<Check> {
    private static final long serialVersionUID = 1L;
    private int idClient;
    private GregorianCalendar baseDate;

    public RecordCheck() {
        super();
        idClient = 0;
        baseDate = new GregorianCalendar();
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public GregorianCalendar getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Argumento nulo");
        }
        baseDate.setTime(date);
    }
    
    public void setBaseDate(GregorianCalendar dataBaseCalculo) {
        this.baseDate = dataBaseCalculo;
    }
    
    public void recalculate(RecordTableModel recordModel, double rate) {
        int size = super.getList().size();
        resetValues();
        
        BigDecimal gross;
        BigDecimal net;
        for (int i=0; i<size; i++) {
            Check check = super.getList().get(i);
            gross = new BigDecimal(check.getGross());
            int daysBetween = Days.between(baseDate, check.getCalcDate());
            net = ChequeMate.calculateInterest(gross, daysBetween, new BigDecimal(rate));
            
            check.setNet(net.doubleValue());
            check.setRate(rate);
            
            recordModel.setValueAt(check, i);
            super.increase(gross, net);
        }
    }
    
    public void recalculate() {
        int size = getList().size();
        resetValues();
        
        BigDecimal gross;
        BigDecimal net;
        for (int i=0; i<size; i++) {
            Check check = getList().get(i);
            gross = new BigDecimal(check.getGross());
            int daysBetween = Days.between(baseDate, check.getCalcDate());
            net = ChequeMate.calculateInterest(gross, daysBetween, new BigDecimal(check.getRate()));
            
            check.setNet(net.doubleValue());
            increase(gross, net);
        }
    }
    
    public void recalculate(RecordTableModel recordModel) {
        int size = getList().size();
        resetValues();
        
        BigDecimal gross;
        BigDecimal net;
        for (int i=0; i<size; i++) {
            Check check = getList().get(i);
            gross = new BigDecimal(check.getGross());
            int daysBetween = Days.between(baseDate, check.getCalcDate());
            net = ChequeMate.calculateInterest(gross, daysBetween, new BigDecimal(check.getRate()));
            check.setNet(net.doubleValue());
            replaceCheck(i, check, recordModel);
            increase(gross, net);
        }
    }
    
    public void replaceCheck(int rowIndex, Check check, RecordTableModel recordModel) {
        Check old = getList().get(rowIndex);
        recordModel.setValueAt(check, rowIndex);
        getList().set(rowIndex, check);
        decrement(new BigDecimal(old.getGross()), new BigDecimal(old.getNet()));
        increase(new BigDecimal(check.getGross()), new BigDecimal(check.getNet()));
    }
    
    public void addPayeeSuffix(int rowIndex, String suffix, RecordTableModel recordModel) {
        Check check = getList().get(rowIndex);
        String payeeName = check.getPayee().getName();
        if (payeeName.contains(" ("+suffix+")")) {
            return;
        }
        String newName = payeeName +" ("+suffix+")";
        if (newName.length()>74) {
            newName = newName.substring(0, 74);
        }
        check.getPayee().setName(newName);
        recordModel.setValueAt(check, rowIndex);
    }
    
    public void removeCheck(int rowIndex, RecordTableModel model) {
        getList().remove(rowIndex);
        Check check = model.get(rowIndex);
        model.remove(rowIndex);
        decrement(new BigDecimal(check.getGross()), new BigDecimal(check.getNet()));
    }
}
