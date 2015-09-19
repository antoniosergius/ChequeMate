package br.com.antoniosergius.chequemate.report;

import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.lib.report.DataSource;
import br.com.antoniosergius.lib.tools.Format;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class CashingDataSource extends DataSource<Cashing>{

    public CashingDataSource(ArrayList<Cashing> list) {
        super(list);
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Cashing cashing = getCurrent();
        if (field.getName().equals("valor")) {
            return cashing.getGross();
        }
        if (field.getName().equals("valorLiquido")) {
            return cashing.getNet();
        }
        if (field.getName().equals("juro")) {
            return cashing.getInterest();
        }
        if (field.getName().equals("date")) {
            return Format.date(cashing.getExpiration());
        }
        if (field.getName().equals("dataCalculo")) {
            return Format.date(cashing.getCalcDate());
        }
        if (field.getName().equals("taxa")) {
            return Format.decimal(cashing.getRate());
        }
        return null;
    }
    
}
