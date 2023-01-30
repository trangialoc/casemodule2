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

@WebFilter(urlPatterns = {"/AdminAdd_Product","/AdminBill_Servlet", "/AdminEdit_Product", "/AdminQLU_Servlet","/AdminWed_Servlet", "/DetailBillAdminServlet", "/WedAdmin/WebAdmin.jsp", "/WedAdmin/WebAdminHistory.jsp", "/WedAdmin/WebAdminQLU.jsp" })
public class AdminFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if (user == null) {
            res.sendRedirect("/User_SigninServlet");
        } else if (user.getRole() == 1) {
            chain.doFilter(req,res);
        } else {
            PrintWriter printWriter = res.getWriter();
            printWriter.println("<h1>Quyền User Không có quyền truy cập</h1>");
        }
    }
}
