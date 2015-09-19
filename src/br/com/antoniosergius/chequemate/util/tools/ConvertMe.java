package br.com.antoniosergius.chequemate.util.tools;

import br.com.antoniosergius.chequemate.obj.Address;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.chequemate.obj.Phone;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Days;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ConvertMe {
    
    public static ArrayList<Check> toCheckList(ResultSet result) throws SQLException {
        ArrayList<Check> checkList = new ArrayList<>();
        do {
            int number = result.getInt("numero");
            int bank = result.getInt("banco");
            int id = result.getInt("idCheque");
            int agency = result.getInt("agencia");
            double gross = result.getDouble("valor");
            double net = result.getDouble("valorLiquido");
            Payee payee = new Payee(result.getString("emitente").toUpperCase(),
                    result.getString("cadastro"));
            GregorianCalendar expiration = new GregorianCalendar();
            expiration.setTime(result.getDate("dataBoa"));
            GregorianCalendar inputDate = new GregorianCalendar();
            inputDate.setTime(result.getTimestamp("dataEntrada"));
            int idClient = result.getInt("fkCliente");
            String clientName = result.getString("nome");
            double rate = result.getDouble("taxa");
            String obs = result.getString("obs");
            
            Check check = new Check(number, bank, agency, gross, net,
                    payee, expiration, inputDate, idClient);
            
            GregorianCalendar calcDate = new GregorianCalendar();
            java.sql.Date date = result.getDate("dataCalculo");
            if (date!=null) {
                calcDate.setTime(date);
                check.setCalcDate(calcDate);
            }
            check.setRate(rate);
            check.setClientName(clientName);
            check.setId(id);
            check.setObs(obs);
            
            checkList.add(check);
        } while (result.next());
        return checkList;
    }
    
    
    
    public static String nullToString(String str) {
        return str == null ? "" : str.trim();
    }
    
    public static Client toClient(int id, ResultSet result) throws SQLException {
        String name = nullToString(result.getString("nome"));
        String registryNumber = nullToString(result.getString("cadastro"));
        String district = nullToString(result.getString("bairro"));
        String city = nullToString(result.getString("cidade"));
        String state = nullToString(result.getString("estado"));
        String street = nullToString(result.getString("logradouro"));
        String celPhone = nullToString(result.getString("telCelular"));
        String homePhone = nullToString(result.getString("telResidencial"));
        String businessPhone = nullToString(result.getString("telComercial"));
        String zipcode = nullToString(result.getString("cep"));
        String obs = nullToString(result.getString("observacao"));
        String email = nullToString(result.getString("email"));
        double rate = result.getDouble("taxa");
        
        Address address = new Address(street, district, city, state, zipcode);
        Phone phones = new Phone(businessPhone, homePhone, celPhone);
        
        Client client = new Client(id, name, registryNumber, address, phones, obs);
        client.setRate(rate);
        client.setEmail(email);
        
        java.sql.Date birthDate = result.getDate("dataNascimento");
        GregorianCalendar date = new GregorianCalendar();
        if (birthDate!=null) {
            date.setTime(birthDate);
            client.setBirthDate(date);
        }
        return client;      
    }
    
    public static Client toClient(ResultSet result) throws SQLException {
        int id = result.getInt("idCliente");
        return ConvertMe.toClient(id, result);     
    }
    
    @SuppressWarnings("unchecked")
    public static ArrayList<Client> toClientList(ResultSet result) throws SQLException{
        ArrayList<Client> list = new ArrayList<>();
        Client client;
        do {
            client = ConvertMe.toClient(result);
            list.add(client);
        } while (result.next());
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public static HashMap<String, Client> toClientMap(ResultSet result) throws SQLException{
        HashMap<String, Client> map = new HashMap<>();
        Client client;
        do {
            client = ConvertMe.toClient(result);
            map.put(client.getName(), client);
        } while (result.next());
        return map;
    }
    
    public static ArrayList<Holiday> toHolidayList(ResultSet result) throws SQLException{
        StringBuilder builder = new StringBuilder();
        ArrayList<Holiday> list = new ArrayList<>();
        do {
            builder.append(result.getInt(1)).append("/");
            builder.append(result.getInt(2)).append("/");
            Integer year = result.getInt(3);
            if (year != 0) {
                builder.append(String.valueOf(year));
            } else {
                builder.append(Days.TODAY.get(GregorianCalendar.YEAR));
            }
            GregorianCalendar date = Convert.toGregorian(builder.toString());
            String description = result.getString(4);

            list.add(new Holiday(date, description));
            builder.delete(0, builder.length());
        } while (result.next());   
        return list;
    }
    
    public static Payee toPayee(ResultSet result) throws SQLException {
        String name = result.getString("nome");
        String registryNumber = Convert.nullToString(result.getString("cadastro"));
        return new Payee(name, registryNumber);
    }
    
    public static ArrayList<Payee> toPayeeList(ResultSet result) throws SQLException {
        ArrayList<Payee> list = new ArrayList<>();
        do {
            list.add(ConvertMe.toPayee(result));
        } while (result.next());
        return list;
        
    }
    
    public static PayeeExt toPayeeExt(ResultSet result) throws SQLException {
        int id = result.getInt("idEmitente");
        String name = result.getString("nome");
        String registryNumber = Convert.nullToString(result.getString("cadastro"));
        double highestCheckValue = result.getDouble("maiorValor");
        GregorianCalendar firstInput = new GregorianCalendar();
        GregorianCalendar lastInput = new GregorianCalendar();
        Date firstDate = result.getDate("dataPrimeiro");
        Date lastDate = result.getDate("dataUltimo");
        if (firstDate != null) {
            firstInput.setTime(firstDate);
        }
        if (lastDate != null) {
            lastInput.setTime(lastDate);
        }
        int checkCount = result.getInt("numCheques");
        
        return new PayeeExt(name, registryNumber, id,  
                highestCheckValue, firstInput, lastInput, checkCount);
    }

    public static ArrayList<PayeeExt> toPayeeExtList(ResultSet result) throws SQLException {
        ArrayList<PayeeExt> payeeList = new ArrayList<>();
        do {
            payeeList.add(ConvertMe.toPayeeExt(result));
        } while(result.next());
        return payeeList;
    }
    
    public static HashMap<String, Payee> toPayeeExtMap(ResultSet result) throws SQLException {
        HashMap<String, Payee> payeeMap = new HashMap<>();
        Payee payee;
        do {
            payee = ConvertMe.toPayeeExt(result);
            payeeMap.put(payee.getRegistryNumber(), payee);
        } while(result.next());
        return payeeMap;
    }
    
    
}
