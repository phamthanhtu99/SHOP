package Controller.web;

import Command.binhluanCommand;
import Utils.FormUtils;
import common.binhluanCommon;
import common.sanphamCommon;
import common.webConstant;
import org.apache.commons.lang.StringUtils;
import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.binhluanDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.KhachHangService;
import org.example.service.binhluanService;
import org.example.service.sanphamService;
import org.example.serviecimpl.KhachHangServiceImpl;
import org.example.serviecimpl.binhluanServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/phukien-binhluan.html", "/ajax-comment.html"})
public class binhluanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        binhluanCommand command = FormUtils.populate(binhluanCommand.class, req);
        if (command.getUrlType() != null) {
            if (command.getUrlType().equals(webConstant.danhgia)) {
                req.getRequestDispatcher("views/phukien/binhluan/danhgiasanpham.jsp").forward(req, resp);
            }else if (command.getUrlType().equals("xoabl")){/* xóa binh luan*/
                sanphamDTO dto = new sanphamDTO();
                dto.setId(command.getIdsanpham());
                binhluanCommon.xoabl(command);
                req.setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(dto.getId()));
                req.setAttribute(webConstant.chitietbinhluan, sanphamCommon.chitietbinhluansanpham(dto).getBinhluanDTOS());
                req.getRequestDispatcher("views/phukien/edit/binhluan.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        binhluanCommand command = FormUtils.populate(binhluanCommand.class, req);
        sanphamService sanphamService = new sanphamServiceImpl();
        KhachHangService khachHangService = new KhachHangServiceImpl();
        binhluanService binhluanService = new binhluanServiceImpl();
        if (StringUtils.isNotBlank(command.getIdsanpham()) && command.getIdkhachhang() != 0) {   /*bình luận sản phẩm*/
            binhluanDTO dto = command.getPojo();
            sanphamDTO dto1 = new sanphamDTO();
            dto1 = sanphamService.timtheosanpham(command.getIdsanpham());
            /*  ------------------------*/
            KhachHangDTO dto2 = new KhachHangDTO();
            dto2.setId(command.getIdkhachhang());
            dto2 = khachHangService.timtheoid(dto2);
            /*  ---------------------------*/
            dto.setKhachHangEntity(dto2);
            dto.setSanphamEntity(dto1);
            binhluanService.BINHLUAN_DTO(dto);
            req.setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(dto1.getId()));
            req.setAttribute(webConstant.chitietbinhluan, sanphamCommon.chitietbinhluansanpham(dto1).getBinhluanDTOS());
            req.getRequestDispatcher("views/phukien/edit/binhluan.jsp").forward(req, resp);
        }

    }

}
