package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Retention;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;

public class RetentionTableItem extends TableItem<Retention> {

    private String client;
    private String gross;
    private String net;
    private String retention;
    private String time;
    private String fileName;

    public RetentionTableItem() {
    }
    
    public RetentionTableItem(String client, String gross, String net, String retention, String time, 
            String fileName) {
        this.client = client;
        this.gross = gross;
        this.net = net;
        this.retention = retention;
        this.time = time;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getRetention() {
        return retention;
    }

    public void setRetention(String retention) {
        this.retention = retention;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public Retention toObject() {
        Retention objRetention = new Retention();
        objRetention.setClient(client);
        objRetention.setGross(Deformat.andConvertDecimal(gross));
        objRetention.setNet(Deformat.andConvertDecimal(net));
        objRetention.setRetention(Deformat.andConvertDecimal(retention));
        objRetention.setTime(Convert.toGregorianTimestamp(time));
        objRetention.setFileName(fileName);
        return objRetention;
    }

    @Override
    public void set(Retention retention) {
        client = retention.getClient();
        gross = Format.decimal(retention.getGross());
        net = Format.decimal(retention.getNet());
        this.retention = Format.decimal(retention.getRetention());
        time = Format.timestamp(retention.getTime());
        fileName = retention.getFileName();
    }
    
}
