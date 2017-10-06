package br.com.antoniosergius.chequemate.obj;

import java.io.File;
import java.io.Serializable;

public class Preferences implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private boolean showSplashScreen;
    private File backupPath;
    private File mysqlPath;
    private int daysToKeepRegistries;
    private double defaultRate;

    public Preferences() {
    }

    public boolean isShowSplashScreen() {
        return showSplashScreen;
    }

    public void setShowSplashScreen(boolean showSplashScreen) {
        this.showSplashScreen = showSplashScreen;
    }

    public File getBackupPath() {
        return backupPath;
    }

    public void setBackupPath(File backupPath) {
        this.backupPath = backupPath;
    }

    public int getDaysToKeepRegistries() {
        return daysToKeepRegistries;
    }

    public void setDaysToKeepRegistries(int daysToKeepRegistries) {
        this.daysToKeepRegistries = daysToKeepRegistries;
    }

    public double getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(double defaultRate) {
        this.defaultRate = defaultRate;
    }

   public File getMysqlPath() {
      return mysqlPath;
   }

   public void setMysqlPath(File mysqlPath) {
      this.mysqlPath = mysqlPath;
   }

    @Override
    public String toString() {
        return "Preferences{" + "showSplashScreen=" + showSplashScreen +
                ", backupPath=" + backupPath + ", daysToKeepRegistries=" 
                + daysToKeepRegistries + ", defaultRate=" + defaultRate + '}';
    }
    
}
