package Controller.AdminController;

import Models.Product.Product;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DetailBillAdminServlet", value = "/DetailBillAdminServlet")
public class DetailBillAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bill", CRUD_cart.showBillAll());
        request.setAttribute("DoanhThu", CRUD_cart.Bill());

        int idBill = Integer.parseInt(request.getParameter("id"));
        ArrayList<Product> products = CRUD_cart.getProductBill(idBill);
        request.setAttribute("product", products);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedAdmin/WebAdminHistory.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
