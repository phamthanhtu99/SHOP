package Controller.Admin.nhanvien;

import Command.hoadonCommand;
import Command.nhanvienquanlydonhangCommand;
import Command.phieunhapCommand;
import Utils.FormUtils;
import common.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-danhthu.html","/ajax-danhthu.html"})
public class quanlyhoadonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand Command = FormUtils.populate(Command.nhanvienquanlydonhangCommand.class,req);
            if (Command.getUrlType() != null) {
                if (Command.getUrlType().equals("viewsp")) {
                    req.setAttribute(webConstant.listItem, nhanvienquanlydonhang.danhthu(Command));
                    req.getRequestDispatcher("/views/admin/sanpham/danhthudaban.jsp").forward(req, resp);
                } else if (Command.getUrlType().equals("timkiem")) {
                    req.setAttribute(webConstant.listItem, nhanvienquanlydonhang.quanlysanpham(Command));
                    req.getRequestDispatcher("/views/admin/sanpham/danhthudaban.jsp").forward(req, resp);
                }else if(Command.getUrlType().equals("chitietdonhang")){
                    req.setAttribute(webConstant.chitietphieunhap, chitietphieunhapCommond.chitietphieunhapthieumaphieunhap(xuli(Command)));
                    req.getRequestDispatcher("/views/admin/sanpham/chitiet.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
                req.setAttribute(webConstant.nhanvien, nhavienCommon.viewnhanvien());
                req.setAttribute(webConstant.danhsachhoadon, hoadonCommond.viewsall());
                req.getRequestDispatcher("/views/admin/quanlydanhthu.jsp").forward(req, resp);
        }
    }

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand hoadonCommand = FormUtils.populate(Command.nhanvienquanlydonhangCommand.class,req);
        req.setAttribute(webConstant.listItem, nhanvienquanlydonhang.danhthu(hoadonCommand));
        req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
        req.setAttribute(webConstant.nhanvien, nhavienCommon.viewnhanvien());
        req.setAttribute(webConstant.danhsachhoadon, hoadonCommond.viewsall());
        req.getRequestDispatcher("/views/admin/quanlydanhthu.jsp").forward(req,resp);
    }*/
    private phieunhapCommand xuli(nhanvienquanlydonhangCommand commond){
                 phieunhapCommand command = new phieunhapCommand();
                command.getPojo().setId(commond.getHoadon());
                return command;
    }
}
