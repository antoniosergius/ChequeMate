package br.com.antoniosergius.chequemate.report;

import br.com.antoniosergius.chequemate.ctrl.ClientController;
import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.chequemate.util.MyPath;
import br.com.antoniosergius.lib.report.DataSource;
import br.com.antoniosergius.lib.report.DataSourceFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class ReportFactory {
    private static final Logger LOG = Logger.getLogger(ReportFactory.class.getName());
    
    private Connection conn;
    private int idClient;
    private ClientController clientControl;
     
    public ReportFactory(Connection conn, int idClient) {
        this.conn = conn;
        this.idClient = idClient;
        clientControl = new ClientController(conn);
    }
    
    public ReportFactory() {
    }
    
    public static void viewRecord(String jasperFile, String client, DataSource<?> dataSource) 
            throws SQLException, JRException, IOException {
        HashMap<String, Object> param = new HashMap<>();
        param.put("cliente", client);
        ReportFactory.show(MyPath.REPORTS+jasperFile, "ReciboChequesDataSource.jrprint", param, dataSource);
    }
    
    public static void viewRecord(String client, ArrayList<Check> checkList) 
            throws SQLException, JRException, IOException {
        HashMap<String, Object> param = new HashMap<>();
        param.put("cliente", client);
        ReportFactory.show(MyPath.REPORTS+"ReciboChequesDataSource.jasper", 
                "ReciboChequesDataSource.jrprint", param,
                new RecordDataSource(checkList));
    }
    
    public static void viewQuery(ArrayList<Check> checkList) throws SQLException, JRException, IOException {
        ReportFactory.show(MyPath.REPORTS+"ConsultasDataSource.jasper", 
                "ConsultasDataSource.jrprint", 
                new HashMap<>(),
                new QueryDataSource(checkList));
    }
    
    public static void viewCashing(ArrayList<Cashing> list) throws SQLException, JRException, IOException {
        ReportFactory.show(MyPath.REPORTS+"DescontoDataSource.jasper", 
                "DescontoDataSource.jrprint", 
                new HashMap<>(),
                new CashingDataSource(list));
    }
  
    public void view(String jasperFile) throws SQLException, JRException, IOException {
        if (!clientControl.hasRecords(idClient)) {
            throw new SQLException("Cliente não possui nenhum cheque cadastrado.");
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("CodigoCliente", idClient);
        show(jasperFile, "ChequesPorCliente.jrprint", param);
        
    }
    
    public void viewByInputDate(String jasperFile, GregorianCalendar date) throws SQLException, JRException, IOException {
        if (!clientControl.hasRecords(idClient, date)) {
            throw new SQLException("Cliente não possui cheque(s) cadastrado(s) na data especificada.");
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("CodigoCliente", idClient);
        param.put("DataEntrada", date.getTime());
        show(jasperFile, "ChequesDataEntradaCliente.jrprint", param);
    }
    
    public void viewByInputRange(String jasperFile, GregorianCalendar begin, GregorianCalendar end) 
            throws SQLException, JRException, IOException {
        if (!clientControl.hasRecords(idClient, begin, end)) {
            throw new SQLException("Cliente não possui cheque(s) cadastrado(s) no intervalo correspondente.");
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("CodigoCliente", idClient);
        param.put("DataInicio", begin.getTime());
        param.put("DataFim", end.getTime());
        show(jasperFile, "ChequesIntervaloDataEntradaCliente.jrprint", param);
    }
    
    private void show(String jasperFile, String printFile, HashMap<String, Object> param) throws JRException {
        JasperFillManager.fillReportToFile(jasperFile, param, conn);
        SwingUtilities.invokeLater(new ReportFactory.Show(printFile));
    }
    
    private static void show(String jasperFile, String printFile, HashMap<String, Object> param, DataSource<?> dataSource) throws JRException {
        DataSourceFactory.setData(dataSource);
        JasperFillManager.fillReportToFile(jasperFile, param, DataSourceFactory.createDatasource());
        SwingUtilities.invokeLater(new ReportFactory.Show(printFile));
    }
    
    private static class Show implements Runnable{
        private final String file;
        public Show(String file) {
            this.file = file;
        }
        @Override
        public void run() {
            try {
                JasperViewer viewer = new JasperViewer(MyPath.REPORTS + file, false, false, ChequeMate.LOCALE);
                viewer.setTitle("Visualizador de Relatório");
                viewer.setVisible(true);
            } catch (JRException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            } 
        }
    }
}
