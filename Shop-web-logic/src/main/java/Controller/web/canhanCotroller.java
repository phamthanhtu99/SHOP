package Controller.web;

import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/phukien-canhan.html"})
public class canhanCotroller  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(webConstant.name) == null) {
            resp.sendRedirect("/login-user.html");
        }else {
            req.getRequestDispatcher("views/phukien/trangcanhan.jsp").forward(req, resp);
        }
    }
}
