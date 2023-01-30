package Controller.SellerController;

import Models.Bill.Bill;
import Models.Cart.Cart;
import Models.Product.Product;
import Models.User.User;
import Service.ProductService.ProductService;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "SellerCart_Edit", value = "/SellerCart_Edit")
public class SellerCart_Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        Cart cart = CRUD_cart.getCart(user);
        int amount = Integer.parseInt(request.getParameter("amount"));
        String nameProduct = request.getParameter("nameProduct");
        Product product = ProductService.returnProduct(nameProduct);
        int idproduct = product.getIdproduct();
        String action = request.getParameter("action");
        String url = "";
        switch (action){
            case "Edit":
                CRUD_cart.deleteDeatail(idproduct);
                CRUD_cart.newdeatail(idproduct, cart.getIdcart(), amount);
                url = "/Seller_Cart";
                break;
            case "Delete":
                CRUD_cart.deleteDeatail(idproduct);
                url = "/Seller_Cart";
                break;
            case "ThanhToan":
                String userName = user.getUserName();
                int idCart = cart.getIdcart();
                LocalDateTime date = LocalDateTime.now();
                int totalBill = CRUD_cart.TotalBill(userName, idCart);
                Bill bill = new Bill(userName, idCart, date, totalBill);
                CRUD_cart.newBill(bill);
                CRUD_cart.UpdateStatus(userName, idCart);
                CRUD_cart.newCart(userName);
                url = "/Seller_Cart";
                break;
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
