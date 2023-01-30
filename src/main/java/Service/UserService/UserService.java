package Service.UserService;

import Models.User.User;
import dao.Cart.CRUD_cart;
import dao.User.CRUD_user;

import java.util.List;

public class UserService {
    static List<User> users = CRUD_user.getAllUser();

    public static void Signup(User user) {
        users.add(user);
        CRUD_user.save(user);
    }

    public static boolean checkUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static User returnUser(String username, String pass) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassWord().equals(pass)) {
                return user;
            }
        }
        return null;
    }

    public static void Edit(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(user.getUserName())) {
                users.set(i, user);
                CRUD_user.Update(user);
            }
        }
    }
}
