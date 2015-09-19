package other;

import br.com.antoniosergius.chequemate.ctrl.CheckController;
import br.com.antoniosergius.chequemate.ctrl.PayeeController;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.io.RecordFile;
import br.com.antoniosergius.lib.util.MySQLParameters;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
@Deprecated
public class RecoveryMain {
    private static final Logger LOG = Logger.getLogger(RecoveryMain.class.getName());

    private static Connection conn;
    private static RecordFile recordFile;
    //private static SerializeRecord serialize = new SerializeRecord();
    private static CheckController checkControl;
    private static PayeeController payeeControl;
    private static ArrayList<Check> allChecks = new ArrayList<>();
    private static int totalCheques = 0;
    
    public static void main(String[] args) {
        try {
            conn = ChequeMate.registerDB(new MySQLParameters("sergio", 3306, "chequemate", "sergio"), new char[]{'k','2','5'});
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        payeeControl = new PayeeController(conn);
        try {
            payeeControl.queryAndInsertMissingPayees();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
    }
    /*
    private static void setupRecoveryFiles() throws SQLException {
        File dir = new File(MyPath.REGISTRIES);
        File file[] = dir.listFiles(new MyPath.FilterFile());
        int tot = file.length;
        System.out.println("Total de arquivos: "+tot);
        for (int i=0; i<tot; i++) {
            String name = file[i].getName();
            String dateAndTime[] = name.split("-")[1].split("~");
            String date = dateAndTime[0].replaceAll("\\.", "/");
            String[] time = dateAndTime[1].split("\\.");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            GregorianCalendar input = Convert.toGregorian(date);
            input.set(GregorianCalendar.MILLISECOND, 0);
            input.set(GregorianCalendar.SECOND, 0);
            input.set(GregorianCalendar.MINUTE, minute);
            input.set(GregorianCalendar.HOUR_OF_DAY, hour);
            doRestore(file[i], input);
        }
        
    }

    private static void doRestore(File filePath, GregorianCalendar input) {
        try {
            recordFile = serialize.read(filePath.getName());
            for (Check c : recordFile.getCheckList()) {
                c.setInputDate(input);
            }
            checkControl.insertListWithIdAndInputDate(recordFile.getCheckList());
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            LOG.severe(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            LOG.severe(ex.getMessage());
        }
    }*/
    
}
