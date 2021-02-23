package Controller.Admin.nhanvien;

import Command.chitietphieunhaoCommand;
import Command.phieunhapCommand;
import Utils.FormUtils;
import common.chitietphieunhapCommond;
import common.phieunhapCommond;
import common.webConstant;
import org.example.core.dto.orderdto;
import org.example.core.dto.sanphamDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

@WebServlet(urlPatterns = {"/admin-thanhtoanphieunhap.html", "/ajax-thanhtoanphieunhap.html","/report-phieunhap.html"})
public class thanhtoannhapCotroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        phieunhapCommand phieunhapCommand = FormUtils.populate(phieunhapCommand.class, req);
            if (phieunhapCommand.getUrlType() != null) {
                if (phieunhapCommand.getUrlType().equals(webConstant.thongtinphieunhap)) {
                    req.setAttribute(webConstant.chitietphieunhap, chitietphieunhapCommond.chitietphieunhapthieumaphieunhap(phieunhapCommand));
                    req.getRequestDispatcher("/views/admin/sanpham/chitietphieunhap.jsp").forward(req, resp);
                } else if (phieunhapCommand.getUrlType().equals("inhoadon")) {
                    req.setAttribute(webConstant.item, chitietphieunhapCommond.phieunhap(phieunhapCommand));
                    req.setAttribute(webConstant.chitietphieunhap, chitietphieunhapCommond.chitietphieunhapthieumaphieunhap(phieunhapCommand));
                    req.getRequestDispatcher("/views/admin/report/rpphieunhap.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute(webConstant.listItem, phieunhapCommond.viewsphieunhap(phieunhapCommand));
                req.getRequestDispatcher("/views/admin/thongtinnhapxuat.jsp").forward(req, resp);
            }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        orderdto order = new orderdto();
        TreeMap<sanphamDTO, Integer> list = new TreeMap<sanphamDTO, Integer>();
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        phieunhapCommand phieunhapCommand = FormUtils.populate(phieunhapCommand.class, req);
        chitietphieunhaoCommand chitietphieunhaoCommand = new chitietphieunhaoCommand();
        if (phieunhapCommand.getUrlType()!=null){
            if (phieunhapCommand.getUrlType().equals("capnhapsoluong")){

            }
        }else {
            Date date = new Date();
            String mdhd = "" + date.getTime();
            phieunhapCommand.setId(mdhd);
            phieunhapCommond.save(phieunhapCommand);
            chitietphieunhaoCommand.setOrderdtos((List<orderdto>) session.getAttribute(webConstant.addspphieunhap));
            chitietphieunhapCommond.savectnhap(chitietphieunhaoCommand.getOrderdtos(), mdhd);
            resp.sendRedirect("/admin-thanhtoanphieunhap.html");
        }



    }
}
