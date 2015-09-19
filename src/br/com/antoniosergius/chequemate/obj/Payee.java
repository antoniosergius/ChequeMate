package br.com.antoniosergius.chequemate.obj;

import java.io.Serializable;
import java.util.Objects;

public class Payee implements Comparable<Payee>, Serializable {
    private static final long serialVersionUID = 1L;    
    
    private String name;
    private String registryNumber;

    public Payee() {
        name = "";
        registryNumber = "";
    }
    
    public Payee(String name, String registryNumber) {
        this.name = name;
        this.registryNumber = registryNumber;
    }

    public Payee(String registryNumber) {
        this.name = "";
        this.registryNumber = registryNumber;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.registryNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Payee other = (Payee) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.registryNumber, other.registryNumber)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public int compareTo(Payee o) {
        return this.getName().compareTo(o.getName());
    }
    
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Payee{");
        tmp.append("name=");
        tmp.append(name);
        tmp.append(", registryNumber=");
        tmp.append(registryNumber);
        tmp.append('}');
        return tmp.toString();
    }
    
    public boolean isEmpty() {
        return "".equals(name) && "".equals(registryNumber);
    }
    
    
}
