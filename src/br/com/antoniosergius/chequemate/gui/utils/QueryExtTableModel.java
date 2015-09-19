package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.lib.gui.utils.TableModel;
import br.com.antoniosergius.lib.tools.Deformat;
import java.util.ArrayList;

public class QueryExtTableModel extends TableModel<Check, QueryExtTableItem>{

    private double grossAmount;
    private final String[] columns = new String[]{"Emitente","CPF/CNPJ","Banco",
    "Agência","Número","Valor","Data Boa","Cliente","Data Entrada", "Observação"};

    public QueryExtTableModel(ArrayList<QueryExtTableItem> rows) {
        super(rows);
        grossAmount = sumItens();
    }

    public QueryExtTableModel() {
        grossAmount = 0.0;
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
        QueryExtTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getPayee();
            case  1: return item.getRegistryNumber();
            case  2: return item.getBank();
            case  3: return item.getAgency();
            case  4: return item.getNumber();
            case  5: return item.getGross();
            case  6: return item.getExpiration();
            case  7: return item.getClient();
            case  8: return item.getInputDate();
            case  9: return item.getObs();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }

    @Override
    public void add(Check check, int rowIndex) {
        QueryExtTableItem item = new QueryExtTableItem();
        item.set(check);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }
    
    private double sumItens() {
        double sum = 0.0;
        for (QueryExtTableItem item : getRows()) {
            sum += Deformat.andConvertDecimal(item.getGross());
        }
        return sum;
    }
    
    public double getGrossAmount() {
        if (grossAmount == 0.0 && !isEmpty()) {
            return sumItens();
        } else {
            return grossAmount;
        }
    }
    
    public void removeInterval(int selected[]) {
        for (int i=0; i<selected.length; i++) {
            getRows().remove(selected[0]);
        }
        fireTableRowsDeleted(selected[0], selected[selected.length-1]);
    }
    
}
