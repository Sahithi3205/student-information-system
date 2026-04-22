package com.studentinfo.servlet;

import com.studentinfo.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserDAO dao = new UserDAO();

            if (dao.validateUser(username, password, getServletContext())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("dashboard/index.html");
            } else {
                response.getWriter().println("Invalid login");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
