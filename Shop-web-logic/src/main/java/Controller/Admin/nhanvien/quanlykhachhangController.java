package Controller.Admin.nhanvien;

import Command.KhachHangCommand;
import Utils.FormUtils;
import common.khachhangCommon;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-quanlykhachhang")
public class quanlykhachhangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KhachHangCommand command = FormUtils.populate(KhachHangCommand.class, req);
            req.setAttribute(webConstant.listItem, khachhangCommon.viewkhachhang(command));
            req.getRequestDispatcher("/views/admin/quanlykhachhang.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
        req.setAttribute(webConstant.listItem,khachhangCommon.viewkhachhang(command));
        req.getRequestDispatcher("/views/admin/quanlykhachhang.jsp").forward(req,resp);
    }
}
