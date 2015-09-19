package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.lib.gui.utils.TableModel;

public class CashingTableModel extends TableModel<Cashing, CashingTableItem> {
    private static final long serialVersionUID = 1L;
    
    private String[] columns = new String[]{"#","Bruto","Líquido","Juros","Data Boa","Data Cálculo","Taxa"};

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public void add(Cashing cashing, int rowIndex) {
        CashingTableItem item = new CashingTableItem(rowIndex+1);
        item.set(cashing);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (getRows().isEmpty()) {
            throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela.");
        }
        CashingTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getRow();
            case  1: return item.getGross();
            case  2: return item.getNet();
            case  3: return item.getInterest();    
            case  4: return item.getExpiration();   
            case  5: return item.getCalcDate();
            case  6: return item.getRate();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
    private void renumerateRows() {
        int rowCount = super.getRows().size();
        for (int i=0; i<rowCount; i++) {
            CashingTableItem item = super.getRows().get(i);
            item.setRow(i+1);
        }
        fireTableRowsUpdated(0, rowCount-1);
    }
    
    @Override
    public void remove(int rowIndex) {
        super.remove(rowIndex);
        renumerateRows();
    }
    
}
