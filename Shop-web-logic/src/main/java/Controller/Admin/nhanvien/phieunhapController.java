package Controller.Admin.nhanvien;

import Command.chitietphieunhaoCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.*;
import org.example.core.dto.orderdto;
import org.example.core.dto.sanphamDTO;
import org.example.service.sanphamService;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = {"/admin-phieunhap.html", "/ajax-phieunhap.html"})
public class phieunhapController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanphamCommand sanphamCommand = FormUtils.populate(sanphamCommand.class, req);
        if (sanphamCommand.getUrlType() != null) {
            if (sanphamCommand.getUrlType().equals(webConstant.nhapsoluong)) {  /*hiện thị from phiếu nhập*/
                req.getSession().setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(sanphamCommand.getPojo().getId()));
                req.getRequestDispatcher("/views/admin/sanpham/phieunhap.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute(webConstant.nhasanxuat, nhasanxuatCommond.viewsnsx());
            req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
            req.getSession().removeAttribute(webConstant.addspphieunhap);
            req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chitietphieunhaoCommand chitietphieunhaoCommand = FormUtils.populate(chitietphieunhaoCommand.class, req);
        orderdto order = new orderdto();
        List<orderdto> orderdtos = new ArrayList<orderdto>();
        HttpSession session = req.getSession();
        TreeMap<sanphamDTO, Integer> list = new TreeMap<sanphamDTO, Integer>();
        sanphamDTO sanphamDTO = sanphamCommon.chitietsanpham(chitietphieunhaoCommand.getId());   /*lấy sản phẩm theo ID*/
        if (chitietphieunhaoCommand.getUrlType() != null) {
            req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
            req.setAttribute(webConstant.nhasanxuat, nhasanxuatCommond.viewsnsx());
            if (chitietphieunhaoCommand.getUrlType().equals(webConstant.themsanphamvaophieunhap)) {   /*kiểm tra nhiệm vụ*/
                if (session.getAttribute(webConstant.addspphieunhap) != null) {   /*kiểm tra session có tồn tại*/
                    chitietphieunhaoCommand.setOrderdtos((List<orderdto>) session.getAttribute(webConstant.addspphieunhap)); /*lấy giá trị từ session set vào list*/
                    for (orderdto orderdto : chitietphieunhaoCommand.getOrderdtos()) { /*lọc phần tử là add vào list<orderdto>*/
                        orderdtos.add(orderdto);
                    }
                }
                order.phieunhap(sanphamDTO, chitietphieunhaoCommand.getPojo().getSoluong()); /*xủ lý lưu vào order*/
                list = order.list;  /*gán giá list trong order.list cho treeMAP*/
                order.setList(list);  /*truyền dử liệu cho order.list*/
                order.setGiaotien(chitietphieunhaoCommand.getPojo().getGiatien()); /* nhận giá trị tiền */
                orderdtos.add(order); /*theo đối tượng order vào treemap*/
                chitietphieunhaoCommand.setOrderdtos(orderdtos); /*truyền dl mãng treeMao vào list order trong chitietphieunhaoCommand*/
                session.setAttribute(webConstant.addspphieunhap, chitietphieunhaoCommand.getOrderdtos()); /*lưu vào session*/
                req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
            } else if (chitietphieunhaoCommand.getUrlType().equals(webConstant.xoasp)) {
                chitietphieunhaoCommand.setOrderdtos((List<orderdto>) session.getAttribute(webConstant.addspphieunhap)); /*lấy session lưu vào chitietphieunhaoCommand*/
                for (orderdto orderdto : chitietphieunhaoCommand.getOrderdtos()) {
                        for (Map.Entry<sanphamDTO, Integer> entry :orderdto.getList().entrySet()) {
                        if (entry.getKey().getId().equals(sanphamDTO.getId())){
                            order = orderdto;
                        }
                    }
                }
                chitietphieunhaoCommand.getOrderdtos().remove(order);
                session.setAttribute(webConstant.addspphieunhap, chitietphieunhaoCommand.getOrderdtos());
                req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
            }
        }
    }
}















  /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanphamCommand sanphamCommand = FormUtils.populate(sanphamCommand.class, req);
            if (sanphamCommand.getUrlType() != null) {
                if (sanphamCommand.getUrlType().equals(webConstant.nhapsoluong)) {
                    req.getSession().setAttribute(webConstant.chitietsanpham, sanphamCommon.chitietsanpham(sanphamCommand.getPojo().getId()));
                    req.getRequestDispatcher("/views/admin/sanpham/phieunhap.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute(webConstant.nhasanxuat, nhasanxuatCommond.viewsnsx());
                req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
                req.getSession().removeAttribute(webConstant.addspphieunhap);
                req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chitietphieunhaoCommand chitietphieunhaoCommand = FormUtils.populate(chitietphieunhaoCommand.class,req);
        orderdto order = new orderdto();
        HttpSession session = req.getSession();
        TreeMap<sanphamDTO, Integer> list = new TreeMap<sanphamDTO, Integer>();
        sanphamDTO sanphamDTO = sanphamCommon.chitietsanpham(chitietphieunhaoCommand.getId());
        if (chitietphieunhaoCommand.getUrlType()!=null){
            req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
            req.setAttribute(webConstant.nhasanxuat, nhasanxuatCommond.viewsnsx());
            if(chitietphieunhaoCommand.getUrlType().equals(webConstant.themsanphamvaophieunhap)){

                if (session.getAttribute(webConstant.addspphieunhap)==null){
                    order.insert(sanphamDTO,chitietphieunhaoCommand.getPojo().getSoluong());
                    list= order.list;
                    req.setAttribute(webConstant.tongtien, phieunhapCommond.tongtien(list));
                    session.setAttribute(webConstant.addspphieunhap, list);
                    req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
                }else {
                    order.setList((TreeMap<org.example.core.dto.sanphamDTO, Integer>) session.getAttribute(webConstant.addspphieunhap));
                    order.insert(sanphamDTO,chitietphieunhaoCommand.getPojo().getSoluong());
                    list= order.list;
                    req.setAttribute(webConstant.tongtien, phieunhapCommond.tongtien(list));
                    session.setAttribute(webConstant.addspphieunhap, list);
                    req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
                }

            }else if (chitietphieunhaoCommand.getUrlType().equals(webConstant.xoasp)){
                order.setList((TreeMap<org.example.core.dto.sanphamDTO, Integer>) session.getAttribute(webConstant.addspphieunhap));
                order.deteleSP(sanphamDTO);
                list= order.list;
                req.setAttribute(webConstant.tongtien, phieunhapCommond.tongtien(list));
                session.setAttribute(webConstant.addspphieunhap, list);
                req.getRequestDispatcher("/views/admin/phieunhap.jsp").forward(req, resp);
            }
        }
    }*/

