package br.com.antoniosergius.chequemate.ctrl;

import br.com.antoniosergius.chequemate.obj.Holiday;
import br.com.antoniosergius.chequemate.obj.Parameters;
import br.com.antoniosergius.chequemate.util.ChequeMate;
import br.com.antoniosergius.lib.tools.Days;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.joda.time.DateMidnight;

public class HolidayController {

    private Connection conn;
    private HashMap<DateMidnight, Holiday> map;
    private ArrayList<Holiday> list;
    private ArrayList<Date> dateList;
    
    public HolidayController() {
    }

    public HolidayController(Connection conn) {
        this.conn = conn;
    }
    
    public void createInstances(Connection conn) throws SQLException {
        this.conn = conn;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.dateList = new ArrayList<>();
        Days.setTodayToMidnight();
        setupCollections();
    }

    public HashMap<DateMidnight, Holiday> getMap() {
        return map;
    }

    public void setMap(HashMap<DateMidnight, Holiday> map) {
        this.map = map;
    }

    public ArrayList<Holiday> getList() {
        return list;
    }

    public ArrayList<Date> getDateList() {
        return dateList;
    }
    
    public void setupCollections() throws SQLException { 
        clearData();
        try (Statement state = conn.createStatement(); 
             ResultSet result = state.executeQuery("SELECT dia, mes, ano, descricao, idFeriado FROM feriado")) {
            
            Holiday holiday;
            int i = 0;
            while (result.next()) {
                int day = result.getInt(1);
                int month = result.getInt(2);
                int year = result.getInt(3);
                String description = result.getString(4);
                
                holiday = new Holiday(day, month, description);
                holiday.setId(result.getInt(5));
                if (year != 0) {
                    holiday.setYear(year);
                } 
                GregorianCalendar date = holiday.getDate();
                list.add(holiday);
                dateList.add(date.getTime());
                map.put(new DateMidnight(date.getTimeInMillis()), holiday);
                if (year == 0) {
                    GregorianCalendar nextYear = new GregorianCalendar();
                    nextYear.setTime(date.getTime());
                    nextYear.add(GregorianCalendar.YEAR, 1);
                    Holiday next = new Holiday(nextYear, description);
                    dateList.add(nextYear.getTime());
                    map.put(new DateMidnight(nextYear.getTimeInMillis()), next);

                    GregorianCalendar next2Year = new GregorianCalendar();
                    next2Year.setTime(nextYear.getTime());
                    next2Year.add(GregorianCalendar.YEAR, 1);
                    Holiday next2 = new Holiday(next2Year, description);
                    dateList.add(next2Year.getTime());
                    map.put(new DateMidnight(next2Year.getTimeInMillis()), next2);
                }
                i++;
            }
        }
    }
    
    public Date[] getArrayDate() {
        Date [] dateArray = new Date[getDateList().size()];
        return dateList.toArray(dateArray);
    }
    
    
    public Date nextBusinessDate(Date date, int type) {
        if (date==null) {
            return null;
        }
        GregorianCalendar gDate = new GregorianCalendar();
        gDate.setTime(date);
        int daysBetween = Days.between(Days.TODAY, gDate);
        
        if (type == Parameters.WITH_MIN_DAYS && daysBetween>0) {
            int addedDays = 0;
            int minExpirationDays = ChequeMate.getParameters().getMinExpirationDays();
            if (daysBetween < minExpirationDays) {
                addedDays = minExpirationDays-daysBetween;
            }
            gDate.add(GregorianCalendar.DAY_OF_YEAR, addedDays);
        } 
        while (map.containsKey(new DateMidnight(gDate.getTimeInMillis())) || 
            gDate.get(GregorianCalendar.DAY_OF_WEEK)==GregorianCalendar.SATURDAY || 
            gDate.get(GregorianCalendar.DAY_OF_WEEK)==GregorianCalendar.SUNDAY) {
                gDate.add(GregorianCalendar.DAY_OF_YEAR, 1);
        }
        return gDate.getTime();
    }

    public GregorianCalendar getMinInputDate() throws SQLException{
        int numeroRegistros = new CheckController(conn).count();
        if (numeroRegistros == 0) {
            return Days.TODAY;
        }
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery("SELECT MIN(dataEntrada) as minima FROM cheque")){

            if (result.next()) {
                GregorianCalendar dateMin = new GregorianCalendar();
                dateMin.setTimeInMillis(result.getDate(1).getTime());
                return dateMin;
            }
                 
        }
        return Days.TODAY;
    }
    
    public GregorianCalendar getMaxInputDate() throws SQLException{
        int numeroRegistros = new CheckController(conn).count();
        if (numeroRegistros == 0) {
            return Days.TODAY;
        }
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery("SELECT MAX(dataEntrada) as minima FROM cheque")){

            if (result.next()) {
                GregorianCalendar dateMin = new GregorianCalendar();
                dateMin.setTimeInMillis(result.getDate(1).getTime());
                return dateMin;
            }
                 
        }
        return Days.TODAY;
    }
    
    public GregorianCalendar getMinExpirationDate() throws SQLException{
        int numeroRegistros = new CheckController(conn).count();
        if (numeroRegistros == 0) {
            return Days.TODAY;
        }
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery("SELECT MIN(dataBoa) as minima FROM cheque")){

            if (result.next()) {
                GregorianCalendar dateMin = new GregorianCalendar();
                dateMin.setTimeInMillis(result.getDate(1).getTime());
                return dateMin;
            }
                 
        }
        return Days.TODAY;
    }

    public void insert(Holiday holiday) throws SQLException {
        String sql = "INSERT INTO feriado (dia, mes, ano, descricao) values (?,?,?,?)";
        try (PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pst.setInt(1, holiday.getDay());
            pst.setInt(2, holiday.getMonth());
            pst.setInt(3, holiday.getYear());
            pst.setString(4, holiday.getDescription());
            pst.executeUpdate();
            try (ResultSet key = pst.getGeneratedKeys()) {
                if (key.next()) {
                    int id = key.getInt(1);
                    holiday.setId(id);
                }
            }
        }
    }
    
    public void delete(int id) throws SQLException {
        String sql = "DELETE from feriado WHERE idFeriado = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
    
    public boolean exists(int id) throws SQLException {
        String sql = "SELECT idFeriado from feriado WHERE idFeriado = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, id);
            try (ResultSet result = pst.executeQuery()) {
                return result.next();
            }
        }
    }
    
    public int count() throws SQLException {
        String sql = "SELECT count(idFeriado) from feriado";
        try (Statement state = conn.createStatement();
             ResultSet result = state.executeQuery(sql)){
            
            result.first();
            return result.getInt(1);
        }
    }
    
    public void update(int id, Holiday holiday) throws SQLException {
        String sql = "UPDATE feriado set dia=?, mes=?, ano=?, descricao=? WHERE idFeriado = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setInt(1, holiday.getDay());
            pst.setInt(2, holiday.getMonth());
            pst.setInt(3, holiday.getYear());
            pst.setString(4, holiday.getDescription());
            pst.setInt(5, id);
            pst.executeUpdate();
        }
    }

    private void clearData() {
        list.clear();
        dateList.clear();
        map.clear();
    }

}
