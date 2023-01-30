package Controller.UserController_Login;

import Models.User.User;
import Service.UserService.UserService;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "User_SignupServlet", value = "/User_SignupServlet")
public class User_SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Signin_Signup/Signup.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "";
        String name = request.getParameter("Fullname");

        String userName = request.getParameter("UserName");

        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        if (!pattern.matcher(userName).find()) {
            request.setAttribute("messusername", "Nhập username Theo Định Dạng Username@domain.com");

        }

        String passWord = request.getParameter("Password");
        Pattern pattern1 = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
        if (!pattern1.matcher(passWord).find()) {
            request.setAttribute("messpassword", "Tối thiểu sáu ký tự, ít nhất một chữ cái và một số !");
        }

        String Password_x = request.getParameter("Password_x");
        if (!passWord.equals(Password_x)) {
            request.setAttribute("messpassword_x", "Xác nhận sai mật khẩu !");
        }

        if (pattern.matcher(userName).find() && pattern1.matcher(passWord).find() && passWord.equals(Password_x)) {
            User user = new User(name, userName, passWord, "/WedUser/profile-img.jpg", 2);
            boolean checkUser = UserService.checkUser(userName);

            if (checkUser) {
                url = "/Signin_Signup/Signin.jsp";
                UserService.Signup(user);
                CRUD_cart.newCart(user.getUserName());
            } else {
                request.setAttribute("messusername", "Tài khoản đã tồn tại !");
                url = "/Signin_Signup/Signup.jsp";
            }
        }else {
            url = "/Signin_Signup/Signup.jsp";
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}
