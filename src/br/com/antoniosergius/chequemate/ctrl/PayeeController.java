package br.com.antoniosergius.chequemate.ctrl;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Payee;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import br.com.antoniosergius.chequemate.util.tools.ConvertMe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PayeeController {
    
    private Connection conn;

    public PayeeController(Connection conn) {
        this.conn = conn;
    }
    
    public PayeeExt get(String registryNumber) throws SQLException {
        String sql = "SELECT idEmitente, nome, numCheques, dataPrimeiro, dataUltimo, maiorValor, cadastro FROM emitente WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, registryNumber);
            try (ResultSet result = pst.executeQuery()){
                boolean hasNext = result.next();
                if (!hasNext) {
                    return null;
                } else {
                    return ConvertMe.toPayeeExt(result);
                }
            }
        }    
    }
    
    public String getName(String registryNumber) throws SQLException {
        String sql = "SELECT nome FROM emitente WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, registryNumber);
            try (ResultSet result = pst.executeQuery()){
                boolean hasNext = result.next();
                if (!hasNext) {
                    return null;
                } else {
                    return result.getString(1);
                }
            }
        }    
    }
    
    public PayeeExt get(int id) throws SQLException {
        String sql = "SELECT nome, numCheques, dataPrimeiro, dataUltimo, maiorValor, cadastro FROM emitente WHERE id = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()){
                boolean hasNext = result.next();
                if (!hasNext) {
                    return null;
                } else {
                    return ConvertMe.toPayeeExt(result);
                }
            }
        }    
    }
    
    public ArrayList<String> getRegistryNumberList() throws SQLException {
        String sql = "SELECT cadastro FROM emitente";
        try (Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
             ResultSet result = state.executeQuery(sql)){
            
            boolean hasNext = result.next();
            if (!hasNext) {
                return new ArrayList<>();
            } else {
                ArrayList<String> list = new ArrayList<>();
                do {
                    list.add(result.getString(1));
                } while(result.next());
                return list;
            }
        }
    }
    
    public ArrayList<Payee> getPayeeList() throws SQLException {
        String sql = "SELECT nome, cadastro FROM emitente";
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery(sql)){
            
            boolean hasNext = result.next();
            if (!hasNext) {
                return new ArrayList<>();
            } else {
                return ConvertMe.toPayeeList(result);
            }
        }
    }
    
    public ArrayList<PayeeExt> getAll() throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("SELECT idEmitente, nome, cadastro, dataPrimeiro, dataUltimo, maiorValor, numCheques ");
        tmp.append(" from emitente ");
        String sql = tmp.toString();
        try (Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
             ResultSet result = state.executeQuery(sql)){
            
            boolean hasNext = result.next();
            if (!hasNext) {
                return null;
            } else {
                return ConvertMe.toPayeeExtList(result);
            }
        }
    }
    
    public int insert(PayeeExt payee) throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("INSERT INTO emitente(nome, cadastro, numCheques, ");
        tmp.append("dataPrimeiro, dataUltimo, maiorValor) values");
        tmp.append("(?,?,?,?,?,?)");
        String insert = tmp.toString();
        
        int id = -1;
        try (PreparedStatement pst = conn.prepareStatement(insert,
                Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, payee.getName());
            pst.setString(2, payee.getRegistryNumber());
            pst.setInt(3, payee.getCheckCount());
            pst.setDate(4, new java.sql.Date(payee.getFirstCheckInput().getTimeInMillis()));
            pst.setDate(5, new java.sql.Date(payee.getLastCheckInput().getTimeInMillis()));
            pst.setDouble(6, payee.getHigherCheckValue());
            pst.executeUpdate();
            try (ResultSet result = pst.getGeneratedKeys()) {
                if (result.next()) {
                    id = result.getInt(1);
                    payee.setId(id);
                } 
            }
        }
        return id;
    }
    
    public void insert(ArrayList<PayeeExt> payeeList) throws SQLException {
        for (PayeeExt payee : payeeList) {
            insert(payee);
        }
    }
    
    public void update(PayeeExt payee) throws SQLException {
        update(payee.getId(), payee);
        //System.out.println("updated = PayeeExt.name{"+payee.getName()+'}');
    }
    
    public void update(int id, PayeeExt payee) throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("UPDATE emitente SET nome=?, cadastro=?, numCheques=?, ");
        tmp.append("dataPrimeiro=?, dataUltimo=?, maiorValor=? WHERE idEmitente=?");
        String update = tmp.toString();
        try (PreparedStatement pst = conn.prepareStatement(update)) {
            pst.setString(1, payee.getName());
            pst.setString(2, payee.getRegistryNumber());
            pst.setInt(3, payee.getCheckCount());
            pst.setDate(4, new java.sql.Date(payee.getFirstCheckInput().getTimeInMillis()));
            pst.setDate(5, new java.sql.Date(payee.getLastCheckInput().getTimeInMillis()));
            pst.setDouble(6, payee.getHigherCheckValue());
            pst.setInt(7, id);
            pst.executeUpdate();
        }
    }
    
    public void partialUpdate(PayeeExt payee) throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("UPDATE emitente SET numCheques=?, ");
        tmp.append(" dataUltimo=?, maiorValor=? WHERE idEmitente=?");
        String update = tmp.toString();
        try (PreparedStatement pst = conn.prepareStatement(update)) {
            pst.setInt(1, payee.getCheckCount());
            pst.setDate(2, new java.sql.Date(payee.getLastCheckInput().getTimeInMillis()));
            pst.setDouble(3, payee.getHigherCheckValue());
            pst.setInt(4, payee.getId());
            pst.executeUpdate();
            //System.out.println("updated = Payee.name{"+payee.getName()+'}');
        }
    }
    
    public boolean exists(String registryNumber) throws SQLException {
        String sql = "SELECT idEmitente FROM emitente WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, registryNumber);
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
    }
    
    public void decrementCounter(String registryNumber) throws SQLException {
        if (!exists(registryNumber)) {
            return;
            //throw new SQLException("Emitente não encontrado");
        }
        
        int counter = getCounter(registryNumber)-1;
        if (counter == 0) {
            delete(getId(registryNumber));
        }
        String sql = "UPDATE emitente SET numCheques = ? WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, counter);
            pst.setString(2, registryNumber);
            pst.executeUpdate();
        }
    }
    
    public int getCounter(String registryNumber) throws SQLException {
        String sql = "SELECT numCheques FROM emitente WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, registryNumber);
            try (ResultSet result = pst.executeQuery()) {
                return result.next() ? result.getInt(1) : 0;
            }
        }
    }
    
    public int getId(String registryNumber) throws SQLException {
        if (!exists(registryNumber)) {
            return -1;
        }
        String sql = "SELECT idEmitente FROM emitente WHERE cadastro = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, registryNumber);
            try (ResultSet result = pst.executeQuery()) {
                result.first();
                return result.getInt(1);
            }
        }
    }
    
    public void updateFromCheckList(ArrayList<Check> checkList) throws SQLException {
        for (Check check : checkList) {
            updateFromCheck(check);
        }    
    }
    
