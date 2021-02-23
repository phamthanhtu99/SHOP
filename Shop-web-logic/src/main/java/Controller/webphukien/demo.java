package Controller.webphukien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.restfb.logging.RestFBLogger;
import com.restfb.types.User;
@WebServlet("/ajax-demo.html")
public class demo  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/views/web/demo.jsp").forward(req,resp);
    }
}
