package Models.Product;

public class Product {

    private int idproduct;
    private String nameSP;
    private int price;
    private String img;
    private int amount;
    private int productType;

    public Product() {
    }

    public Product(int idproduct, String nameSP, int price, String img, int amount, int productType) {
        this.idproduct = idproduct;
        this.nameSP = nameSP;
        this.price = price;
        this.img = img;
        this.amount = amount;
        this.productType = productType;
    }

    public Product(String nameSP, int price, String img, int amount, int productType) {
        this.nameSP = nameSP;
        this.price = price;
        this.img = img;
        this.amount = amount;
        this.productType = productType;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
