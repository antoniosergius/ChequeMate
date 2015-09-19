package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.lib.gui.utils.TableModel;

public class PayeeExtTableModel extends TableModel<PayeeExt, PayeeExtTableItem>{
    private static final long serialVersionUID = 1L;

    private String[] columns = new String[]{"Nome","CPF/CNPJ","Data Primeiro",
        "Data Último","Maior Valor","Contador"};

    
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
        
        PayeeExtTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getName();
            case  1: return item.getRegistryNumber();
            case  2: return item.getFirstInputDate();
            case  3: return item.getLastInputDate();
            case  4: return item.getHigherCheckValue();
            case  5: return item.getNumChecks();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
    @Override
    public void add(PayeeExt payee, int i) {
        PayeeExtTableItem item = new PayeeExtTableItem();
        item.set(payee);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
    public void add(PayeeExt payee) {
        PayeeExtTableItem item = new PayeeExtTableItem();
        item.set(payee);
        getRows().add(getRowCount(), item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
}
