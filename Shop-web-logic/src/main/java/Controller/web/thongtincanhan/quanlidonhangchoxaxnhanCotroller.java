package Controller.web.thongtincanhan;

import Command.hoadonCommand;
import Utils.FormUtils;
import common.chitiethoadonCommond;
import common.hoadonCommond;
import common.sanphamCommon;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/ajax-quanlydhchoxacnhan.html", "/ajax-quanlylichsuvadahuy.html"})
public class quanlidonhangchoxaxnhanCotroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hoadonCommand hoadonCommand = FormUtils.populate(Command.hoadonCommand.class, req);

        if (hoadonCommand.getUrlType() != null) {
            if (hoadonCommand.getUrlType().equals("hdchuaxacnhan")) {
                req.setAttribute(webConstant.listItem, hoadonCommond.hdchuaxacnhan(hoadonCommand));
                req.getRequestDispatcher("views/phukien/edit/hdchuxacnhan.jsp").forward(req, resp);
            } else if (hoadonCommand.getUrlType().equals("chitiethoadon")) {
                req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadon(hoadonCommand));
                req.getRequestDispatcher("views/phukien/edit/chitiethoadon.jsp").forward(req, resp);
            } else if (hoadonCommand.getUrlType().equals("huydonhang")) {
                hoadonCommond.updatehoadon(hoadonCommand);
                req.setAttribute(webConstant.listItem, hoadonCommond.hdchuaxacnhan(hoadonCommand));
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "Hủy Thành Công");
                req.setAttribute(webConstant.ALERT, "success");
                req.getRequestDispatcher("views/phukien/edit/hdchuxacnhan.jsp").forward(req, resp);
            } else if (hoadonCommand.getUrlType().equals("huyvalichsu")) {
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "Danh sách Đơn Hàng Đã Hủy");
                req.setAttribute(webConstant.listItem, hoadonCommond.lichsuhoadonvadahuy(hoadonCommand));
                req.getRequestDispatcher("views/phukien/edit/hddahuy.jsp").forward(req, resp);
            } else if (hoadonCommand.getUrlType().equals("lichsumuahang")) {
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "Danh sách Đơn Hàng Đã Giao");
                 req.setAttribute(webConstant.listItem, hoadonCommond.lichsuhoadonvadahuy(hoadonCommand));
                req.getRequestDispatcher("views/phukien/edit/hddahuy.jsp").forward(req, resp);
            } else if (hoadonCommand.getUrlType().equals("dangcho")) {
                req.setAttribute(webConstant.listItem, hoadonCommond.lichsuhoadonvadahuy(hoadonCommand));
                req.getRequestDispatcher("views/phukien/edit/dhchogiao.jsp").forward(req, resp);
            }
        }
    }
}
