package br.com.antoniosergius.chequemate.obj;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Serginho
 */
public class Address implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    private String street;
    private String district;
    private String city;
    private String state;
    private String zipcode;

    public Address(String street, String district, String city, String state) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public Address(String street, String district, String city, String state, String zipcode) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Address() {
    }

    public Address(String street, String district) {
        this.street = street;
        this.district = district;
        this.city = "Divinópolis";
        this.state = "MG";
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String cep) {
        this.zipcode = cep;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String estado) {
        this.state = estado;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + street + 
               ", bairro=" + district + 
               ", cidade=" + city + 
               ", estado=" + state + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.district, other.district)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipcode, other.zipcode)) {
            return false;
        }
        return true;
    }

    public Address copy() {
        return new Address(street, district, city, state, zipcode);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.street);
        hash = 89 * hash + Objects.hashCode(this.district);
        hash = 89 * hash + Objects.hashCode(this.city);
        hash = 89 * hash + Objects.hashCode(this.state);
        hash = 89 * hash + Objects.hashCode(this.zipcode);
        return hash;
    }
    
    
}
