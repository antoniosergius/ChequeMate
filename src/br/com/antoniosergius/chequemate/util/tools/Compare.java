package br.com.antoniosergius.chequemate.util.tools;

import br.com.antoniosergius.chequemate.obj.Cashing;
import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.lib.tools.Convert;
import br.com.antoniosergius.lib.tools.Deformat;
import java.util.GregorianCalendar;

public class Compare {
    public static class StringDate implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            GregorianCalendar d1 = Convert.toGregorian(o1);
            GregorianCalendar d2 = Convert.toGregorian(o2);
            return d1.compareTo(d2);
        }
    }
    
    public static class StringTimestamp implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            GregorianCalendar d1 = Convert.toGregorianTimestamp(o1);
            GregorianCalendar d2 = Convert.toGregorianTimestamp(o2);
            return d1.compareTo(d2);
        }
    }
    
    public static class StringDecimal implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            Double v1 = Deformat.andConvertDecimal(o1);
            Double v2 = Deformat.andConvertDecimal(o2);
            return v1.compareTo(v2);
        }
    }
    
    public static class CheckExpiration implements java.util.Comparator<Check> {
        @Override
        public int compare(Check o1, Check o2) {
            GregorianCalendar d1 = o1.getExpiration();
            GregorianCalendar d2 = o2.getExpiration();
            return d1.compareTo(d2);
        }
    }
    
    public static class IntegerCompare implements java.util.Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    
    public static class StringInteger implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            Integer i1 = Integer.parseInt(o1);
            Integer i2 = Integer.parseInt(o2);
            return i1.compareTo(i2);
        }
    }
    
    public static class StringClient implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String temp1 = o1.split(" - ")[1];
            String temp2 = o2.split(" - ")[1];
            return temp1.compareTo(temp2);
        }
    }
    
    public static class CheckId implements java.util.Comparator<Check> {
        @Override
        public int compare(Check o1, Check o2) {
            Integer id1 = o1.getId();
            Integer id2 = o2.getId();
            return id1.compareTo(id2);
        }
    }

    public static class CashingExpiration implements java.util.Comparator<Cashing> {
        @Override
        public int compare(Cashing o1, Cashing o2) {
            GregorianCalendar d1 = o1.getExpiration();
            GregorianCalendar d2 = o2.getExpiration();
            return d1.compareTo(d2);
        }
    }
    
    public static class RegistryNumber implements java.util.Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String temp1 = Deformat.CPForCNPJ(o1);
            String temp2 = Deformat.CPForCNPJ(o2);
            return temp1.compareTo(temp2);
        }
    }
}
