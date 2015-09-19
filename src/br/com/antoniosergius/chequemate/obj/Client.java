package br.com.antoniosergius.chequemate.obj;

import br.com.antoniosergius.lib.tools.Format;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Client implements Comparable<Client>, Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final int MAX = 9999;
    public static final int MIN = 1;
    public static final int ID_SUFFIX = -5;
    public static final int ID_PREFIX = -4;
    
    private int id;
    private String name;
    private String registryNumber;
    private Address address;
    private Phone phones;
    private String obs;
    private String email;
    private GregorianCalendar birthDate;
    private double rate;

    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(int id, String name, String registryNumber, Address address, Phone phones, String obs) {
        this.id = id;
        this.name = name;
        this.registryNumber = registryNumber;
        this.address = address;
        this.phones = phones;
        this.obs = obs;
    }

    public Client(int id, String name, String registryNumber, Address address, 
            Phone phones, String obs, String email, GregorianCalendar birthDate, double rate) {
        this.id = id;
        this.name = name;
        this.registryNumber = registryNumber;
        this.address = address;
        this.phones = phones;
        this.obs = obs;
        this.email = email;
        this.birthDate = birthDate;
        this.rate = rate;
    }

    public Client(String name, String registryNumber, Address address, Phone phones, String obs, String email) {
        this.name = name;
        this.registryNumber = registryNumber;
        this.address = address;
        this.phones = phones;
        this.obs = obs;
        this.email = email;
    }
    
    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhones() {
        return phones;
    }

    public void setPhones(Phone phones) {
        this.phones = phones;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.registryNumber, other.registryNumber)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phones, other.phones)) {
            return false;
        }
        if (!Objects.equals(this.obs, other.obs)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (Double.doubleToLongBits(this.rate) != Double.doubleToLongBits(other.rate)) {
            return false;
        }
        return true;
    }

    
    

    public Client copy() {
        return new Client(id, name, registryNumber, address.copy(), 
                phones.copy(), obs, email, birthDate, rate);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.registryNumber);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + Objects.hashCode(this.phones);
        hash = 37 * hash + Objects.hashCode(this.obs);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.birthDate);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.rate) ^ (Double.doubleToLongBits(this.rate) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", registryNumber=" + registryNumber +
                ", address=" + address + ", phones=" + phones + ", obs=" + obs +
                ", email=" + email + ", birthDate=" + birthDate + ", rate=" + rate + '}';
    }
    
    
    
    @Override
    public int compareTo(Client other) {
        return this.getName().compareTo(other.getName());
    }
    
    public static int getId(String str, int position) {
        if (!str.contains(" - ")) {
            throw new IllegalArgumentException("String inválida.");
        }
        String client[] = str.split(" - ");
        switch (position) {
            case ID_PREFIX: return Integer.parseInt(client[0]);
            case ID_SUFFIX : return Integer.parseInt(client[client.length-1]);
            default: throw new IllegalArgumentException("Posição inválida.");
        }
    }
    
    public static Client getFromString(String str, int position) {
        if (!str.contains(" - ")) {
            throw new IllegalArgumentException("String inválida.");
        }
        String clientInfo[] = str.split(" - ");
        Client client;
        StringBuilder name = new StringBuilder();
        int size = clientInfo.length;
        if (position == ID_SUFFIX) {
            for (int i=0; i<size-1; i++) {
                name.append(clientInfo[i]);
            }
            client = new Client(Integer.parseInt(clientInfo[size-1]), name.toString());
        } else if (position == ID_PREFIX){
            for (int i=1; i<size; i++) {
                name.append(clientInfo[i]);
            }
            client = new Client(Integer.parseInt(clientInfo[0]), name.toString());
        } else {
            throw new IllegalArgumentException("Posição inválida.");
        }
        return client;
    }
    
    public String getFirstName() {
        String temp = name;
        if (temp.contains(" - ")) {
            temp = temp.replaceAll(" - ", " ");
        }
        String nameSplit[] = temp.split(" ");
        String firstName = nameSplit[0];
        if (nameSplit.length > 1) {
            firstName += " "+nameSplit[1];
        }
        return firstName;
    }
    
    public static String format(int id, String name, int position) {
        String client = name;
        switch (position) {
            case Client.ID_PREFIX : return Format.clientId(id)+" - "+client;
            case Client.ID_SUFFIX : return client+" - "+Format.clientId(id);
            default : throw new IllegalArgumentException("Posição inválida");
        }
    }
}
