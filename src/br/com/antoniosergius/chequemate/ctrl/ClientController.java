package br.com.antoniosergius.chequemate.ctrl;

import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.util.tools.ConvertMe;
import br.com.antoniosergius.chequemate.util.tools.Sort;
import br.com.antoniosergius.lib.tools.Format;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ClientController {

    private Connection conn;

    public ClientController(Connection conn) {
        this.conn = conn;
    }
    
    public void insert(Client client) throws SQLException {
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO cliente (nome, logradouro, bairro, cidade, estado ");
        sqlBuilder.append(", cep, telResidencial, telComercial, telCelular , cadastro, observacao, email, dataNascimento, taxa) ");
        sqlBuilder.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        try (PreparedStatement pst = conn.prepareStatement(sqlBuilder.toString(), Statement.RETURN_GENERATED_KEYS)) {
        
            pst.setString(1, client.getName());
            pst.setString(2, client.getAddress().getStreet());
            pst.setString(3, client.getAddress().getDistrict());
            pst.setString(4, client.getAddress().getCity());
            pst.setString(5, client.getAddress().getState());
            pst.setString(6, client.getAddress().getZipcode());
            pst.setString(7, client.getPhones().getHome());
            pst.setString(8, client.getPhones().getBusiness());
            pst.setString(9, client.getPhones().getCel());
            pst.setString(10, client.getRegistryNumber());
            pst.setString(11, client.getObs());
            pst.setString(12, client.getEmail());
            if (client.getBirthDate() != null) {
                pst.setDate(13, new java.sql.Date(client.getBirthDate().getTimeInMillis()));
            } else {
                pst.setNull(13, java.sql.Types.DATE);
            }
            pst.setBigDecimal(14, new BigDecimal(client.getRate()));
            pst.executeUpdate();
            try (ResultSet resultKey = pst.getGeneratedKeys()) {
                if (resultKey.next()) {
                    client.setId(resultKey.getInt(1));
                } 
            }
        }
    }
    
    
    
    public void update(int id, Client client) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE cliente SET nome=?, logradouro=?, bairro=?, cidade=?, ");
        sql.append(" estado=?, cep=?, telResidencial=?, telComercial=?, telCelular=?, cadastro=?, observacao=?, ");
        sql.append(" email=?, dataNascimento=?, taxa=? WHERE idCliente=? ");
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            pst.setString(1, client.getName());
            pst.setString(2, client.getAddress().getStreet());
            pst.setString(3, client.getAddress().getDistrict());
            pst.setString(4, client.getAddress().getCity());
            pst.setString(5, client.getAddress().getState());
            pst.setString(6, client.getAddress().getZipcode());
            pst.setString(7, client.getPhones().getHome());
            pst.setString(8, client.getPhones().getBusiness());
            pst.setString(9, client.getPhones().getCel());
            pst.setString(10, client.getRegistryNumber());
            pst.setString(11, client.getObs());
            pst.setString(12, client.getEmail());
            if (client.getBirthDate() != null) {
                pst.setDate(13, new java.sql.Date(client.getBirthDate().getTimeInMillis()));
            } else {
                pst.setNull(13, java.sql.Types.DATE);
            }
            pst.setBigDecimal(14, new BigDecimal(client.getRate()));
            pst.setInt(15, id);
            pst.executeUpdate();
        }
    }
    
    public void update(Client client) throws SQLException {
        update(client.getId(), client);
    }
    
    
    public ArrayList<String> getIdAndName() throws SQLException {
        String sql = "SELECT idCliente, nome FROM cliente";
        
        try (Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT); 
             ResultSet result = state.executeQuery(sql)) {
            
            if (!result.next()){
                throw new SQLException("O sistema ainda não possui cliente cadastrado.");
            }
            ArrayList<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            do { 
                builder.append(Format.clientId(result.getInt(1)));
                builder.append(" - ");
                builder.append(result.getString(2));
                list.add(builder.toString());
                builder.delete(0, builder.length());
            } while (result.next());
            
            Sort.byName(list, Client.ID_SUFFIX);
            return list;
        }
        
    }
    
    public String getNameAndId(int id) throws SQLException {
        String sql = "SELECT nome, idCliente FROM cliente WHERE idCliente = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()) {
                if (!result.next()){
                    throw new SQLException("O sistema ainda não possui cliente cadastrado.");
                } else {
                    return result.getString(1)+" - "+id;
                }
                
            }    
        }
    }
    
    public ArrayList<String> getNameList() throws SQLException {
        String sql = "SELECT nome, idCliente FROM cliente";
        try (Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT); 
             ResultSet result = state.executeQuery(sql)) {
            
            if (!result.next()){
                throw new SQLException("O sistema ainda não possui cliente cadastrado.");
            }
            
            ArrayList<String> list = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            do { 
                builder.append(result.getString(1));
                builder.append(" - ");
                builder.append(Format.clientId(result.getInt(2)));
                list.add(builder.toString());
                builder.delete(0, builder.length());
            } while (result.next());
            
            Collections.sort(list);
            return list;
        }
    }
    
    public ArrayList<Client> getAll() throws SQLException {
        String sql = "SELECT idCliente, nome, logradouro, bairro, cidade, estado, cep, telResidencial, telComercial, telCelular, "
                + "cadastro, observacao, dataNascimento, taxa, email FROM cliente";
        try (Statement state = conn.createStatement(); 
             ResultSet result = state.executeQuery(sql)) {
            
            if (!result.next()){
                throw new SQLException("O sistema ainda não possui cliente cadastrado.");
            }
            
            return ConvertMe.toClientList(result);
        }
    }
    
    public HashMap<String, Client> getMap() throws SQLException {
        String sql = "SELECT idCliente, nome, logradouro, bairro, cidade, estado, cep, telResidencial, telComercial, telCelular, "
                + "cadastro, observacao, dataNascimento, taxa, email FROM cliente";
        try (Statement state = conn.createStatement(); 
             ResultSet result = state.executeQuery(sql)) {
            
            if (!result.next()){
                throw new SQLException("O sistema ainda não possui cliente cadastrado.");
            }
            
            return ConvertMe.toClientMap(result);
        }
    }
    
    public ArrayList<Client> getAll(String namePart) throws SQLException {
        String sql = "SELECT idCliente, nome, logradouro, bairro, cidade, estado, cep, telResidencial, telComercial, telCelular, "
                + "cadastro, observacao, dataNascimento, taxa, email FROM cliente WHERE nome LIKE ?";
        StringBuilder part = new StringBuilder(namePart);
        part.append("%");
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, part.toString());
            try (ResultSet result = pst.executeQuery()) {
                if (!result.next()){
                    throw new SQLException("O sistema ainda não possui cliente cadastrado.");
                }
                return ConvertMe.toClientList(result);
            }    
        }
    }
    
    
    public boolean exists(int id) throws SQLException {
        String sql = "SELECT idCliente FROM cliente WHERE idCliente = ? ";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)){ 
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
        
    }
    
    public Client get(int id) throws SQLException{
        if (!exists(id)) {
            throw new SQLException("Não existe cliente com o código correspondente.");
        }
        StringBuilder sql = new StringBuilder("SELECT nome, logradouro, bairro, cidade, estado, cep, email, ");
        sql.append(" telResidencial, telComercial, telCelular, cadastro, observacao, dataNascimento, taxa FROM cliente WHERE idCliente = ? ");
        
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())){
            pst.setInt(1, id);
            try(ResultSet resultSet = pst.executeQuery()){
                resultSet.next();
                return ConvertMe.toClient(id, resultSet);
            }    
        }
    }
    
    public void delete(int id) throws SQLException{
        if (!exists(id)) {
            throw new SQLException("Não existe cliente com o código correspondente.");
        }
        try (PreparedStatement pst = 
                conn.prepareStatement("DELETE FROM cliente WHERE idCliente = ? ")){
            pst.setInt(1, id);
            pst.executeUpdate();    
        }
    }
    
    public int count() throws SQLException {
        String sql = "SELECT COUNT(idCliente) from cliente";
        try (Statement state = conn.createStatement();
            ResultSet result = state.executeQuery(sql)){
            result.first();
            return result.getInt(1);
        }
    }

    public boolean hasRecords(int id) throws SQLException {
        String sql = "SELECT idCheque FROM cheque WHERE fkCliente = ? ";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
    }
    
    public boolean hasRecords(int id, GregorianCalendar inputDate) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT idCheque, dataEntrada FROM cheque WHERE fkCliente = ?");
        sql.append(" AND DATE(dataEntrada) = ?");
        
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            pst.setInt(1, id);
            pst.setDate(2, new java.sql.Date(inputDate.getTimeInMillis()));
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
    }
    
    public boolean hasRecords(int id, GregorianCalendar begin, 
            GregorianCalendar end) throws SQLException {
        
        StringBuilder sql = new StringBuilder("SELECT idCheque, dataEntrada FROM cheque WHERE fkCliente = ?");
        sql.append(" AND DATE(dataEntrada) BETWEEN ? AND ?");
        
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            pst.setInt(1, id);
            pst.setDate(2, new java.sql.Date(begin.getTimeInMillis()));
            pst.setDate(3, new java.sql.Date(end.getTimeInMillis()));
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
    }

    public int getNextId() throws SQLException {
        if (count()==0) {
            return 1;
        } else {
            String sql = "SELECT MAX(idCliente) from cliente";
            try (Statement state = conn.createStatement();
                ResultSet result = state.executeQuery(sql)){
                result.first();
                return result.getInt(1)+1;
            }
        }
    }
    
    public int countActive() throws SQLException {
        String sql = "SELECT Count(idCliente) FROM cliente WHERE idCliente IN (SELECT idCliente FROM cliente, cheque WHERE idCliente = fkCliente GROUP BY idCliente)";
        try (Statement state = conn.createStatement()) {
            try (ResultSet result = state.executeQuery(sql)) {
                if (result.next()) {
                    return result.getInt(1);
                }
            }
        }
        return 0;
         
    }   
    
    public String getHigher() throws SQLException {
        String sql = "select fkCliente from cheque group by fkCliente having sum(valor) = "+
                     "(select max(campo) from (select fkCliente as cli, sum(valor) as campo from cheque group by fkCliente) as t)";
        try (Statement state = conn.createStatement()) {
            try (ResultSet result = state.executeQuery(sql)) {
                if (result.next()) {
                    Client client = new ClientController(conn).get(result.getInt(1));
                    return client.getFirstName();
                }
            }
        }
        return "Nenhum";
         
    }
    
    public String getLower() throws SQLException {
        String sql = "select fkCliente from cheque group by fkCliente having sum(valor) = "+
                     "(select min(campo) from (select fkCliente as cli, sum(valor) as campo from cheque group by fkCliente) as t)";
        try (Statement state = conn.createStatement()) {
            try (ResultSet result = state.executeQuery(sql)) {
                if (result.next()) {
                    Client client = new ClientController(conn).get(result.getInt(1));
                    return client.getFirstName();
                }
            }
        }
        return "Nenhum";
    }
    
    public double getRate(int id) throws SQLException {
        String sql = "SELECT taxa FROM cliente WHERE idCliente = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()) {
                if (result.next()) {
                    return result.getDouble(1);
                }
            }
        }
        return 5.0;
    }
    
}
