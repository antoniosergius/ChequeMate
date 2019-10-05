package br.com.antoniosergius.chequemate.ctrl;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.obj.Query;
import br.com.antoniosergius.chequemate.obj.QueryExt;
import br.com.antoniosergius.chequemate.obj.record.RecordCheck;
import br.com.antoniosergius.chequemate.util.tools.ConvertMe;
import br.com.antoniosergius.lib.tools.Days;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckController {
   private static final Logger LOG = Logger.getLogger(CheckController.class.getName());
   private final Connection conn;

   public CheckController(Connection conn) {
      this.conn = conn;
   }

   //CONFERIR METODO
   public boolean exists(Check check) throws SQLException {
      String sql = "SELECT COUNT(idCheque) FROM cheque WHERE numero = ? AND banco = ? AND agencia = ? AND cadastro like ?";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setInt(1, check.getNumber());
         pst.setInt(2, check.getBank());
         pst.setInt(3, check.getAgency());
         pst.setString(4, check.getPayee().getRegistryNumber());
         try (ResultSet result = pst.executeQuery()) {
            result.first();
            return result.getInt(1) >= 1;
         }
      }
   }

   public void insert(Check check) throws SQLException {
      StringBuilder sql = new StringBuilder("INSERT INTO cheque ");
      sql.append(" (numero, banco, agencia, valor, valorLiquido, dataEntrada, dataBoa, dataCalculo, fkCliente, taxa, emitente, cadastro, obs) ");
      sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
      try (PreparedStatement pst = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
         pst.setString(1, String.valueOf(check.getNumber()));
         pst.setString(2, String.valueOf(check.getBank()));
         pst.setString(3, String.valueOf(check.getAgency()));
         pst.setBigDecimal(4, new BigDecimal(check.getGross()));
         pst.setBigDecimal(5, new BigDecimal(check.getNet()));
         pst.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
         pst.setDate(7, new java.sql.Date(check.getExpiration().getTimeInMillis()));
         pst.setDate(8, new java.sql.Date(check.getCalcDate().getTimeInMillis()));
         pst.setInt(9, check.getIdClient());
         pst.setDouble(10, check.getRate());
         pst.setString(11, check.getPayee().getName());
         pst.setString(12, check.getPayee().getRegistryNumber());
         pst.setString(13, check.getObs());
         pst.executeUpdate();
         try (ResultSet result = pst.getGeneratedKeys()) {
            if (result.next()) {
               int idCheck = result.getInt(1);
               check.setId(idCheck);
               //System.out.println("inserted = Check.id{" + check.getId() + '}');
            }
         }
      }
   }

   public void doTransaction(RecordCheck record, ArrayList<Check> deletedList) throws SQLException {
      try {
         conn.setAutoCommit(false);
         for (Check check : record.getList()) {
            check.setIdClient(record.getIdClient());
            if (check.getId() != 0) {
               update(check);
            } else {
               insert(check);
            }
            conn.commit();
         }
         for (Check check : deletedList) {
            delete(check.getId());
            conn.commit();
         }
      } catch (SQLException ex) {
         LOG.log(Level.SEVERE, ex.getMessage(), ex);
         if (conn != null) {
            try {
               conn.rollback();
            } catch (SQLException x) {
               LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
         }
      } finally {
         conn.setAutoCommit(true);
      }
   }

   public void insertListWithIdAndInputDate(ArrayList<Check> list) throws SQLException {
      StringBuilder insert = new StringBuilder("INSERT INTO cheque ");
      insert.append(" (numero, banco, agencia, valor, valorLiquido, dataEntrada, dataBoa, dataCalculo, fkCliente, taxa,emitente, cadastro, idCheque) ");
      insert.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ");

      PreparedStatement pst = null;
      try {
         int size = list.size();
         conn.setAutoCommit(false);
         pst = conn.prepareStatement(insert.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);

         for (int i = 0; i < size; ++i) {
            Check check = list.get(i);
            pst.setString(1, String.valueOf(check.getNumber()));
            pst.setString(2, String.valueOf(check.getBank()));
            pst.setString(3, String.valueOf(check.getAgency()));
            pst.setBigDecimal(4, new BigDecimal(check.getGross()));
            pst.setBigDecimal(5, new BigDecimal(check.getNet()));
            pst.setTimestamp(6, new java.sql.Timestamp(check.getInputDate().getTimeInMillis()));
            pst.setDate(7, new java.sql.Date(check.getExpiration().getTimeInMillis()));
            pst.setDate(8, new java.sql.Date(check.getCalcDate().getTimeInMillis()));
            pst.setInt(9, check.getIdClient());
            pst.setDouble(10, check.getRate());
            pst.setString(11, check.getPayee().getName());
            pst.setString(12, check.getPayee().getRegistryNumber());
            pst.setInt(13, check.getId());
            pst.executeUpdate();
            conn.commit();
            try (ResultSet resultKey = pst.getGeneratedKeys()) {
               if (resultKey.next()) {
                  check.setId(resultKey.getInt(1));
               }
            }
         }
      } catch (SQLException ex) {
         LOG.severe(ex.getMessage());
         if (conn != null) {
            try {
               conn.rollback();
            } catch (SQLException excep) {
               LOG.severe(excep.getMessage());
            }
         }
      } finally {
         if (pst != null) {
            pst.close();
         }
         conn.setAutoCommit(true);
      }
   }

   public void delete(int idCheck) throws SQLException {
      try (PreparedStatement pst = conn.prepareStatement("DELETE FROM cheque WHERE idCheque = ?")) {
         pst.setInt(1, idCheck);
         pst.executeUpdate();
         //System.out.println("deleted = Check.id{" + idCheck + '}');
      }
   }

   public void update(Check check) throws SQLException {
      update(check.getId(), check);
      //System.out.println("updated = Check.id{" + check.getId() + '}');
   }

   public void update(int id, Check check) throws SQLException {
      StringBuilder sql = new StringBuilder("UPDATE cheque SET numero=? , banco=? , agencia=? ,");
      sql.append(" valor=?, valorLiquido=?, dataBoa=?, dataCalculo=?, fkCliente=? , taxa=?, emitente=?, cadastro=?, obs=? WHERE idCheque=? ");
      try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
         pst.setInt(1, check.getNumber());
         pst.setInt(2, check.getBank());
         pst.setInt(3, check.getAgency());
         pst.setBigDecimal(4, new BigDecimal(check.getGross()));
         pst.setBigDecimal(5, new BigDecimal(check.getNet()));
         pst.setDate(6, new java.sql.Date(check.getExpiration().getTimeInMillis()));
         pst.setDate(7, new java.sql.Date(check.getCalcDate().getTimeInMillis()));
         pst.setInt(8, check.getIdClient());
         pst.setBigDecimal(9, new BigDecimal(check.getRate()));
         pst.setString(10, check.getPayee().getName());
         pst.setString(11, check.getPayee().getRegistryNumber());
         pst.setInt(13, id);
         pst.setString(12, check.getObs());
         pst.executeUpdate();
      }
   }

   public ArrayList<Check> query(Query query) throws SQLException {
      StringBuilder sql = new StringBuilder("SELECT idCheque, fkCliente, emitente, cheque.cadastro, cliente.nome, ");
      sql.append(" valor, valorLiquido, dataBoa, dataEntrada, dataCalculo, cheque.taxa, banco, agencia, numero, cheque.obs FROM cheque, cliente WHERE fkCliente=idCliente ");
      sql.append(" AND fkCliente BETWEEN ? AND ? AND cheque.cadastro LIKE ? AND emitente LIKE ? ");
      sql.append(" AND banco BETWEEN ? AND ? AND numero BETWEEN ? AND ? AND dataBoa ");
      sql.append(" BETWEEN ? and ? AND valor BETWEEN ? and ? AND dataEntrada BETWEEN ? AND ? ");

      StringBuilder registryBuilder = new StringBuilder(query.getPayee().getRegistryNumber());
      StringBuilder payeeBuilder = new StringBuilder(query.getPayee().getName());
      registryBuilder.append("%");
      payeeBuilder.append("%");

      try (PreparedStatement pst = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
         ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
         pst.setInt(1, query.getIdClient() != 0 ? query.getIdClient() : Client.MIN);
         pst.setInt(2, query.getIdClient() != 0 ? query.getIdClient() : Client.MAX);
         pst.setString(3, registryBuilder.toString());
         pst.setString(4, payeeBuilder.toString());
         pst.setInt(5, query.getBank() != 0 ? query.getBank() : Check.MIN_BANK);
         pst.setInt(6, query.getBank() != 0 ? query.getBank() : Check.MAX_BANK);
         pst.setInt(7, query.getNumber() != 0 ? query.getNumber() : Check.MIN_NUMBER);
         pst.setInt(8, query.getNumber() != 0 ? query.getNumber() : Check.MAX_NUMBER);
         pst.setDate(9, new java.sql.Date(query.getLowestExpiration().getTimeInMillis()));
         pst.setDate(10, new java.sql.Date(query.getHighestExpiration().getTimeInMillis()));
         pst.setDouble(11, query.getLowestValue());
         pst.setDouble(12, query.getHighestValue());
         pst.setTimestamp(13, new java.sql.Timestamp(query.getLowestInput().getTimeInMillis()));
         pst.setTimestamp(14, new java.sql.Timestamp(query.getHighestInput().getTimeInMillis()));
         try (ResultSet result = pst.executeQuery()) {
            if (result.next()) {
               return ConvertMe.toCheckList(result);
            }
         }
      }
      throw new SQLException("Não foi encontrado registro correspondente.");
   }

   public ArrayList<Check> queryExt(QueryExt query) throws SQLException {
      StringBuilder sql = new StringBuilder("SELECT idCheque, fkCliente, emitente, cheque.cadastro, cliente.nome, ");
      sql.append(" valor, valorLiquido, dataBoa, dataEntrada, dataCalculo, cheque.taxa, banco, agencia, numero, cheque.obs FROM cheque, cliente WHERE fkCliente=idCliente ");
      sql.append(" AND fkCliente BETWEEN ? AND ? AND cheque.cadastro LIKE ? AND emitente LIKE ? ");
      sql.append(" AND banco BETWEEN ? AND ? AND numero BETWEEN ? AND ? AND dataBoa ");
      sql.append(" BETWEEN ? and ? AND valor BETWEEN ? and ? AND dataEntrada BETWEEN ? AND ? ");

      if (query.getObs().isEmpty()) {
         sql.append(" AND (cheque.obs LIKE ? OR cheque.obs IS NULL) ");
      } else {
         sql.append(" AND cheque.obs LIKE ? ");
      }

      StringBuilder registryBuilder = new StringBuilder(query.getPayee().getRegistryNumber());
      StringBuilder payeeBuilder = new StringBuilder(query.getPayee().getName());
      StringBuilder obsBuilder = new StringBuilder(query.getObs());
      registryBuilder.append("%");
      payeeBuilder.append("%");
      obsBuilder.append("%");

      try (PreparedStatement pst = conn.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY,
         ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
         pst.setInt(1, query.getIdClient() != 0 ? query.getIdClient() : Client.MIN);
         pst.setInt(2, query.getIdClient() != 0 ? query.getIdClient() : Client.MAX);
         pst.setString(3, registryBuilder.toString());
         pst.setString(4, payeeBuilder.toString());
         pst.setInt(5, query.getBank() != 0 ? query.getBank() : Check.MIN_BANK);
         pst.setInt(6, query.getBank() != 0 ? query.getBank() : Check.MAX_BANK);
         pst.setInt(7, query.getNumber() != 0 ? query.getNumber() : Check.MIN_NUMBER);
         pst.setInt(8, query.getNumber() != 0 ? query.getNumber() : Check.MAX_NUMBER);
         pst.setDate(9, new java.sql.Date(query.getLowestExpiration().getTimeInMillis()));
         pst.setDate(10, new java.sql.Date(query.getHighestExpiration().getTimeInMillis()));
         pst.setDouble(11, query.getLowestValue());
         pst.setDouble(12, query.getHighestValue());
         pst.setTimestamp(13, new java.sql.Timestamp(query.getLowestInput().getTimeInMillis()));
         pst.setTimestamp(14, new java.sql.Timestamp(query.getHighestInput().getTimeInMillis()));
         pst.setString(15, obsBuilder.toString());
         try (ResultSet result = pst.executeQuery()) {
            if (result.next()) {
               return ConvertMe.toCheckList(result);
            }
         }
      }
      throw new SQLException("Não foi encontrado registro correspondente.");
   }

   public ArrayList<Check> queryByExpiration(GregorianCalendar expiration) throws SQLException {
      if (expiration == null) {
         throw new IllegalArgumentException("Data inválida");
      }
      StringBuilder sql = new StringBuilder("SELECT idCheque, cliente.nome, fkCliente, numero, banco, agencia, valor, valorLiquido, dataBoa, ");
      sql.append(" cheque.cadastro, emitente, dataEntrada, dataCalculo, cheque.taxa, cheque.obs FROM cheque, cliente WHERE idCliente=fkCliente and DATE(dataEntrada) = ? ");
      try (PreparedStatement pst = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
         ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT)) {
         pst.setDate(1, new java.sql.Date(expiration.getTimeInMillis()));
         try (ResultSet result = pst.executeQuery()) {
            if (result.next()) {
               return ConvertMe.toCheckList(result);
            }
         }
      }
      throw new SQLException("Não foi cadastrado cheque na data fornecida.");
   }

   public ArrayList<Check> getRecordedToday() throws SQLException {
      return queryByExpiration(Days.TODAY);
   }

   public ArrayList<Check> getAll() throws SQLException {
      StringBuilder sql = new StringBuilder("SELECT idCheque, numero, banco, agencia, valor, valorLiquido,");
      sql.append(" dataBoa, dataEntrada, dataCalculo, cheque.taxa, fkCliente, emitente, cheque.cadastro, nome, cheque.obs ");
      sql.append(" FROM cheque, cliente WHERE idCliente=fkCliente ");
      try (Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,
         ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
         ResultSet result = state.executeQuery(sql.toString())) {
         if (result.next()) {
            return ConvertMe.toCheckList(result);
         }
      }
      throw new SQLException("Não foi encontrado emitente correspondente.");
   }

   public double getGrossAmount() throws SQLException {
      String sql = "SELECT SUM(valor) AS total FROM cheque ";
      try (Statement state = conn.createStatement();
         ResultSet result = state.executeQuery(sql)) {
         if (result.next()) {
            return result.getDouble(1);
         }
      }
      return 0.0;
   }

   public double getGrossAmount(int month) throws SQLException {
      String sql = "SELECT SUM(valor) AS total FROM cheque WHERE MONTH(dataBoa) = ? and YEAR(databoa) = ?";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setInt(1, month + 1);
         pst.setInt(2, Days.TODAY.get(GregorianCalendar.YEAR));
         try (ResultSet result = pst.executeQuery()) {
            if (result.next()) {
               return result.getDouble(1);
            }
         }
      }
      return 0.0;
   }

   public int countCheckOutstanding(String registryNumber) throws SQLException {
      String sql = "SELECT COUNT(idCheque) FROM cheque WHERE cadastro like ? and dataBoa > DATE(NOW())";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setString(1, registryNumber);
         try (ResultSet result = pst.executeQuery()) {
            result.first();
            return result.getInt(1);
         }
      }
   }

   public int count() throws SQLException {
      String sql = "SELECT COUNT(idCheque) AS total FROM cheque";
      try (Statement state = conn.createStatement()) {
         try (ResultSet result = state.executeQuery(sql)) {
            if (result.next()) {
               return result.getInt(1);
            }
         }
      }
      return 0;
   }

   public int countRegisteredToday() throws SQLException {
      String sql = "SELECT COUNT(idCheque) AS total FROM cheque WHERE DATE(dataEntrada) = DATE(NOW())";
      try (Statement state = conn.createStatement()) {
         try (ResultSet result = state.executeQuery(sql)) {
            if (result.next()) {
               return result.getInt(1);
            }
         }
      }
      return 0;
   }

   public double sumGrossRegisteredToday() throws SQLException {
      String sql = "SELECT SUM(valor) AS total FROM cheque WHERE DATE(dataEntrada) = DATE(NOW())";
      try (Statement state = conn.createStatement()) {
         try (ResultSet result = state.executeQuery(sql)) {
            if (result.next()) {
               return result.getDouble(1);
            }
         }
      }
      return 0;
   }

   public double sumGrossLeftInMonth(GregorianCalendar lastDay) throws SQLException {
      String sql = "SELECT SUM(valor) AS total FROM cheque WHERE DATE(dataBoa) >= DATE(NOW()) and DATE(dataBoa) <= ?";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setDate(1, new java.sql.Date(lastDay.getTimeInMillis()));
         try (ResultSet result = pst.executeQuery()) {
            if (result.next()) {
               return result.getDouble(1);
            }
         }
      }
      return 0;
   }

   public double getGrossAmountUnexpired() throws SQLException {
      String sql = "SELECT SUM(valor) FROM cheque WHERE date(dataBoa) > date(now())";
      try (Statement state = conn.createStatement()) {
         try (ResultSet result = state.executeQuery(sql)) {
            if (result.next()) {
               return result.getDouble(1);
            }
         }
      }
      return 0;
   }

   public double sumNetRegisteredToday() throws SQLException {
      String sql = "SELECT SUM(valorLiquido) AS total FROM cheque WHERE DATE(dataEntrada) = DATE(NOW())";
      try (Statement state = conn.createStatement()) {
         try (ResultSet result = state.executeQuery(sql)) {
            if (result.next()) {
               return result.getDouble(1);
            }
         }
      }
      return 0;
   }

   public double getTodayRetention() throws SQLException {
      double todayGrossAmount = sumGrossRegisteredToday();
      double todayNetAmount = sumNetRegisteredToday();
      if (todayGrossAmount == 0 || todayNetAmount == 0) {
         return 0;
      } else {
         return todayGrossAmount - todayNetAmount;
      }
   }

   public void deleteOldRecords(int daysFromExpiration) throws SQLException {
      String sql = "DELETE FROM cheque WHERE dataBoa <= DATE(DATE_SUB(NOW(), INTERVAL ? DAY))";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setInt(1, daysFromExpiration);
         pst.executeUpdate();
      }
   }

   public int countOldRecords(int daysFromExpiration) throws SQLException {
      String sql = "SELECT COUNT(idCheque) FROM cheque WHERE dataBoa <= DATE(DATE_SUB(NOW(), INTERVAL ? DAY))";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setInt(1, daysFromExpiration);
         try (ResultSet result = pst.executeQuery()) {
            result.next();
            return result.getInt(1);
         }
      }
   }
}
