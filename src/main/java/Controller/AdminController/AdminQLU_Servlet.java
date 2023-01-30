package Controller.AdminController;

import Models.Product.Product;
import Models.User.User;
import Service.Cart.Cart_Service;
import dao.Cart.CRUD_cart;
import dao.Product.CRUD_product;
import dao.User.CRUD_user;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminQLU_Servlet", value = "/AdminQLU_Servlet")
public class AdminQLU_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user", CRUD_user.getAllUser());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedAdmin/WebAdminQLU.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String userName = request.getParameter("userName");
        String userpassWord = request.getParameter("userpassWord");
        String img = request.getParameter("img");
        int roles = Integer.parseInt(request.getParameter("roles"));
        User user = new User(name, userName, userpassWord, img, roles);
        String url = "/AdminQLU_Servlet";
        String action = request.getParameter("action");
        switch (action) {
            case "Edit":
                CRUD_user.UpdateUser(user);
                url = "/AdminQLU_Servlet";
                break;
            case "Delete":
                CRUD_cart.deleteBill(user);
                ArrayList<Integer> idCart = Cart_Service.idCart(user, CRUD_cart.getCartAll());
                for (Integer integer : idCart) {
                    CRUD_cart.deleteDeatailAdmin(integer);
                }
                CRUD_cart.deleteCart(user);
                CRUD_user.deleteUser(user);
                url = "/AdminQLU_Servlet";
                break;
        }
        response.sendRedirect(url);
    }
}
