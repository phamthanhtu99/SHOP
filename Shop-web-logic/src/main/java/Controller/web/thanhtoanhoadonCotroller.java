package Controller.web;

import Command.hoadonCommand;
import Utils.FormUtils;
import common.chitiethoadonCommond;
import common.hoadonCommond;
import common.sanphamCommon;
import common.webConstant;
import org.example.core.dto.hoadonDTO;
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
import java.util.TreeMap;

@WebServlet(urlPatterns = {"/phukien-thanhtoanhoadon.html", "/ajax-thanhtoanhoadon.html"})
public class thanhtoanhoadonCotroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hoadonCommand hoadonCommand = FormUtils.populate(Command.hoadonCommand.class, req);
        Integer id = (Integer) req.getSession().getAttribute(webConstant.Idkhachhang);
        req.setAttribute(webConstant.listItem, sanphamCommon.sanphamnoibac());
        if (id == null) {
            resp.sendRedirect("/login-user.html");
        } else {
           /* hoadonCommand.setTenkhachhang(id);
            req.setAttribute(webConstant.danhsachhoadon, hoadonCommond.viewshoadon(hoadonCommand));
            if (hoadonCommand.getUrlType() != null) {
                if (hoadonCommand.getUrlType().equals("chitiethoadon")) {
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadonCommandviews(hoadonCommand));
                    req.getRequestDispatcher("/views/phukien/edit/chitiethoadon.jsp").forward(req, resp);
                }
                else if(hoadonCommand.getUrlType().equals("huydonhang")){
                    hoadonCommond.updatehoadon(hoadonCommand);
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadonCommandviews(hoadonCommand));
                    resp.sendRedirect("/phukien-thanhtoanhoadon.html");
                }
                else if(hoadonCommand.getUrlType().equals("datlai")){
                    hoadonCommond.updatehoadondatlai(hoadonCommand);
                    req.setAttribute(webConstant.chitiethoadon, chitiethoadonCommond.chitiethoadonCommandviews(hoadonCommand));
                    resp.sendRedirect("/phukien-thanhtoanhoadon.html");
                }
            } else {
                req.getRequestDispatcher("/views/phukien/thongtinthanhtoan.jsp").forward(req, resp);
            }*/
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        hoadonCommand hoadonCommand = FormUtils.populate(Command.hoadonCommand.class, req);
        hoadonDTO hoadonDTO = new hoadonDTO();
        chitiethoadonCommond chitiethoadonCommond = new chitiethoadonCommond();
        Date date = new Date();
        String mdhd = "" + date.getTime();
        hoadonCommand.setIdhoadon(mdhd);
        /*    ---save hóa đơn--*/
        hoadonDTO = hoadonCommond.luuhoadon(hoadonCommand);
        orderdto order = new orderdto();
        order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
        /*  save chitiethoado*/
        chitiethoadonCommond.luuchitiethoadon(order.list, hoadonDTO);
        resp.sendRedirect("/phukien-canhan.html");
    }
}
