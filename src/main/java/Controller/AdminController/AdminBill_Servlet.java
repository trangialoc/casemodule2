package Controller.AdminController;

import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminBill_Servlet", value = "/AdminBill_Servlet")
public class AdminBill_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bill", CRUD_cart.showBillAll());
        request.setAttribute("DoanhThu", CRUD_cart.Bill());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedAdmin/WebAdminHistory.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
