package dao.Product;

import Models.Product.Product;
import Models.User.User;
import dao.User.CRUD_user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD_product {
    public static List<Product> getAllProduct() {
        String sql = "Select * from product where amout > 0";
        List<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = CRUD_user.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static List<Product> getAllProduct(int idProduct) {
        String sql = "Select * from product where idProduct = ?";
        List<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static Product getProduct(int idProduct) {
        String sql = "Select * from product where idProduct = ?";
        Product product = null;
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProduct);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                product = new Product(idproduct, name, price, img, amout, productType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public static List<Product> getPod(int idproductType) {
        String sql = "Select * from product where idproductType = ?";
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idproductType);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }


    public static List<Product> getPrice(int price1, int price2) {
        String sql = "Select * from product where price BETWEEN ? and ?";
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, price1);
            preparedStatement.setInt(2, price2);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static List<Product> getNameProduct(String nameProduct) {
        String search = "%"+ nameProduct + "%";
        String sql = "SELECT * FROM product WHERE nameproduct LIKE ?";
        ArrayList<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, search  );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static void saveProduct(Product product) {
        try {
            String sql = "insert into product(nameproduct ,img ,amout,price, idproductType) value ( ?,?,?,?,?)";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameSP());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getProductType());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateProduct(Product product) {
        try {
            String sql = "UPDATE product set nameproduct = ?, img = ?, amout = ?,price = ?,idproductType = ?  where idproduct = ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameSP());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getProductType());
            preparedStatement.setInt(6, product.getIdproduct());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateProduct_x(Product product, int amout_x) {
        try {
            String sql = "UPDATE product set amout = ? where idproduct = ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, amout_x);
            preparedStatement.setInt(2, product.getIdproduct());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(Product product) {
        try {
            String sql = "DELETE FROM product WHERE idproduct = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getIdproduct());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
