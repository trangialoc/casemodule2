package Controller.UserController_Login;

import Models.Cart.Cart;
import Models.User.User;
import Service.UserService.UserService;
import dao.Cart.CRUD_cart;
import dao.User.CRUD_user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/User_SigninServlet")
public class User_SigninServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Signin_Signup/Signin.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = request.getParameter("UserName");
        String passWord = request.getParameter("Password");
        User user = CRUD_user.returnUser(userName, passWord);
        String url = "";
        if (user != null) {
            if (user.getRole() == 1) {
                session.setAttribute("User", user);
                url = "/AdminWed_Servlet";
                request.setAttribute("User", user);
            } else if (user.getRole() == 3) {
                session.setAttribute("User", user);
                url = "/SellerProduct_Servlet";
                request.setAttribute("User", user);
            } else {

                session.setAttribute("User", user);
                url = "/ProductServlet_Show";
                request.setAttribute("User", user);
            }
        } else {
            request.setAttribute("messeger", "Sai mật khẩu hoặc tài khoản không tồn tại !");
            url = "/Signin_Signup/Signin.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

}
