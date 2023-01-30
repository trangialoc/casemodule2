package dao.User;

import Models.Product.Product;
import Models.User.User;
import dao.Connect_MySql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_user {
    public static Connection connection = Connect_MySql.getConnect();

//    public static List<User> getAll() {
//        String sql = "Select * from acount";
//        List<User> users = new ArrayList<>();
//        try {
//            // tạo cái xe để đưa câu lệnh sql qua CSDL
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String userName = resultSet.getString("userName");
//                String passWord = resultSet.getString("userpassWord");
//                String img = resultSet.getString("img");
//                int role = resultSet.getInt("id_role");
//                users.add(new User(name, userName, passWord, img, role));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return users;
//    }

    public static User returnUser(String username, String password) {
        String sql = "Select * from acount where userName  = ? and userpassWord = ?";
        User user = null;
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("userpassWord");
                String img = resultSet.getString("img");
                int role = resultSet.getInt("id_role");
                user = new User(name, userName, passWord, img, role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public static List<User> getAllUser() {
        String sql = "Select * from acount where id_role <> 1";
        List<User> users = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("userpassWord");
                String img = resultSet.getString("img");
                int role = resultSet.getInt("id_role");
                users.add(new User(name, userName, passWord, img, role));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }



    public static void save(User user) {
        try {
            String sql = "insert into acount(name ,userName ,userpassWord,img, id_role) value ( ?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassWord());
            preparedStatement.setString(4, user.getImg());
            preparedStatement.setString(5, String.valueOf(user.getRole()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Update(User user) {
        try {
            String sql = "UPDATE acount set name = ?, userpassWord = ?, img = ?  where userName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setString(3, user.getImg());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateUser(User user) {
        try {
            String sql = "UPDATE acount set id_role = ?  where userName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getRole());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteUser(User user) {
        try {
            String sql = "DELETE FROM acount WHERE userName = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
