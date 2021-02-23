package Controller.Admin.nhanvien;

import Command.nhanvienquanlydonhangCommand;
import Utils.FormUtils;
import common.nhanvienquanlydonhang;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-quanlythongtindonhang.html")
public class quanlythongtincacdonhang extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand command = new nhanvienquanlydonhangCommand();
            req.setAttribute(webConstant.listItem, nhanvienquanlydonhang.viewsnhanvien(command));
            req.getRequestDispatcher("/views/admin/danhsachdonhang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand command = FormUtils.populate(nhanvienquanlydonhangCommand.class,req);
        req.setAttribute(webConstant.listItem, nhanvienquanlydonhang.viewsnhanvien(command));
        req.getRequestDispatcher("/views/admin/danhsachdonhang.jsp").forward(req,resp);
    }
}
