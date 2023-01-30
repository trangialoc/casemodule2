package Service.ProductService;

import Models.Product.Product;
import Models.User.User;
import dao.Product.CRUD_product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    static List<Product> products = CRUD_product.getAllProduct();



    public static List<Product> showAllL() {
        return products;
    }

    public static Product returnProduct(int id){
        for (Product product : products) {
            if (product.getIdproduct() == id) {
                return product;
            }
        }
        return null;
    }

    public static Product returnProduct(String nameProduct){
        for (Product product : products) {
            if (product.getNameSP().equals(nameProduct)) {
                return product;
            }
        }
        return null;
    }



}
