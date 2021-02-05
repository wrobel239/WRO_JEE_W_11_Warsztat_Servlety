package pl.coderslab.entity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}
