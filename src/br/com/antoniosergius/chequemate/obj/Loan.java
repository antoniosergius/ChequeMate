package br.com.antoniosergius.chequemate.obj;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Loan {
    BigDecimal gross;
    BigDecimal rate;
    BigDecimal fee;
    BigDecimal months;

    public Loan() {
      
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public BigDecimal getRate() {
        return rate.multiply(new BigDecimal(100));
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate.divide(new BigDecimal(100));
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMonths() {
        return months;
    }

    public void setMonths(BigDecimal month) {
        this.months = month;
    }
    
    public void calculateFee() {
        double toPower = BigDecimal.ONE.add(rate).doubleValue();
        double exp = months.negate().doubleValue();
        BigDecimal power = new BigDecimal(Math.pow(toPower, exp));
        BigDecimal denominator = BigDecimal.ONE.subtract(power);
        fee = gross.multiply(rate).divide(denominator, 
                new MathContext(40, RoundingMode.HALF_EVEN));
        checkValue(fee.doubleValue());
    }
    
    public void calculateGross() {
        double toPower = BigDecimal.ONE.add(rate).doubleValue();
        double exp = months.negate().doubleValue();
        BigDecimal power = new BigDecimal(Math.pow(toPower, exp));
        BigDecimal nominator = BigDecimal.ONE.subtract(power);
        nominator = nominator.multiply(fee);
        gross = nominator.divide(rate, new MathContext(40, RoundingMode.HALF_EVEN));
        checkValue(gross.doubleValue());
    }
    
    public void calculateMonths() {
        double lnNominator = Math.log(fee.divide(fee.subtract(rate.multiply(gross)), 
                new MathContext(40, RoundingMode.HALF_EVEN)).doubleValue());
        double denominator = Math.log(1+rate.doubleValue());
        checkValue(denominator);
        checkValue(lnNominator);
        months = new BigDecimal(lnNominator/denominator);
        checkValue(months.doubleValue());
    }
    
    public void calculateRate() {
        for (BigDecimal i=new BigDecimal(0.00001); 
             i.compareTo(BigDecimal.ONE)<=0; 
             i=i.add(new BigDecimal(0.00001))) {
            
            double toPower = BigDecimal.ONE.add(i).doubleValue();
            double exp = months.negate().doubleValue();
            BigDecimal power = new BigDecimal(Math.pow(toPower, exp));
            BigDecimal denominator = BigDecimal.ONE.subtract(power);
            BigDecimal auxFee = gross.multiply(i).divide(denominator, 
                    new MathContext(40, RoundingMode.HALF_EVEN));
            checkValue(auxFee.doubleValue());
            System.out.println(auxFee);
            if (auxFee.setScale(0,RoundingMode.FLOOR).compareTo(
                    fee.setScale(0, RoundingMode.FLOOR))==0) {
                fee = auxFee;
                rate = i;
                break;
            } else if(auxFee.compareTo(fee)>0) {
                break;
            }
        }
        if (rate == null) { 
            throw new ArithmeticException("Os valores especificados geraram resultado infinito.");
        }
        
    }
    
    public void calculate() throws ArithmeticException{
        if (fee == null) {
            calculateFee();
        } else if (gross == null) {
           calculateGross();
        } else if (months == null) {
           calculateMonths();
        } else if (rate == null) {
           calculateRate(); 
        }
    }
    
    public void checkValue(double result) throws ArithmeticException {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new ArithmeticException("Os valores especificados geraram resultado infinito.");
        }
    }
    
    @Override
    public String toString() {
        return "BigDecimalLoan{" + "gross=" + gross + ", rate=" + rate + ", \nfee=" + fee + ", months=" + months + '}';
    }
    
    public BigDecimal getRetention() {
        return getFeeSum().subtract(gross);
    }
    
    public BigDecimal getFeeSum() {
        return fee.multiply(months);
    }
    
}
