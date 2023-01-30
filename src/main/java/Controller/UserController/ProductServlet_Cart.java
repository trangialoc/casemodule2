package Controller.UserController;

import Models.Product.Product;
import Models.User.User;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet_Cart", value = "/ProductServlet_Cart")
public class ProductServlet_Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        List<Product> products = CRUD_cart.getProductCart(user.getUserName());
        request.setAttribute("product", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUserCart.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
