package Filter;

import Models.User.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/Seller_Buy","/Seller_Cart", "/Seller_Iormation", "/Seller_showBill","/SellerAdd_Product", "/SellerCart_Edit","/SellerProduct_Servlet", "/WedSeller/WebSeller.jsp", "/WedSeller/WebSellerCart.jsp", "/WedSeller/WebSellerHistory.jsp", "/WedSeller/WebSellerInformation.jsp" })
public class SellerFilter  extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            res.sendRedirect("/User_SigninServlet");
        } else if (user.getRole() == 3) {
            chain.doFilter(req,res);
        } else {
            PrintWriter printWriter = res.getWriter();
            printWriter.println("<h1>Quyền User Không có quyền truy cập</h1>");
        }
    }
}
