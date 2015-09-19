package br.com.antoniosergius.chequemate.util;

import br.com.antoniosergius.lib.util.io.Path;
import java.io.File;
import java.io.IOException;

public class MyPath extends Path{
    public static final String LOG = MyPath.APP + "logs" + File.separator;
    public static final String ICONS = MyPath.APP + "icons" + File.separator;
    public static final String REPORTS = MyPath.APP + "reports" + File.separator;
    public static final String REGISTRIES = MyPath.APP + "registries" + File.separator;
    public static final String PREFERENCES = MyPath.APP + "ChequeMate.preferences";
    public static final String BACKUP = MyPath.APP + "bkp" + File.separator;
    public static final String CASHING_FILE = Path.DATA + "lastCashingCheck.as";
    public static final String CREATE_DB = Path.DATA + "createChequemate.sql";
    
    
    public static boolean hasRegistriesFiles() throws IOException {
        File file = new File(MyPath.REGISTRIES);
        if (!file.exists()) {
            if (file.mkdir()) {
                return false;
            } else {
                throw new IOException("Erro ao ler o(s) arquivo(s) de cadastro.");
            }
        } else {
           return file.list(new FilterFile()).length>0; 
        }
    }
}
