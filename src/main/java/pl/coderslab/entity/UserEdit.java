package pl.coderslab.entity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = new User(userName, email, password);
        user.setId(id);
        try {
            userDao.update(user);
        } catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/user/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        try {
            User userReaded = userDao.read(id);
            request.setAttribute("user", userReaded);
        } catch (SQLException e){
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }
}
