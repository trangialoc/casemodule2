package dao.Cart;

import Models.Bill.Bill;
import Models.Cart.Cart;
import Models.Deatailcart.Deatailcart;
import Models.Product.Product;
import Models.User.User;
import dao.User.CRUD_user;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CRUD_cart {
    public static void newCart(String userName) {
        try {
            String sql = "INSERT INTO cart (userName, status) VALUES (?,?);";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, "1");
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Cart getCart(User user) {
        Cart cart = new Cart();
        String sql = "Select * from cart where userName = ? and status > 0";

        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcart = resultSet.getInt("idCart");
                String userName = resultSet.getString("userName");
                int amout = resultSet.getInt("Status");
                cart = new Cart(idcart, userName, amout);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cart;
    }

    public static List<Cart> getCartAll() {
        List<Cart> carts = new ArrayList<>();
        String sql = "Select * from cart";

        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcart = resultSet.getInt("idCart");
                String userName = resultSet.getString("userName");
                int amout = resultSet.getInt("Status");
                carts.add(new Cart(idcart, userName, amout));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carts;
    }

    public static List<Product> getProductCart(String userName) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select product.idproduct, product.nameproduct, product.price, product.img , sum( deatail.amout) as amount, product.idproductType from cart join deatail on deatail.idcart = cart.idcart join product on deatail.idproduct = product.idproduct where userName = ? and Status > 0 group by idproduct";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String nameSP = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amount = resultSet.getInt("amount");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, nameSP, price, img, amount, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static void deleteCart(User user) {
        try {
            String sql = "DELETE FROM cart WHERE userName = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void newdeatail(int idproduct, int idcart, int amount) {
        try {
            String sql = "insert into deatail(idcart,idproduct,amout) value (?,?,?)";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idcart);
            preparedStatement.setInt(2, idproduct);
            preparedStatement.setInt(3, amount);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDeatail(int idproduct) {
        try {
            String sql = "DELETE FROM deatail WHERE idproduct = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idproduct);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDeatailAdmin(int idCart) {
        try {
            String sql = "DELETE FROM deatail WHERE idcart = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCart);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void deleteBill(User user) {
        try {
            String sql = "DELETE FROM bill WHERE userName = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int TotalBill(String userName, int idCart) {
        int totalBill = 0;
        try {
            String sql = " select sum(bill) as totabill  from (select cart.idcart, product.idproduct, (sum( deatail.amout)*product.price) as bill from cart join deatail on deatail.idcart = cart.idcart  join product on deatail.idproduct = product.idproduct " + "where userName = ? " + "group by idproduct) as totabill " + "where idcart = ? " + "group by idcart;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, idCart);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                totalBill += resultSet.getInt("totabill");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalBill;
    }

    public static void newBill(Bill bill) {
        try {
            String sql = "insert into bill (userName,idCart,Date,totalBill) value (?,?,?,?)";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, bill.getUserName());
            preparedStatement.setInt(2, bill.getIdcart());
            preparedStatement.setDate(3, Date.valueOf(bill.getDate().toLocalDate()));
            preparedStatement.setInt(4, bill.getTotabill());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateStatus(String userName, int idCart) {
        try {
            String sql = "UPDATE cart set status = 0 where userName = ? and idcart= ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, idCart);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Bill> showBill(User user) {
        List<Bill> bills = new ArrayList<>();
        try {
            String sql = "select * from bill where userName = ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBill = resultSet.getInt("idBill");
                int idcart = resultSet.getInt("idcart");
                String userName = resultSet.getString("userName");
                LocalDateTime date = resultSet.getDate("date").toLocalDate().atStartOfDay();
                int totalbill = resultSet.getInt("totalbill");
                bills.add(new Bill(idBill,userName, idcart, date, totalbill));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bills;
    }

    public static List<Deatailcart> showDeatail(Cart cart) {
        List<Deatailcart> deatailcarts = new ArrayList<>();
        try {
            String sql = "select * from deatail where idcart = ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, cart.getIdcart());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idcart = resultSet.getInt("idcart");
                int idproduct = resultSet.getInt("idproduct");
                int amout = resultSet.getInt("amout");
                deatailcarts.add(new Deatailcart(idcart, idproduct, amout));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return deatailcarts;
    }


    public static List<Bill> showBillAll() {
        List<Bill> bills = new ArrayList<>();
        try {
            String sql = "select * from bill ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBill = resultSet.getInt("idBill");
                int idcart = resultSet.getInt("idcart");
                String userName = resultSet.getString("userName");
                LocalDateTime date = resultSet.getDate("date").toLocalDate().atStartOfDay();
                int totalbill = resultSet.getInt("totalbill");
                bills.add(new Bill(idBill,userName, idcart, date, totalbill));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bills;
    }


    public static int Bill() {
        int Bill = 0;
        try {
            String sql = "select sum(totalbill) as 'Tong' from bill";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bill += resultSet.getInt("Tong");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Bill;
    }


    public static ArrayList<Product> getProductBill(int idBill) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select product.idproduct, product.nameproduct, product.price,product.img,deatail.amout,product.idproductType  from bill join cart on cart.idcart = bill.idCart join deatail on deatail.idcart = cart.idcart join product on product.idproduct = deatail.idproduct where idBill = ?";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, idBill);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String nameSP = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amount = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, nameSP, price, img, amount, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
