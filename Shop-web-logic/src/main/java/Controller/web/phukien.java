package Controller.web;

import Command.loaisanphamCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.sanphamCommon;
import common.webConstant;
import org.example.core.dto.sanphamDTO;
import org.example.service.loaisanphamService;
import org.example.service.sanphamService;
import org.example.serviecimpl.loaisanphamServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/phukien-home.css", "/ajax-views.html"})
public class phukien extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int limit = 0;
        /* ----------------------------------------*/
        sanphamCommon sanphamCommon = new sanphamCommon();
        loaisanphamService service = new loaisanphamServiceImpl();
        loaisanphamCommand command = new loaisanphamCommand();
        command.setLoaisanphamDTOList(service.Findall());
         /*   req.setAttribute(webConstant.loaisanpham, command);*/
        /*  --------------------------------------------------*/
        sanphamCommand command1 = FormUtils.populate(sanphamCommand.class, req);
        /*        command1.setLimit(4);*/
        Object[] objects = null;
        sanphamService service1 = new sanphamServiceImpl();
        /*  -----------------------hien thi them san pham--------------------------------*/
        if (command1.getUrlType() != null) { /*kiểm tra giá có tồn tại*/
            if (command1.getUrlType().equals(webConstant.hienthithemsampham)) {    /*xử lý hiện sản phẩm*/
                objects = service1.FindByproprety1(0, command1.getLimit(), "", command1.getLoaisanpham());
            }
        } else if (command1.getSeach() != null) {  /*xử lý tìm kiếm*/
            objects = service1.FindByproprety1(0, 4, command1.getSeach(), command1.getLoaisanpham());
        } else {
            objects = service1.FindByproprety1(0, 4, "", command1.getLoaisanpham());
        }

        command1.setSanphamDTOList((List<sanphamDTO>) objects[1]);

     /*   command1.setTotalItems(Integer.parseInt(objects[0].toString()));*/
        req.setAttribute(webConstant.sanpham, command1);
        req.setAttribute(webConstant.listItem, sanphamCommon.sanphamnoibac());
        req.getRequestDispatcher("views/phukien/home.jsp").forward(req, resp);
    }
}
