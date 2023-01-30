package Models.Bill;

import java.sql.Date;
import java.time.LocalDateTime;

public class Bill {
    private int idBill;
    private String userName;
    private int idcart;
    private LocalDateTime date;

    private int totabill;

    public Bill(int idBill, String userName, int idcart, LocalDateTime date, int totabill) {
        this.idBill = idBill;
        this.userName = userName;
        this.idcart = idcart;
        this.date = date;
        this.totabill = totabill;
    }

    public Bill(String userName, int idcart, LocalDateTime date, int totabill) {
        this.userName = userName;
        this.idcart = idcart;
        this.date = date;
        this.totabill = totabill;
    }

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getTotabill() {
        return totabill;
    }

    public void setTotabill(int totabill) {
        this.totabill = totabill;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
