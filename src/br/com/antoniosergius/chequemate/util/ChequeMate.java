package br.com.antoniosergius.chequemate.util;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.HolidayController;
import br.com.antoniosergius.chequemate.ctrl.ParameterController;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.obj.Preferences;
import br.com.antoniosergius.lib.gui.utils.ShowMessage;
import br.com.antoniosergius.lib.gui.utils.ShowSuccesMessage;
import br.com.antoniosergius.lib.obj.Message;
import br.com.antoniosergius.lib.util.MySQLParameters;
import br.com.antoniosergius.chequemate.util.io.BackupService;
import br.com.antoniosergius.lib.util.io.Configuration;
import br.com.antoniosergius.lib.util.io.Serialize;
import br.com.antoniosergius.lib.util.io.XMLStream;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.mysql.cj.jdbc.Driver;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

public class ChequeMate {
    private static Parameters parameters;
    private static GregorianCalendar maxDate;
    private static GregorianCalendar minInputDate;
    private static GregorianCalendar minExpirationDate;
    private static Configuration configuration;
    private static BackupService backupService;
    private static Preferences preferences;
    private static char[] mysqlPassword;
    public static final Locale LOCALE = new Locale("pt", "BR");
    public static final XMLStream XSTREAM = new XMLStream();
    private static final HolidayController holidayControl = new HolidayController();
    public static String VERSION = "1.7"; 
    
    public static Connection init(MySQLParameters mysqlParam, char[] password) throws SQLException, IOException, InterruptedException {
        Connection conn = testDB(mysqlParam, password);
        verifyDataBase(conn);
        conn = registerDB(mysqlParam, password);
        ChequeMate.holidayControl.createInstances(conn);
        ChequeMate.backupService = new BackupService(mysqlParam, password);
        ChequeMate.parameters = new ParameterController(conn).get();
        ChequeMate.minInputDate = holidayControl.getMinInputDate();
        ChequeMate.minExpirationDate = holidayControl.getMinExpirationDate();
        GregorianCalendar max = new GregorianCalendar();
        max.roll(GregorianCalendar.YEAR, 8);
        ChequeMate.maxDate = max; 
        Logger.getRootLogger().setLevel(Level.WARN);
        return conn;
    }
    
    public static void readPreferences() {
        try {
            Serialize<Preferences> serial = new Serialize<>(MyPath.PREFERENCES);
            ChequeMate.preferences = serial.read();
        } catch (ClassNotFoundException | IOException ex) {
            java.util.logging.Logger.getLogger(ChequeMate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            preferences = new Preferences();
            preferences.setShowSplashScreen(true);
            preferences.setDefaultRate(5.0);
            preferences.setDaysToKeepRegistries(180);
        }
    }
    
    public static void applyLAF() {
        String clazz = null;
        if (ChequeMate.configuration != null) {
            clazz = ChequeMate.configuration.getLookAndFeel().getClassName();
        }
        if (clazz == null) {
            java.awt.EventQueue.invokeLater(new ApplySubstanceLAF("org.pushingpixels.substance.api.skin.MarinerSkin"));
        } else if (clazz.contains("org.pushingpixels.substance.api.skin.")){
            java.awt.EventQueue.invokeLater(new ApplySubstanceLAF(clazz));
        } else {
            applyWindowsLAF();
        }
    }
    
    public static Connection testDB(MySQLParameters parameters, char[] password) throws SQLException{
        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://");
        url.append(parameters.getServer());
        url.append(":");
        url.append(parameters.getPort());
        url.append("/");
        url.append(parameters.getDatabase());
        Properties prop = new Properties();
        prop.put("user", parameters.getUser());
        prop.put("password", String.valueOf(password));
        prop.put("useTimezone", "true");
        prop.put("serverTimezone", "UTC");
//        prop.put("connectTimeout", "1");
//        prop.put("autoReconnect", "true");
//        prop.put("cachePrepStmts", "true");
//        prop.put("maxReconnects", "3");
//        prop.put("paranoid", "true");
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection(url.toString(), prop);
    }
    
    public static Connection registerDB(MySQLParameters parameters, char[] password) throws SQLException{
        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://");
        url.append(parameters.getServer());
        url.append(":");
        url.append(parameters.getPort());
        url.append("/");
        url.append(parameters.getDatabase());
        Properties prop = new Properties();
        prop.put("user", parameters.getUser());
        prop.put("password", String.valueOf(password));
        prop.put("useTimezone", "true");
        prop.put("serverTimezone", "UTC");
//        prop.put("connectTimeout", "1");
//        prop.put("autoReconnect", "true");
//        prop.put("cachePrepStmts", "true");
//        prop.put("maxReconnects", "3");
//        prop.put("paranoid", "true");
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection(url.toString(), prop);
    }
    
    public static void disconnectDB(Connection conn) throws SQLException {
        conn.close();
    }

    private static void applyWindowsLAF() {
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                } else {
//                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//                }
//            }
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChequeMate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static BackupService getBackupService() {
        return backupService;
    }

    public static void setBackupService(BackupService backupService) {
        ChequeMate.backupService = backupService;
    }
    
    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        ChequeMate.configuration = configuration;
    }

    public static Parameters getParameters() {
        return parameters;
    }

    public static void setParameters(Parameters parameters) {
        ChequeMate.parameters = parameters;
    }

    public static GregorianCalendar getMinInputDate() {
        return minInputDate;
    }

    public static void setMinInputDate(GregorianCalendar minDate) {
        ChequeMate.minInputDate = minDate;
    }

    public static GregorianCalendar getMaxDate() {
        return maxDate;
    }

    public static void setMaxDate(GregorianCalendar maxDate) {
        ChequeMate.maxDate = maxDate;
    }

    public static HolidayController getHolidayControl() {
        return holidayControl;
    }

    public static GregorianCalendar getMinExpirationDate() {
        return minExpirationDate;
    }

    public static void setMinExpirationDate(GregorianCalendar minExpirationDate) {
        ChequeMate.minExpirationDate = minExpirationDate;
    }

    public static Preferences getPreferences() {
        return preferences;
    }

    public static void setPreferences(Preferences preferences) {
        ChequeMate.preferences = preferences;
    }

    public static void deleteOldRecords(CheckController checkControl) throws SQLException {
        if (ChequeMate.parameters.isAutoDelete()) {
            int daysFromExpiration = ChequeMate.parameters.getDaysToDelete();
            int oldRecords = checkControl.countOldRecords(daysFromExpiration);
            if (oldRecords == 0) {
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Deseja deletar "+oldRecords+" registro(s) vencido(s)?",
                    "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                checkControl.deleteOldRecords(daysFromExpiration);
            }
        }
    }

    public static void verifyFolders() throws IOException {
        File registries = new File(MyPath.REGISTRIES);
        File data = new File(MyPath.DATA);
        if (!registries.exists()) {
            registries.mkdir();
        }
        if (!data.exists()) {
            data.mkdir();
        }
    }


    private static void verifyDataBase(Connection conn) throws SQLException, IOException, InterruptedException {
        try (ResultSet resultSet = conn.getMetaData().getCatalogs()) {
            boolean hasIt = false;
            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if (databaseName.equals("chequemate")){
                    hasIt = true;
                }
            }
            if (!hasIt) {
                MySQLParameters mySqlParameters = configuration.getMysqlParameters();
                ProcessBuilder builder = new ProcessBuilder("mysql", "-u", mySqlParameters.getUser(), "-p"+String.valueOf(mysqlPassword), 
                            "--port="+mySqlParameters.getPort());
                builder.redirectInput(ProcessBuilder.Redirect.from(new File(MyPath.CREATE_DB)));
                Process process = builder.start();
                int exitValue = process.waitFor();
                if (exitValue != 0) {
                    ChequeMate.showErrorMessage(null, "Erro na criação da base de dados. Contate o administrador.");
                } 
            }
            
        }
        
        
    }

