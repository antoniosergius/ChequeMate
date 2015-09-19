package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.lib.gui.utils.TableModel;
import java.util.ArrayList;

public class ClientTableModel extends TableModel<Client, ClientTableItem>{
    private static final long serialVersionUID = 1L;
    
    private String[] columns = new String[]{"Código","Nome"};

    public ClientTableModel() {
    }

    public ClientTableModel(ArrayList<ClientTableItem> rows) {
        super(rows);
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
    public void add(Client client, int rowIndex) {
        ClientTableItem item = new ClientTableItem();
        item.set(client);
        getRows().add(item);
        int lastRow = getRowCount()-1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (getRows().isEmpty()) {
            throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela.");
        }
        ClientTableItem item = getRows().get(rowIndex);
        switch(columnIndex) {
            case  0: return item.getId();
            case  1: return item.getName();
            default: throw new IndexOutOfBoundsException("Posição fora do intervalo da tabela."); 
        }
    }
    
    
    
}
