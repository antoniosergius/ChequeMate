package br.com.antoniosergius.chequemate.report;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.lib.report.DataSource;
import br.com.antoniosergius.lib.tools.Format;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class RecordDataSource extends DataSource<Check>{
    private static final long serialVersionUID = 1L;    

    public RecordDataSource(ArrayList<Check> list) {
        super(list);
    }
    
    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Check check = getCurrent();
        if (field.getName().equals("numero")) {
            return Format.checkNumber(check.getNumber());
        }
        if (field.getName().equals("banco")) {
            return Format.bank(check.getBank());
        }
        if (field.getName().equals("agencia")) {
            return Format.agency(check.getAgency());
        }
        if (field.getName().equals("valor")) {
            return check.getGross();
        }
        if (field.getName().equals("date")) {
            return Format.date("dd/MM/yy", check.getExpiration());
        }
        if (field.getName().equals("dataCalculo")) {
            return Format.date("dd/MM/yy", check.getCalcDate());
        }
        if (field.getName().equals("emitente")) {
            return check.getPayee().getName();
        }
        if (field.getName().equals("cadastro")) {
            String registry = check.getPayee().getRegistryNumber();
            return "".equals(registry) ? "           " : registry;
        }
        if (field.getName().equals("valorLiquido")) {
            return check.getNet();
        }
        return null;
    }
}
