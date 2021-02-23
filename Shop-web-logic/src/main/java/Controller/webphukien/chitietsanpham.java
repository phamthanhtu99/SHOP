package Controller.webphukien;

import Command.sanphamCommand;
import Utils.FormUtils;
import common.sanphamCommon;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/web-xe-chitiet.html")
public class chitietsanpham extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanphamCommand command = FormUtils.populate(sanphamCommand.class,req);
        req.setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(command.getPojo().getId()));
        req.getRequestDispatcher("views/web/chitietxe.jsp").forward(req,resp);
    }
}
