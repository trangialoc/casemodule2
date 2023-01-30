package Controller.UserController;

import Models.Product.Product;
import Models.User.User;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeatailBillServlet", value = "/DeatailBillServlet")
public class DeatailBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        request.setAttribute("bill", CRUD_cart.showBill(user));

        int idBill = Integer.parseInt(request.getParameter("id"));
        ArrayList<Product> products = CRUD_cart.getProductBill(idBill);
        request.setAttribute("product", products);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUserHistory.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
