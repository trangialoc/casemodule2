package Controller.UserController;

import Models.Product.Product;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchProductServlet", value = "/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        List<Product> products = new ArrayList<>();

        switch (action) {
            case "productType":
                int value = Integer.parseInt(request.getParameter("value"));
                products = CRUD_product.getPod(value);
                break;
            case "price":
                int value1 = Integer.parseInt(request.getParameter("value1"));
                int value2 = Integer.parseInt(request.getParameter("value2"));
                products = CRUD_product.getPrice(value1, value2);
                break;


        }
        request.setAttribute("product", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameProduct = request.getParameter("nameProduct");
        request.setAttribute("product", CRUD_product.getNameProduct(nameProduct));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUser.jsp");
        requestDispatcher.forward(request, response);
    }
}
