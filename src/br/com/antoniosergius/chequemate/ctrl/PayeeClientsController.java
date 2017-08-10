package br.com.antoniosergius.chequemate.ctrl;


import java.sql.Connection;

public class PayeeClientsController {
   private Connection conn;

   public PayeeClientsController(Connection conn) {
      this.conn = conn;
   }
   
   
}
