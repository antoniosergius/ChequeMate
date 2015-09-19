package br.com.antoniosergius.chequemate.util.tools;

import br.com.antoniosergius.chequemate.obj.Check;
import br.com.antoniosergius.chequemate.obj.Client;
import br.com.antoniosergius.chequemate.util.ChequeMateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    
    public static void byExpiration(ArrayList<Check> list) throws ChequeMateException {
        if (list.isEmpty() || list == null) {
            throw new ChequeMateException("Argumento inválido.");
        }
        Collections.sort(list, new Comparator<Check>() {
            @Override
            public int compare(Check o1, Check o2) {
                return o1.getExpiration().compareTo(o2.getExpiration());
            }
        });
    }
    
    public static void byClientAndGross(ArrayList<Check> list) throws ChequeMateException {
        if (list.isEmpty() || list == null) {
            throw new ChequeMateException("Argumento inválido.");
        }
        Collections.sort(list, new Comparator<Check>() {
            @Override
            public int compare(Check c1, Check c2) {
                String name1 = c1.getClientName();
                String name2 = c2.getClientName();
                int result = name1.compareTo(name2);
                return result == 0 ? ((Double) c1.getGross()).compareTo(c2.getGross()) : result;
            }
        });
    }
    
    public static void byPayeeAndExpiration(ArrayList<Check> list) throws ChequeMateException {
        if (list.isEmpty() || list == null) {
            throw new ChequeMateException("Argumento inválido.");
        }
        Collections.sort(list, new Comparator<Check>() {
            @Override
            public int compare(Check c1, Check c2) {
                int result = c1.getPayee().compareTo(c2.getPayee());
                return result == 0 ? c1.getExpiration().compareTo(c2.getExpiration()) : result;
            }
        });
    }
    
    public static void byClientAndExpiration(ArrayList<Check> list) throws ChequeMateException {
        if (list.isEmpty() || list == null) {
            throw new ChequeMateException("Argumento inválido.");
        }
        Collections.sort(list, new Comparator<Check>() {
            @Override
            public int compare(Check c1, Check c2) {
                String name1 = c1.getClientName();
                String name2 = c2.getClientName();
                int result = name1.compareTo(name2);
                return result == 0 ? c1.getExpiration().compareTo(c2.getExpiration()) : result;
            }
        });
    }
    
    public static void byName(ArrayList<String> list, int position) {
        final int pos = position == Client.ID_SUFFIX? 1 : 0;
        Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String name1 = o1.split(" - ")[pos];
                    String name2 = o2.split(" - ")[pos];
                    return name1.compareTo(name2);
                }
        });
    }
    
}
