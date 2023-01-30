package Controller.SellerController;

import Service.ProductService.ProductService;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SellerProduct_Servlet", value = "/SellerProduct_Servlet")
public class SellerProduct_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", CRUD_product.getAllProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedSeller/WebSeller.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", ProductService.showAllL());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedSeller/WebSeller.jsp");
        requestDispatcher.forward(request, response);
    }
}
