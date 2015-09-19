package br.com.antoniosergius.chequemate.gui.utils;

import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.lib.gui.utils.TableItem;
import br.com.antoniosergius.lib.tools.Format;

public class ClientTableItem extends TableItem<Client>{
    
    private String id;
    private String name;

    public ClientTableItem() {
    }

    public ClientTableItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Client toObject() {
        Client client = new Client();
        client.setId(Integer.parseInt(id));
        client.setName(name);
        return client;
    }

    @Override
    public void set(Client client) {
        id = Format.clientId(client.getId());
        name = client.getName();
    }
    
}
