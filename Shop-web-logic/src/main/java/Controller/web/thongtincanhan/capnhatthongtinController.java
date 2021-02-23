package Controller.web.thongtincanhan;

import Command.KhachHangCommand;
import Utils.FormUtils;
import common.khachhangCommon;
import common.webConstant;
import org.example.core.dto.KhachHangDTO;
import org.example.persistence.data.KhachHangEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/phukien-capnhatttcn.html","/ajax-capnhatttcn.html"})
public class capnhatthongtinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
             req.setAttribute(webConstant.item, khachhangCommon.khachangid(command));
            req.getRequestDispatcher("views/phukien/edit/capnhatthongtincanhan.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
        if (command.getUrlType().equals("capnhat")){
            if (command.getPassword1().equals(command.getPojo().getPassWord())){
                khachhangCommon.update(command);
                req.setAttribute(webConstant.MESSAGE_RESPONSE,"Thành Công");
                req.setAttribute(webConstant.ALERT,"success");
                req.setAttribute(webConstant.item, khachhangCommon.khachangid(command));
            }else {
                req.setAttribute(webConstant.item, khachhangCommon.khachangid(command));
                req.setAttribute(webConstant.ALERT,"danger");
                req.setAttribute(webConstant.MESSAGE_RESPONSE,"mật khẩu không trùng khớp");
            }
        }
        req.getRequestDispatcher("views/phukien/edit/capnhatthongtincanhan.jsp").forward(req,resp);
    }
}
