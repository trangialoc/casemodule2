package Controller.AdminController;

import Models.Bill.Bill;
import Models.Cart.Cart;
import Models.Product.Product;
import Models.User.User;
import Service.Cart.Cart_Service;
import Service.ProductService.ProductService;
import dao.Cart.CRUD_cart;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AdminEdit_Product", value = "/AdminEdit_Product")
public class AdminEdit_Product extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String img = request.getParameter("img");
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int productType = Integer.parseInt(request.getParameter("browser"));
        Product product = new Product(idProduct, nameProduct, price, img, amount, productType);
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "Edit":
                CRUD_product.UpdateProduct(product);
                url = "/AdminWed_Servlet";
                break;
            case "Delete":
                CRUD_cart.deleteDeatail(idProduct);
                CRUD_product.deleteProduct(product);
                url = "/AdminWed_Servlet";
                break;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
