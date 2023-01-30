package Models.Cart;

import java.util.Date;

public class Cart {
    private int idcart;
    private String userName;

    private int status;

    public Cart() {
    }

    public Cart(int idcart, String userName, int status) {
        this.idcart = idcart;
        this.userName = userName;
        this.status = status;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
