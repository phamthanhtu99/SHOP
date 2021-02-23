package Controller.web;

import Command.binhluanCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.sanphamCommon;
import common.webConstant;
import org.example.core.dto.binhluanDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.binhluanService;
import org.example.service.sanphamService;
import org.example.serviecimpl.binhluanServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/phukien-chitietsanpham.js","/ajax-binhluan.html"})
public class chitietsanpham extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        sanphamCommand Command = FormUtils.populate(Command.sanphamCommand.class, req);
        req.setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(Command.getPojo().getId()));
        sanphamDTO dto = new sanphamDTO();
        dto.setId(Command.getPojo().getId());
        if (Command.getUrlType().equals(webConstant.chitietsanpham)) {
            req.getRequestDispatcher("views/phukien/chitietsanpham.jsp").forward(req, resp);
        }else if (Command.getUrlType().equals("hienthibinhluan")){
            req.setAttribute(webConstant.chitietbinhluan, sanphamCommon.chitietbinhluansanpham(dto).getBinhluanDTOS());
            req.getRequestDispatcher("views/phukien/edit/binhluan.jsp").forward(req, resp);
        }


    }


}
