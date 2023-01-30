package Controller.UserController;

import Models.User.User;
import Service.UserService.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductSeverlet_Iormation", value = "/ProductSeverlet_Iormation")
public class ProductSeverlet_Iormation extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        request.setAttribute("User", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUserInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("Name");
        String UserName = request.getParameter("UserName");
        String PassWord = request.getParameter("PassWord");
        String Img = request.getParameter("img");
        User user1 =(User) session.getAttribute("User");
        User user = new User(name, UserName, PassWord, Img, user1.getRole());
        UserService.Edit(user);
        session.setAttribute("User", user);
        request.setAttribute("User", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedUser/WebUserInformation.jsp");
        requestDispatcher.forward(request, response);
    }
}
