package Controller.UserController;

import Service.ProductService.ProductService;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet_Show", value = "/ProductServlet_Show")
public class ProductServlet_Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", CRUD_product.getAllProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", ProductService.showAllL());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUser.jsp");
        requestDispatcher.forward(request, response);
    }
}
