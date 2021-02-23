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
import java.io.OutputStream;

@WebServlet(urlPatterns = {"/admin-quanlidonhang.html", "/ajax-quanlidonhang.html", "/report-hoadon.html"})
public class quanlydonhangCotroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hoadonCommand hoadonCommand = FormUtils.populate(hoadonCommand.class, req);
            if (hoadonCommand.getUrlType() != null) {
                if (hoadonCommand.getUrlType().equals("chitiethoadon")) {
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadonthephoadon(hoadonCommand));
                    req.getRequestDispatcher("/views/admin/sanpham/chitiethoadon.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("nhandonhang")) {
                    hoadonCommand.setIdnhanvien((Integer) req.getSession().getAttribute(webConstant.idnhanvien));
                    hoadonCommond.capnhathoadon(hoadonCommand);
                    req.setAttribute(webConstant.listItem, hoadonCommond.viewshoadonchuaxacnhan());
                    req.getRequestDispatcher("/views/admin/quanlydonhang.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("huydonhang")) {
                    hoadonCommand.setIdnhanvien((Integer) req.getSession().getAttribute(webConstant.idnhanvien));
                    hoadonCommond.capnhathoadon(hoadonCommand);
                    req.setAttribute(webConstant.listItem, hoadonCommond.viewshoadonchuaxacnhan());
                    req.getRequestDispatcher("/views/admin/quanlydonhang.jsp").forward(req, resp);
                } else if (hoadonCommand.getUrlType().equals("inhoadon")) {
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadonthephoadon(hoadonCommand));
                    req.getRequestDispatcher("/views/admin/report/rpchitiethoadon.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute(webConstant.listItem, hoadonCommond.viewshoadonchuaxacnhan());
                req.getRequestDispatcher("/views/admin/quanlydonhang.jsp").forward(req, resp);
            }
        }

}
