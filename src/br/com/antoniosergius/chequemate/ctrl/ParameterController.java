package br.com.antoniosergius.chequemate.ctrl;

import br.com.antoniosergius.chequemate.obj.Parameters;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParameterController {
    private Connection conn;
    
    public ParameterController() {}
    public ParameterController(Connection conn) {this.conn = conn;}
    
    public boolean hasRecord() throws SQLException {
        String sql = "SELECT count(idParametros) FROM parametros";
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery(sql)) {
            result.first();
            return result.getInt(1) != 0;
        }
    }
    
    public void insert(Parameters parameters) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO parametros (diasParaDeletar, minimoDiasDesconto, deletaAutomatico)");
        sql.append(" values (?,?,?)");
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            pst.setInt(1, parameters.getDaysToDelete());
            pst.setInt(2, parameters.getMinExpirationDays());
            pst.setBoolean(3, parameters.isAutoDelete());
            pst.executeUpdate();
        }
    }
    
    public static Parameters get(Connection connection) throws SQLException {
        try (Statement state = connection.createStatement(); 
             ResultSet result = state.executeQuery("SELECT diasParaDeletar, minimoDiasDesconto, deletaAutomatico FROM parametros")) {
            
            Parameters param = new Parameters();
            if (!result.next()) {
                return param;
            }
            param.setDaysToDelete(result.getInt(1));
            param.setMinExpirationDays(result.getInt(2));
            param.setAutoDelete(result.getBoolean(3));
            return param;
        }    
    }
    
    public Parameters get() throws SQLException {
        if (!hasRecord()) {
            Parameters param = new Parameters(15, 10, true);
            insert(param);
            return param;
        }
        try (Statement state = conn.createStatement(); 
             ResultSet result = state.executeQuery("SELECT diasParaDeletar, minimoDiasDesconto, deletaAutomatico FROM parametros")) {
            
            Parameters param = new Parameters();
            if (!result.next()) {
                return param;
            }
            param.setDaysToDelete(result.getInt(1));
            param.setMinExpirationDays(result.getInt(2));
            param.setAutoDelete(result.getBoolean(3));
            return param;
        } 
    }
    
    public void update(Parameters newOne) throws SQLException{
        StringBuilder sql = new StringBuilder("UPDATE parametros SET diasParaDeletar=? , minimoDiasDesconto=?, deletaAutomatico=?");
        try (PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            pst.setInt(1, newOne.getDaysToDelete());
            pst.setInt(2, newOne.getMinExpirationDays());
            pst.setBoolean(3, newOne.isAutoDelete());
            pst.executeUpdate();
        }
    }
}
