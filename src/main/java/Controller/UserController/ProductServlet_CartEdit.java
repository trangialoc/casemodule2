package Controller.UserController;

import Models.Bill.Bill;
import Models.Cart.Cart;
import Models.Deatailcart.Deatailcart;
import Models.Product.Product;
import Models.User.User;
import Service.ProductService.ProductService;
import dao.Cart.CRUD_cart;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet_CartEdit", value = "/ProductServlet_CartEdit")
public class ProductServlet_CartEdit extends HttpServlet {
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
        switch (action) {
            case "Edit":
                CRUD_cart.deleteDeatail(idproduct);
                CRUD_cart.newdeatail(idproduct, cart.getIdcart(), amount);
                url = "/ProductServlet_Cart";
                break;
            case "Delete":
                CRUD_cart.deleteDeatail(idproduct);
                url = "/ProductServlet_Cart";
                break;
            case "ThanhToan":
                String userName = user.getUserName();
                int idCart = cart.getIdcart();
                LocalDateTime date = LocalDateTime.now();
                int totalBill = CRUD_cart.TotalBill(userName, idCart);

                List<Deatailcart> deatailcarts = CRUD_cart.showDeatail(cart);

                List<Product> products = new ArrayList<>();
                for (int i = 0; i < deatailcarts.size(); i++) {
                    products.add(CRUD_product.getProduct(deatailcarts.get(i).getIdproduct())) ;
                }

                for (int i = 0; i < deatailcarts.size(); i++) {
                    int amout_x = products.get(i).getAmount();
                    int amout_y = deatailcarts.get(i).getAmoutProduct();
                    int amout = amout_x  - amout_y ;
                    Product product1 = CRUD_product.getProduct(deatailcarts.get(i).getIdproduct());
                    CRUD_product.UpdateProduct_x(product1, amout);
                }

                Bill bill = new Bill(userName, idCart, date, totalBill);
                CRUD_cart.newBill(bill);

                // lấy giỏ hàng chi tiết



                CRUD_cart.UpdateStatus(userName, idCart);
                CRUD_cart.newCart(userName);
                url = "/ProductServlet_Cart";
                break;
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
