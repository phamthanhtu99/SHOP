package Controller.web;

import Command.giohangCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.phuongthucthanhtoanCommond;
import common.sanphamCommon;
import common.webConstant;
import org.example.core.dto.orderdto;
import org.example.core.dto.sanphamDTO;
import org.example.service.sanphamService;
import org.example.serviecimpl.sanphamServiceImpl;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = {"/phukien-order.html", "/ajax-oder-tangsoluong.html"})
public class order extends HttpServlet {
    sanphamService service = new sanphamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        orderdto order = new orderdto();
        req.setAttribute(webConstant.listItem, sanphamCommon.sanphamnoibac());
        giohangCommand command = FormUtils.populate(giohangCommand.class, req);
        TreeMap<sanphamDTO, Integer> list = new TreeMap<sanphamDTO, Integer>();
        if (req.getSession().getAttribute(webConstant.name) == null) {
            resp.sendRedirect("/login-user.html");
        } else {
            if (command.getQuantity() == 0) {
                if (session.getAttribute(webConstant.giohang)!=null){
                    order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
                    list = order.list;
                }
                session.setAttribute(webConstant.giohang, list);
            }
            if (command.getPojo().getId() != null) {
                if (command.getCommand().equals(webConstant.themvaogiohang)) {
                    if (session.getAttribute(webConstant.giohang) == null) {
                        order.insert(service.timtheosanpham(command.getPojo().getId()), command.getQuantity());
                        list = order.list;
                        req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
                        req.getSession().setAttribute(webConstant.tongtien, sanphamCommon.tongtien(list));
                        req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                        session.setAttribute(webConstant.giohang, list);

                    } else {
                        order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
                        order.insert(service.timtheosanpham(command.getPojo().getId()), command.getQuantity());
                        list = order.list;
                        req.setAttribute(webConstant.tongtien, sanphamCommon.tongtien(list));
                        req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
                        req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                        session.setAttribute(webConstant.giohang, list);
                    }

                } else if (command.getCommand().equals(webConstant.tangsoluonghang)) {
                    order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
                    order.insert(service.timtheosanpham(command.getPojo().getId()), command.getQuantity());
                    list = order.list;
                    req.setAttribute(webConstant.tongtien, sanphamCommon.tongtien(list));
                    req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
                    req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                    session.setAttribute(webConstant.giohang, list);
                } else if (command.getCommand().equals(webConstant.giamsoluonghang)) {
                    order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
                    order.detele(service.timtheosanpham(command.getPojo().getId()), command.getQuantity());
                    req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                    list = order.list;
                    req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
                    req.setAttribute(webConstant.tongtien, sanphamCommon.tongtien(list));
                    req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                    session.setAttribute(webConstant.giohang, list);
                } else if (command.getCommand().equals(webConstant.xoasanphamtronggiohang)) {
                    order.setList((TreeMap<sanphamDTO, Integer>) session.getAttribute(webConstant.giohang));
                    order.deteleSP(service.timtheosanpham(command.getPojo().getId()));
                    list = order.list;
                    req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
                    req.setAttribute(webConstant.tongtien, sanphamCommon.tongtien(list));
                    req.getSession().setAttribute(webConstant.soluongsanphamtronggiohang, list.size());
                    session.setAttribute(webConstant.giohang, list);
                }

            }

            req.setAttribute(webConstant.phuongthucthanhtoan, phuongthucthanhtoanCommond.phuongthucthanhtoan());
            req.getRequestDispatcher("views/phukien/giohang.jsp").forward(req, resp);
        }
    }
}
