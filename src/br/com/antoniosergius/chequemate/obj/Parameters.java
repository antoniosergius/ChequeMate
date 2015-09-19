package br.com.antoniosergius.chequemate.obj;

public class Parameters {
    public static final int WITH_MIN_DAYS = -51;
    public static final int WITHOUT_MIN_DAYS = -50;
    private int minExpirationDays;
    private int daysToDelete;
    private boolean autoDelete;

    public Parameters() {
        this.minExpirationDays = 0;
        this.daysToDelete = 0;
        this.autoDelete = true;
    }

    public Parameters(int minExpirationDays, int daysToDelete, boolean autoDelete) {
        this.minExpirationDays = minExpirationDays;
        this.daysToDelete = daysToDelete;
        this.autoDelete = autoDelete;
    }

    public int getMinExpirationDays() {
        return minExpirationDays;
    }

    public void setMinExpirationDays(int minExpirationDays) {
        this.minExpirationDays = minExpirationDays;
    }

    public int getDaysToDelete() {
        return daysToDelete;
    }

    public void setDaysToDelete(int daysToDelete) {
        this.daysToDelete = daysToDelete;
    }

    public boolean isAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    @Override
    public String toString() {
        return "Parameters{" + "minExpirationDays=" + minExpirationDays + 
                ", daysToDelete=" + daysToDelete + ", autoDelete=" + autoDelete + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.minExpirationDays;
        hash = 89 * hash + this.daysToDelete;
        hash = 89 * hash + (this.autoDelete ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parameters other = (Parameters) obj;
        if (this.minExpirationDays != other.minExpirationDays) {
            return false;
        }
        if (this.daysToDelete != other.daysToDelete) {
            return false;
        }
        if (this.autoDelete != other.autoDelete) {
            return false;
        }
        return true;
    }

    public Parameters copy() {
        return new Parameters(minExpirationDays, daysToDelete, autoDelete);
    }    
    
    
}
