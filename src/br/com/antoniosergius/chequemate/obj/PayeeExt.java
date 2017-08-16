package br.com.antoniosergius.chequemate.obj;

import br.com.antoniosergius.lib.tools.Format;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PayeeExt extends Payee{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private double higherCheckValue;
    private GregorianCalendar firstCheckInput;
    private GregorianCalendar lastCheckInput;
    private int checkCount;
    private ArrayList<String> clientList;

    public PayeeExt(String name, String registryNumber) {
        super(name, registryNumber);
    }

    public PayeeExt(String name, String registryNumber, int id, double higherCheckValue, 
            GregorianCalendar firstCheckInput, GregorianCalendar lastCheckInput, int checkCount) {
        super(name, registryNumber);
        this.id = id;
        this.higherCheckValue = higherCheckValue;
        this.firstCheckInput = firstCheckInput;
        this.lastCheckInput = lastCheckInput;
        this.checkCount = checkCount;
    }

    public PayeeExt(String name, String registryNumber, double higherCheckValue, GregorianCalendar firstCheckInput, 
            GregorianCalendar lastCheckInput, int checkCount ) {
        super(name, registryNumber);
        this.higherCheckValue = higherCheckValue;
        this.firstCheckInput = firstCheckInput;
        this.lastCheckInput = lastCheckInput;
        this.checkCount = checkCount;
    }

    public PayeeExt(String name, String registryNumber, double higherCheckValue) {
        super(name, registryNumber);
        this.higherCheckValue = higherCheckValue;
        this.firstCheckInput = new GregorianCalendar();
        this.lastCheckInput = new GregorianCalendar();
        this.checkCount = 1;
    }

   public PayeeExt(String name, String registryNumber, double higherCheckValue, 
           GregorianCalendar firstCheckInput, GregorianCalendar lastCheckInput, int checkCount,
           ArrayList<String> clientList) {
      super(name, registryNumber);
      this.higherCheckValue = higherCheckValue;
      this.firstCheckInput = firstCheckInput;
      this.lastCheckInput = lastCheckInput;
      this.checkCount = checkCount;
      this.clientList = clientList;
   }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHigherCheckValue() {
        return higherCheckValue;
    }

    public void setHigherCheckValue(double higherCheckValue) {
        this.higherCheckValue = higherCheckValue;
    }

    public GregorianCalendar getFirstCheckInput() {
        return firstCheckInput;
    }

    public void setFirstCheckInput(GregorianCalendar firstCheckInput) {
        this.firstCheckInput = firstCheckInput;
    }

    public GregorianCalendar getLastCheckInput() {
        return lastCheckInput;
    }

    public void setLastCheckInput(GregorianCalendar lastCheckInput) {
        this.lastCheckInput = lastCheckInput;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        this.checkCount = checkCount;
    }

   public ArrayList<String> getClientList() {
      return clientList;
   }

   public void setClientList(ArrayList<String> clientList) {
      this.clientList = clientList;
   }

    
    
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("PayeeExt{");
        tmp.append(super.toString());
        tmp.append(", id=");
        tmp.append(id);
        tmp.append(", higherCheckValue=");
        tmp.append(higherCheckValue);
        tmp.append(", firstCheckInput=");
        tmp.append(Format.timestamp(firstCheckInput));
        tmp.append(", lastCheckInput=");
        tmp.append(Format.timestamp(lastCheckInput));
        tmp.append(", checkCount=");
        tmp.append(checkCount);
        tmp.append('}');
        return tmp.toString();
    }
    
    
}
