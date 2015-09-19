package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.lib.gui.utils.TableModel;

public class HolidayTableModel extends TableModel<Holiday, HolidayTableItem>{
    private static final long serialVersionUID = 1L;

    private String[] columns = new String[]{"Código","Data", "Descrição"};

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }
        return String.class;
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (getRows().isEmpty()) {
            throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela.");
        }
        
        HolidayTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getRow();
            case  1: return item.getDate();
            case  2: return item.getDescription();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
    @Override
    public void add(Holiday holiday, int rowIndex) {
        HolidayTableItem item = new HolidayTableItem();
        item.set(holiday);
        getRows().add(rowIndex, item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
    public void add(Holiday holiday) {
        HolidayTableItem item = new HolidayTableItem();
        item.set(holiday);
        getRows().add(getRowCount(), item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
}
