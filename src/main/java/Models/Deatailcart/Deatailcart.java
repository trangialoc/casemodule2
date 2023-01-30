package Models.Deatailcart;

import java.util.Date;

public class Deatailcart {
    private int idcart;
    private int idproduct;
    private int amoutProduct;

    public Deatailcart() {
    }

    public Deatailcart(int idcart, int idproduct, int amoutProduct) {
        this.idcart = idcart;
        this.idproduct = idproduct;
        this.amoutProduct = amoutProduct;
    }

    public int getIdcart() {
        return idcart;
    }

    public void setIdcart(int idcart) {
        this.idcart = idcart;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getAmoutProduct() {
        return amoutProduct;
    }

    public void setAmoutProduct(int amoutProduct) {
        this.amoutProduct = amoutProduct;
    }
}
