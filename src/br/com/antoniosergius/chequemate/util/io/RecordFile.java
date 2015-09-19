package br.com.antoniosergius.chequemate.util.io;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.lib.tools.Format;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RecordFile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Client client;
    private GregorianCalendar inputTime;
    private ArrayList<Check> checkList;
    
    public RecordFile(Client client, GregorianCalendar inputTime, 
            ArrayList<Check> checkList) {
        this.client = client;
        this.inputTime = inputTime;
        this.checkList = checkList;
    }
    

    public Client getClient() {
        return client;
    }

    public GregorianCalendar getInputTime() {
        return inputTime;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setInputTime(GregorianCalendar inputTime) {
        this.inputTime = inputTime;
    }

    public ArrayList<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(ArrayList<Check> checkList) {
        this.checkList = checkList;
    }
    
    public String createFileName() {
        StringBuilder name = new StringBuilder();
        name.append(Format.clientId(client.getId()));
        name.append("-");
        name.append(Format.date("dd.MM.yyyy~HH.mm", inputTime));
        name.append(".as");
        return name.toString();
    }
    
    
}
