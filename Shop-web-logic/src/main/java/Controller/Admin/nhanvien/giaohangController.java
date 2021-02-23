package Controller.Admin.nhanvien;

import Command.hoadonCommand;
import Utils.FormUtils;
import common.chitiethoadonCommond;
import common.hoadonCommond;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-giaohang.html", "/ajax-giaphang.html"})
public class giaohangController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hoadonCommand hoadonCommand = FormUtils.populate(Command.hoadonCommand.class, req);
            if (hoadonCommand.getUrlType() != null) {
                if (hoadonCommand.getUrlType().equals("chitiethoadon")) {   /* hiện thị chi tiết hóa đơn giao hàng*/
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadontgiaohang(hoadonCommand));
                    req.getRequestDispatcher("/views/admin/sanpham/chitiethoadongiaohang.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("danhan")) {   /*xác nhận đã giao hàng*/
                    hoadonCommond.capnhathoadon(hoadonCommand);
                    req.setAttribute(webConstant.listItem, hoadonCommond.giaohang());
                    req.getRequestDispatcher("/views/admin/giaohang.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("dahuy")) {       /* đơn hàng huy*/
                    hoadonCommond.capnhathoadon(hoadonCommand);
                    req.setAttribute(webConstant.listItem, hoadonCommond.giaohang());
                    req.getRequestDispatcher("/views/admin/giaohang.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("report")) {
                    req.setAttribute(webConstant.listItem, hoadonCommond.giaohang());
                    req.getRequestDispatcher("/views/admin/report/report.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute(webConstant.listItem, hoadonCommond.giaohang());
                req.getRequestDispatcher("/views/admin/giaohang.jsp").forward(req, resp);
            }
    }
}