//    public void updateFromCheckList(ArrayList<Check> checkList) throws SQLException {
//        CheckController checkControl = new CheckController(conn);
//        for (Check check : checkList) {
//            if (!checkControl.exists(check)) {
//                System.out.println("não existe o cheque de "+ check.getPayee().getRegistryNumber());
//                updateFromCheck(check);
//            }
//        }    
//    }
    
    public void updateFromCheck(Check check) throws SQLException {
        String registryNumber = check.getPayee().getRegistryNumber();
        PayeeExt payeeExt = get(registryNumber);
        if (payeeExt == null) {
            PayeeExt newOne = new PayeeExt(check.getPayee().getName(), 
                    check.getPayee().getRegistryNumber(), check.getGross());
            insert(newOne);
        } else {
            if (payeeExt.getHigherCheckValue()<check.getGross()) {
                payeeExt.setHigherCheckValue(check.getGross());
            }
            payeeExt.setCheckCount(payeeExt.getCheckCount()+1);
            GregorianCalendar now = new GregorianCalendar();
            payeeExt.setLastCheckInput(now);
            partialUpdate(payeeExt);
        }
    }
    
    public void delete(int id) throws SQLException {
        try (PreparedStatement pst = conn.prepareStatement("DELETE FROM emitente WHERE idEmitente = ?")) {
            pst.setInt(1, id);
            pst.executeUpdate();
            //System.out.println("deleted = PayeeExt.id{"+id+'}');
        }
    }

    public ArrayList<PayeeExt> query(Payee searchObj) throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("SELECT idEmitente, nome, cadastro, dataUltimo, dataPrimeiro, maiorValor, numCheques ");
        tmp.append(" FROM emitente WHERE nome LIKE ? AND cadastro LIKE ? ");
        String sql = tmp.toString();
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            String name = searchObj.getName()+"%";
            String registry = searchObj.getRegistryNumber()+"%";
            pst.setString(1, name);
            pst.setString(2, registry);
            try (ResultSet result = pst.executeQuery()) {
                if (result.next()) {
                    return ConvertMe.toPayeeExtList(result);
                }
            }
        }
        throw new SQLException("Não foi encontrado registro correspondente.");
    }

    public void updateName(int id, String newName) throws SQLException {
        StringBuilder tmp = new StringBuilder();
        tmp.append("UPDATE emitente SET nome=? ");
        tmp.append(" WHERE idEmitente=?");
        String update = tmp.toString();
        try (PreparedStatement pst = conn.prepareStatement(update)) {
            pst.setString(1, newName);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
    }
    
    public void queryAndInsertMissingPayees()  throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT emitente, cadastro, COUNT(cadastro), MIN(DATE(dataEntrada)), ");
        sql.append("MAX(DATE(dataEntrada)), MAX(valor) FROM cheque t1 WHERE ");
        sql.append("NOT EXISTS (SELECT cadastro FROM emitente t2 WHERE ");
        sql.append("t1.cadastro = t2.cadastro) AND cadastro<>'' GROUP BY cadastro ");
        // 1 = emitente // 2 = cadastro // 3 = count(cadastro)
        // 4 = min(date(dataEntrada))  // 5 = max(date(dataEntrada)) // 6 = max(valor)
        try (Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
             ResultSet result = state.executeQuery(sql.toString())){
            
            boolean hasNext = result.next();
            if (hasNext) {
                do {
                    GregorianCalendar first = new GregorianCalendar();
                    GregorianCalendar last = new GregorianCalendar();
                    first.setTimeInMillis(result.getDate(4).getTime());
                    last.setTimeInMillis(result.getDate(5).getTime());
                    
                    PayeeExt payee = new PayeeExt(result.getString(1), 
                            result.getString(2), result.getDouble(6), 
                            first, last, result.getInt(3));
                    insert(payee);
                } while (result.next());
            }
        }
    }
    
    
    //será rodado uma única vez
    public void corrigeEmitentesRetroativos() throws SQLException{
        String query = "SELECT * FROM cheque WHERE DATE(dataEntrada) between '2019-09-09' and DATE(NOW())";
        try (Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, 
             ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
             ResultSet result = state.executeQuery(query)){
            
            boolean hasNext = result.next();
            if (hasNext) {
                updateFromCheckList(ConvertMe.toCheckListTemp(result));
            }
        }
    }
    
    
//   public void insertImage(String registryNumber, File file) throws SQLException, FileNotFoundException, IOException {
//      String sql = "INSERT INTO emitente (assinatura) values (?) WHERE cadastro LIKE ?";
//      
//      try (PreparedStatement pst = conn.prepareStatement(sql)){
//         FileInputStream fis = new FileInputStream(file);
//         pst.setBinaryStream(1, fis, (int)file.length());
//         pst.setString(2, registryNumber);
//         pst.executeUpdate();
//      }
//   }
//   
//   public void insertImage(int id, File file) throws SQLException, FileNotFoundException {
//      String sql = "INSERT INTO emitente (assinatura) values (?) WHERE idEmitente = ?";
//      
//      try (PreparedStatement pst = conn.prepareStatement(sql)){
//         FileInputStream fis = new FileInputStream(file);
//         pst.setBinaryStream(1, fis, (int)file.length());
//         pst.setInt(2, id);
//         pst.executeUpdate();
//      }
//   }
    
}