    public static void createDailyBackup() {
        BackupService backupMySQL = ChequeMate.getBackupService();
        backupMySQL.setDateTime(new GregorianCalendar());
        String fileName = backupMySQL.createFileName();
        File file = new File(ChequeMate.getPreferences().getBackupPath()+File.separator+fileName);
        
        if (file.exists()) {
            if (file.canWrite()) {
                executeBackup(file, true, backupMySQL);
            } 
        } else {
            executeBackup(file, false, backupMySQL);
        }
        //new BackupBuilder(null, true).setVisible(true);
    }
    
    private static void executeBackup(File saveFile, boolean exists, BackupService backupMySQL) {
        try {
            if (!exists) {
                saveFile.createNewFile();
            } 
            backupMySQL.setFile(saveFile);
            if (backupMySQL.commitBackup()) {
                ChequeMate.showSuccessMessage(null, "Backup efetuado com sucesso.");
            } else {
                ChequeMate.showErrorMessage(null, "Houve algum erro ao gravar o arquivo.");
            }
        } catch (InterruptedException | IOException ex) {
            ChequeMate.showErrorMessage(null, "Não foi possível gerar o Backup para o respectivo diretório.");
        }
    }

    public static class ApplySubstanceLAF implements Runnable {
        private String clazz;
        public ApplySubstanceLAF(String clazz) {
            this.clazz = clazz;
        }
        
        @Override
        public void run() {
            SubstanceLookAndFeel.setSkin(clazz);
        }
    }
    
    public static void showMessage(Message message) {
        SwingUtilities.invokeLater(new ShowMessage(message));
    }
    
    public static void showMessage(Component component, String title, String text, int type) {
        SwingUtilities.invokeLater(new ShowMessage(new Message(component, title, text, type)));
    }
    
    public static void showErrorMessage(Component component, String title, String text) {
        SwingUtilities.invokeLater(new ShowMessage(new Message(component, title, 
                text, JOptionPane.ERROR_MESSAGE)));
    }
    
    public static void showErrorMessage(Component component, String text) {
        SwingUtilities.invokeLater(new ShowMessage(new Message(component, "Erro!", 
                text, JOptionPane.ERROR_MESSAGE)));
    }
    
    public static void showWarningMessage(Component component, String title, String text) {
        SwingUtilities.invokeLater(new ShowMessage(new Message(component, title, 
                text, JOptionPane.WARNING_MESSAGE)));
    }
    
    public static void showSuccessMessage(Component component, String text) {
        SwingUtilities.invokeLater(new ShowSuccesMessage("/img/x32.valid.png", 
                new Message(component, "Sucesso!", text, JOptionPane.PLAIN_MESSAGE)));
    }
    
    public static BigDecimal calculateInterest(BigDecimal gross, int days, BigDecimal rate){
        BigDecimal dailyRate = rate.divide(new BigDecimal(30.0), new MathContext(20));
        BigDecimal percentage = dailyRate.multiply(new BigDecimal(days)).divide(BigDecimal.TEN).divide(BigDecimal.TEN);
        BigDecimal net = gross.subtract(gross.multiply(percentage)); 
        return net;
    }

    public static char[] getMysqlPassword() {
        return mysqlPassword;
    }

    public static void setMysqlPassword(char[] mysqlPassword) {
        ChequeMate.mysqlPassword = mysqlPassword;
    }
   
}
