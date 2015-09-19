package br.com.antoniosergius.chequemate.obj.record;

import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.obj.Check;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SimpleRecord<SimpleType extends Object> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private BigDecimal grossAmount;
    private BigDecimal netAmount;
    private BigDecimal retention;
    private ArrayList<SimpleType> list;

    public SimpleRecord() {
        this.grossAmount = BigDecimal.ZERO;
        this.netAmount = BigDecimal.ZERO;
        this.retention = BigDecimal.ZERO;
        this.list = new ArrayList<>();
    }
    
    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getRetention() {
        return retention;
    }

    public void setRetention(BigDecimal retention) {
        this.retention = retention;
    }

    public ArrayList<SimpleType> getList() {
        return list;
    }

    public boolean isEmpty() {
        return grossAmount == BigDecimal.ZERO &&
               netAmount == BigDecimal.ZERO &&
               retention == BigDecimal.ZERO &&
               list.isEmpty();
    }
    
    public void increase(BigDecimal gross, BigDecimal net) {
        grossAmount = grossAmount.add(gross);
        netAmount = netAmount.add(net);
        retention = grossAmount.subtract(netAmount);
    }
    
    public void decrement(BigDecimal gross, BigDecimal net) {
        grossAmount = grossAmount.subtract(gross);
        netAmount = netAmount.subtract(net);
        retention = grossAmount.subtract(netAmount);
    }
    
    public void resetValues() {
        this.retention = BigDecimal.ZERO;
        this.grossAmount = BigDecimal.ZERO;
        this.netAmount = BigDecimal.ZERO;
    }
    
    public void setList(ArrayList<SimpleType> list) {
        this.list = list;
        resetValues();
        for (SimpleType s : list) {
            if (s instanceof Cashing) {
                Cashing cash = (Cashing)s;
                increase(new BigDecimal(cash.getGross()), new BigDecimal(cash.getNet()));
            } else if (s instanceof Check) {
                Check check = (Check)s;
                increase(new BigDecimal(check.getGross()), new BigDecimal(check.getNet()));
            }
        }
    }
    
    /**
     * Atualiza apenas o valor total bruto, liquido e a retencao do desconto.
     * Os cheques permanecem com os respectivos valores liquidos.
     */
    public void updateAmount() {
        int size = list.size();
        resetValues();
        
        BigDecimal gross = BigDecimal.ZERO;
        BigDecimal net = BigDecimal.ZERO;
        for (int i=0; i<size; i++) {
            SimpleType s = list.get(i);
            if (s instanceof Cashing) {
                Cashing cash = (Cashing)s;
                gross = new BigDecimal(cash.getGross());
                net = new BigDecimal(cash.getNet());
            } else if (s instanceof Check) {
                Check check = (Check)s;
                gross = new BigDecimal(check.getGross());
                net = new BigDecimal(check.getNet());
            }
            increase(gross, net);
        }
    }
    
    public void replaceInList(int rowIndex, SimpleType simpleObj) {
        if (simpleObj instanceof Cashing) {
            Cashing old = (Cashing)list.get(rowIndex);
            list.set(rowIndex, simpleObj);
            decrement(new BigDecimal(old.getGross()), new BigDecimal(old.getNet()));
        } else if (simpleObj instanceof Check) {
            Check old = (Check)list.get(rowIndex);
            list.set(rowIndex, simpleObj);
            decrement(new BigDecimal(old.getGross()), new BigDecimal(old.getNet()));
        }
    }
}
