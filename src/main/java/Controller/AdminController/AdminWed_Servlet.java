package Controller.AdminController;

import Models.User.User;
import Service.ProductService.ProductService;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminWed_Servlet", value = "/AdminWed_Servlet")
public class AdminWed_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", CRUD_product.getAllProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedAdmin/WebAdmin.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", CRUD_product.getAllProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedAdmin/WebAdmin.jsp");
        requestDispatcher.forward(request, response);
    }
}
