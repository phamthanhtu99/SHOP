package Controller.Admin.nhanvien;


import Command.nhanvienquanlydonhangCommand;
import Command.thongkeCommon;
import Utils.FormUtils;
import com.google.gson.Gson;
import common.nhanvienquanlydonhang;
import common.phieunhapCommond;
import common.webConstant;
import org.example.core.dto.sanphamDTO;
import org.example.service.hoadonService;
import org.example.serviecimpl.hoadomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-danhthuch.html", "/ajax-danhthuch.html"})
public class danhthuController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand command = FormUtils.populate(nhanvienquanlydonhangCommand.class, req);
        Gson gson = new Gson();
        String dataPoints = gson.toJson(thongkeCommon.danhthutheothang());  /*danh thu theo tháng*/
            Object[] objects = nhanvienquanlydonhang.thongkesolieu1(command);  /*sô tiền đẫ mua và đã hủy*/
            Object[] objecj = phieunhapCommond.stnhap(command);   /*sô tiền nhâp*/
            req.setAttribute("stnhap",objecj[0]);
            req.setAttribute("damua", objects[0]);
            req.setAttribute("dahuy", objects[1]);
            req.setAttribute("demon", dataPoints);
            req.getRequestDispatcher("/views/admin/danhthu.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienquanlydonhangCommand command = FormUtils.populate(nhanvienquanlydonhangCommand.class, req);
        Object[] objects = nhanvienquanlydonhang.thongkesolieu1(command);  /*tìm kiếm theo tháng*/
        req.setAttribute("damua", objects[0]);
        req.setAttribute("dahuy", objects[1]);
    }
}
