package Controller.web;

import Command.KhachHangCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.webConstant;
import org.apache.commons.lang.StringUtils;
import org.example.core.dto.KhachHangDTO;
import org.example.service.KhachHangService;
import org.example.serviecimpl.KhachHangServiceImpl;
import org.example.utisl.khachHangBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.WebConnection;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login-user.html","/ajax-dk.html"})
public class LoginUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            KhachHangCommand command = FormUtils.populate(KhachHangCommand.class,req);
            if (command.getUrlType()!=null){
                if (command.getUrlType().equals(webConstant.login)){
                    req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
                }else if (command.getUrlType().equals(webConstant.logout)){
                    req.getRequestDispatcher("/views/login/dangky.jsp").forward(req, resp);
                }else if (command.getUrlType().equals(webConstant.dangxuat)){
                    req.getSession().removeAttribute(webConstant.Idkhachhang);
                    req.getSession().removeAttribute(webConstant.name);
                    resp.sendRedirect("/phukien-home.css");
                }
            }else {
                req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        KhachHangCommand command = FormUtils.populate(KhachHangCommand.class, req);
        KhachHangService service = new KhachHangServiceImpl();
        KhachHangDTO dto = command.getPojo();
        if (webConstant.login.equals(command.getUrlType())) {
            try {
                if (service.Kiemtranguoidung(dto) != null) {
                    if (service.Kiemtranguoidung(dto).getEmail() != null) {
                        req.getSession().setAttribute(webConstant.name, service.Kiemtranguoidung(dto).getTenKhachhang());
                        req.getSession().setAttribute(webConstant.Idkhachhang, service.Kiemtranguoidung(dto).getId());
                        req.getSession().setAttribute(webConstant.ttkhh, service.Kiemtranguoidung(dto).getId());
                        resp.sendRedirect("/phukien-home.css");
                    }
                }
            } catch (NullPointerException e) {
                req.setAttribute(webConstant.ALERT, webConstant.Type_ERROR);
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "Đăng nhập Thất bại");
                req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
            }
        }else if(webConstant.dangky.equals(command.getUrlType())){
            if ( StringUtils.isNotBlank(command.getPojo().getEmail()) && StringUtils.isNotBlank(command.getPojo().getSdt()) && StringUtils.isNotBlank(command.getPojo().getTenKhachhang()) ){
                if(service.Checkemail(dto)==false){
                        service.save(dto);
                        req.getSession().setAttribute(webConstant.name, service.Kiemtranguoidung(dto).getTenKhachhang());
                        resp.sendRedirect("/phukien-home.css");
                }else {
                    req.setAttribute(webConstant.MESSAGE_RESPONSE, "Email tồn Tại");
                    resp.sendRedirect("/login-user.html?urlType=logout");
                }
            }else {
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "Vui Lòng Nhập Đày Đủ Thông Tin");
               resp.sendRedirect("/login-user.html?urlType=logout");
            }

        }else {
            req.setAttribute(webConstant.MESSAGE_RESPONSE, "Sai");
            req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
        }
    }
}
