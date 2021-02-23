package Controller.webphukien;

import Command.chitietphieunhaoCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.hienthisanphamCommon;
import common.sanphamCommon;
import common.webConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/web-xemay.html", "/ajax-xemmay.html"})
public class home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chitietphieunhaoCommand command = FormUtils.populate(chitietphieunhaoCommand.class, req);
//        req.setAttribute(webConstant.listItem, sanphamCommon.xe(command));
        req.setAttribute(webConstant.listItem, hienthisanphamCommon.xe(command));
        req.getRequestDispatcher("views/web/index.jsp").forward(req, resp);
    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        sanphamCommand command = FormUtils.populate(sanphamCommand.class, req);
//        if (command.getUrlType() != null) {
//            if (command.getUrlType().equals("timkiemtheoid")) {/* tìm kiêm theo loại sản phẩm*/
//                req.setAttribute(webConstant.listItem, sanphamCommon.xe(command));
//            }else if (command.getUrlType().equals("xemthemsanpham")){ /*xem thêm sản phẩm*/
//                req.setAttribute(webConstant.listItem, sanphamCommon.xe(command));
//            }
//        }else {
//            req.setAttribute(webConstant.listItem, sanphamCommon.xe(command));
//        }
//        req.getRequestDispatcher("views/web/index.jsp").forward(req, resp);
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chitietphieunhaoCommand command = FormUtils.populate(chitietphieunhaoCommand.class, req);
        if (command.getUrlType() != null) {
            if (command.getUrlType().equals("timkiemtheoid")) {/* tìm kiêm theo loại sản phẩm*/
                req.setAttribute(webConstant.listItem, hienthisanphamCommon.xe(command));
            } else if (command.getUrlType().equals("xemthemsanpham")) { /*xem thêm sản phẩm*/
                req.setAttribute(webConstant.listItem, hienthisanphamCommon.xe(command));
            }
        } else {
            req.setAttribute(webConstant.listItem, hienthisanphamCommon.xe(command));
        }
        req.getRequestDispatcher("views/web/index.jsp").forward(req, resp);
    }
}
