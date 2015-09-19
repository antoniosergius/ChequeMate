package br.com.antoniosergius.chequemate.util.io;

import br.com.antoniosergius.chequemate.obj.record.RecordCashing;
import java.io.Serializable;

public class CashingFile implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private double rate;
    private RecordCashing record;

    public CashingFile(double rate, RecordCashing record) {
        this.rate = rate;
        this.record = record;
    }

    public CashingFile() {
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public RecordCashing getRecordCashing() {
        return record;
    }

    public void setRecordCashing(RecordCashing record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "CashingFile{" + "rate=" + rate + ", cashingRecord=" + record + '}';
    }
}
