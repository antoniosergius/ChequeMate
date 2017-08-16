package br.com.antoniosergius.chequemate.ctrl;


import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.PayeeExt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayeeClientsController {
   private final Connection conn;

   public PayeeClientsController(Connection conn) {
      this.conn = conn;
   }

   public void updateFromCheckList(ArrayList<Check> checkList) throws SQLException{
      CheckController checkControl = new CheckController(conn);
      PayeeController payeeControl = new PayeeController(conn);
      for (Check check : checkList) {
         if (!checkControl.exists(check)) {
            
         }
      }
   }
   
   public int getId(String registryNumber) throws SQLException {
      if (!exists(registryNumber)) {
         return -1;
      }
      String sql = "SELECT idEmitenteClients FROM emitenteClients WHERE cadastroEmitente = ?";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setString(1, registryNumber);
         try (ResultSet result = pst.executeQuery()) {
            result.first();
            return result.getInt(1);
         }
      }
   }

   private void updateFromCheck(Check check) {
      String registryNumber = check.getPayee().getRegistryNumber();
      
      /*PayeeExt payeeExt = get(registryNumber);
      if (payeeExt == null) { //não existe
         PayeeExt newOne = new PayeeExt(check.getPayee().getName(),
                 check.getPayee().getRegistryNumber(), check.getGross());
         insert(newOne);
      } else { //existente
         if (payeeExt.getHigherCheckValue() < check.getGross()) {
            payeeExt.setHigherCheckValue(check.getGross());
         }
         payeeExt.setCheckCount(payeeExt.getCheckCount() + 1);
         GregorianCalendar now = new GregorianCalendar();
         payeeExt.setLastCheckInput(now);
         partialUpdate(payeeExt);
      }*/
   }

   public boolean exists(String registryNumber) throws SQLException {
      String sql = "SELECT idEmitenteCliente FROM emitenteClients WHERE cadastroEmitente = ?";
      try (PreparedStatement pst = conn.prepareStatement(sql)) {
         pst.setString(1, registryNumber);
         try (ResultSet result = pst.executeQuery()) {
            return result.next();
         }
      }
   }
   
   
}
