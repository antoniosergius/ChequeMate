package br.com.antoniosergius.chequemate.obj;

import java.io.Serializable;
import java.util.Objects;

public class Phone implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    private String business;
    private String home;
    private String cel;

    public Phone(String business, String home, String cel) {
        this.business = business;
        this.home = home;
        this.cel = cel;
    }

    public Phone() {
        this.business = "";
        this.home = "";
        this.cel = "";
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Phone copy() {
        return new Phone(business, home, cel);
    }
    
    @Override
    public String toString() {
        return "Telefone{" + "comercial=" + business + 
               ", residencial=" + home + 
               ", celular=" + cel + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.business, other.business)) {
            return false;
        }
        if (!Objects.equals(this.home, other.home)) {
            return false;
        }
        if (!Objects.equals(this.cel, other.cel)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.business);
        hash = 71 * hash + Objects.hashCode(this.home);
        hash = 71 * hash + Objects.hashCode(this.cel);
        return hash;
    }
    
    
}
