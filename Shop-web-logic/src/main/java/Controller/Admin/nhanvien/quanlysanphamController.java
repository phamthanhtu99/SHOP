package Controller.Admin.nhanvien;

import Command.loaisanphamCommand;
import Command.nhacungcapCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.loaisanphamCommon;
import common.nhacungcapCommon;
import common.sanphamCommon;
import common.webConstant;
import org.apache.commons.lang.StringUtils;
import org.example.core.comon.utils.uploadUtil;
import org.example.core.dto.loaisanphamDTO;
import org.example.core.dto.nhacungcapDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.loaisanphamService;
import org.example.service.nhacungcapService;
import org.example.service.sanphamService;
import org.example.serviecimpl.loaisanphamServiceImpl;
import org.example.serviecimpl.nhacungcapServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = {"/admin-quanlysanpham.jsp", "/ajax-quanlysanpham.html"})
public class quanlysanphamController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        sanphamService service2 = new sanphamServiceImpl();
        /*    _------------------xóa sản phẩm---------------------------*/
        sanphamCommand command2 = FormUtils.populate(sanphamCommand.class, req);
        sanphamDTO dto = command2.getPojo();
        if (command2.getUrlType() != null) {
            if (command2.getUrlType().equals("capnhat")) {
                req.setAttribute(webConstant.item,sanphamCommon.chitietsanpham(command2.getPojo().getId()));
                req.setAttribute(webConstant.loaisanpham, loaisanphamCommon.all());
                req.setAttribute(webConstant.nhacungcap, nhacungcapCommon.ViewsNCC());
                req.getRequestDispatcher("views/admin/sanpham/updatesp.jsp").forward(req, resp);
            } else if (command2.getUrlType().equals("nhacungcap1")) {
                req.getRequestDispatcher("views/admin/sanpham/edit.jsp").forward(req, resp);
            }else if (command2.getUrlType().equals("phantrang")){
                        req.setAttribute(webConstant.sanpham, sanphamCommon.phantrang(command2));
                        req.getRequestDispatcher("views/admin/quanlysanpham.jsp").forward(req, resp);
            }
        }
        if (command2.getUrlType() == null) {
            /* loại sản phẩm*/
            req.setAttribute(webConstant.sanpham, sanphamCommon.timkiemsanpham(command2));
            req.setAttribute(webConstant.listItem, sanphamCommon.viewsp1());
            req.setAttribute(webConstant.loaisanpham, loaisanphamCommon.all());
            /*  nhà cung cấp*/
            req.setAttribute(webConstant.nhacungcap, nhacungcapCommon.ViewsNCC());
            /* -------views san pham-------------------*/
            req.getRequestDispatcher("views/admin/quanlysanpham.jsp").forward(req, resp);
            req.getSession().removeAttribute(webConstant.thongbao);
            req.getSession().removeAttribute(webConstant.ketqua);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanphamCommand command = FormUtils.populate(sanphamCommand.class, req);
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
            if (command.getUrlType() != null) {
                if (command.getUrlType().equals("timkiemsanpham")) {
                    req.setAttribute(webConstant.listItem, sanphamCommon.viewsp());
                    req.setAttribute(webConstant.sanpham, sanphamCommon.timkiemsanpham(command));
                    req.getRequestDispatcher("views/admin/quanlysanpham.jsp").forward(req, resp);
                } else if (command.getUrlType().equals("xoasp")) {
                    sanphamCommon.updatesanpham(command);
                    req.setAttribute(webConstant.listItem, sanphamCommon.viewsp());
                    req.setAttribute(webConstant.sanpham, sanphamCommon.phantrang(command));
                    req.getRequestDispatcher("views/admin/quanlysanpham.jsp").forward(req, resp);
                } else if (command.getUrlType().equals("capnhat")) {
                    uploadUtil uploadUtil = new uploadUtil();
                    Set<String> valueTitle = BuidsetValueListenguidline();
                    try {
                        Object[] objects = uploadUtil.writeorUpload(req, valueTitle, webConstant.sanpham);
                        Map<String, String> mapValue = (Map<String, String>) objects[3];
                        command = returnvalueListenguidlineCommand(valueTitle, command, mapValue);
                        sanphamDTO dto = command.getPojo();
                        sanphamCommon.update(dto);
                        req.getSession().setAttribute(webConstant.thongbao,"Thành Công");
                        req.getSession().setAttribute(webConstant.ketqua,"success");
                        resp.sendRedirect("/admin-quanlysanpham.jsp");
                    } catch (Exception e) {
                        req.getSession().setAttribute(webConstant.ketqua,"danger");
                        req.getSession().setAttribute(webConstant.thongbao,"Cập nhật Thất bại");
                        resp.sendRedirect("/admin-quanlysanpham.jsp");
                    }
                }
            }


    }
    private Set<String> BuidsetValueListenguidline() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.id");
        returnValue.add("pojo.tensp");
        returnValue.add("pojo.giatien");
        returnValue.add("pojo.mota");
        returnValue.add("pojo.loaisanpham");
        returnValue.add("pojo.nhacungcapdto");
        return returnValue;
    }

    private sanphamCommand returnvalueListenguidlineCommand(Set<String> valueTitle, sanphamCommand command, Map<String, String> mapValue) {

        for (String items : valueTitle) {
            if (items.equals("pojo.id")) {
                command.getPojo().setId(mapValue.get(items));
            } else if (items.equals("pojo.tensp")) {
                command.getPojo().setTensp(mapValue.get(items));

            } else if (items.equals("pojo.giatien")) {
                command.getPojo().setGiatien(Integer.parseInt(mapValue.get(items)));

            } else if (items.equals("pojo.mota")) {
                command.getPojo().setMota(mapValue.get(items));

            } else if (items.equals("pojo.loaisanpham")) {
                loaisanphamDTO dto = new loaisanphamDTO();
                dto.setId(Integer.parseInt(mapValue.get(items)));

                command.getPojo().setLoaisanpham(dto);

            } else if (items.equals("pojo.nhacungcapdto")) {
                nhacungcapDTO dto = new nhacungcapDTO();
                dto.setId(Integer.parseInt(mapValue.get(items)));
                command.getPojo().setNhacungcapdto(dto);

            }

        }
        return command;
    }
}