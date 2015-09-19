package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Retention;
import br.com.antoniosergius.lib.gui.utils.TableModel;

public class RetentionTableModel extends TableModel<Retention, RetentionTableItem> {

    private String[] columns = new String[]{"Cliente","Data","Bruto","Líquido","Retenção"};
    
    @Override
    public void add(Retention retention, int i) {
        RetentionTableItem item = new RetentionTableItem();
        item.set(retention);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (getRows().isEmpty()) {
            throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela.");
        }
        
        RetentionTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getClient();
            case  1: return item.getTime();
            case  2: return item.getGross();
            case  3: return item.getNet();
            case  4: return item.getRetention();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
}
