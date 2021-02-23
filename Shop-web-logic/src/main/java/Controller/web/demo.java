package Controller.web;

import Command.KhachHangCommand;
import Utils.FormUtils;

import org.example.core.comon.CoreConten.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax-demo.js")
public class demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     /*   KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
        String code =req.getParameter("code");
        if (code==null){
            req.getRequestDispatcher("/views/web/demo.jsp").forward(req,resp);
        }else {
            String link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID, Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL, code);

        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
    }
}
