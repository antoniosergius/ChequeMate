package br.com.antoniosergius.chequemate.obj.record;

import br.com.antoniosergius.chequemate.gui.utils.CashingTableModel;
import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.tools.Days;
import java.math.BigDecimal;

public class RecordCashing extends SimpleRecord<Cashing>{
    private static final long serialVersionUID = 1L;
    
    public RecordCashing() {
    }
    
    public void recalculate(CashingTableModel model, double rate) {
        int size = getList().size();
        resetValues();
        
        BigDecimal gross;
        BigDecimal net;
        for (int i=0; i<size; i++) {
            Cashing cashing = getList().get(i);
            gross = new BigDecimal(cashing.getGross());
            int daysBetween = Days.between(Days.TODAY, cashing.getExpiration());
            net = ChequeMate.calculateInterest(gross, daysBetween, new BigDecimal(rate));
            cashing.setNet(net.doubleValue());
            cashing.setRate(rate);
            
            model.setValueAt(cashing, i);
            increase(gross, net);
        }
    }
    
    public void replaceCashing(int rowIndex, Cashing cashing, CashingTableModel model) {
        Cashing old = getList().get(rowIndex);
        model.setValueAt(cashing, rowIndex);
        getList().set(rowIndex, cashing);
        decrement(new BigDecimal(old.getGross()), new BigDecimal(old.getNet()));
        increase(new BigDecimal(cashing.getGross()), new BigDecimal(cashing.getNet()));
    }
    
    public void removeCashing(int rowIndex, CashingTableModel model) {
        getList().remove(rowIndex);
        Cashing cashingCheck = model.get(rowIndex);
        model.remove(rowIndex);
        decrement(new BigDecimal(cashingCheck.getGross()), new BigDecimal(cashingCheck.getNet()));
    }
}
