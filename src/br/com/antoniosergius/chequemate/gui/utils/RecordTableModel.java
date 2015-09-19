package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.lib.gui.utils.TableModel;

public class RecordTableModel extends TableModel<Check, RecordTableItem>{
    private static final long serialVersionUID = 1L;
    
    private String[] columns = new String[]{"#","Número","Banco","Agência",
    "Valor","Líquido","CPF/CNPJ","Emitente","Data Boa","Data Cálc.","Taxa"};

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
        if (columnIndex==0) {
            return Integer.class;
        }
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (getRows().isEmpty()) {
            throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela.");
        }
        
        RecordTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getRow();
            case  1: return item.getNumber();
            case  2: return item.getBank();
            case  3: return item.getAgency();
            case  4: return item.getGross();
            case  5: return item.getNet();
            case  6: return item.getRegistryNumber();
            case  7: return item.getPayee();
            case  8: return item.getExpiration();
            case  9: return item.getCalcDate();
            case 10: return item.getRate();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
    @Override
    public void add(Check check, int rowIndex) {
        RecordTableItem item = new RecordTableItem(rowIndex+1);
        item.set(check);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
    private void renumerateRows() {
        int rowCount = super.getRows().size();
        for (int i=0; i<rowCount; i++) {
            RecordTableItem item = super.getRows().get(i);
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
