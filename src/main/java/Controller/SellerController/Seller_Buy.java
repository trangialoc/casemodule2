package Controller.SellerController;

import Models.Cart.Cart;
import Models.Product.Product;
import Models.User.User;
import Service.ProductService.ProductService;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Seller_Buy", value = "/Seller_Buy")
public class Seller_Buy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        Cart cart = CRUD_cart.getCart(user);
        int amount = Integer.parseInt(request.getParameter("amount"));
        String nameProduct = request.getParameter("nameProduct");
        Product product = ProductService.returnProduct(nameProduct);
        int idproduct = product.getIdproduct();
        CRUD_cart.newdeatail(idproduct, cart.getIdcart(), amount);
        request.setAttribute("amountMax", product.getAmount());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SellerProduct_Servlet");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
