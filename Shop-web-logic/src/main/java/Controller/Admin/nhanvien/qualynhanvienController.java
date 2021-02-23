package Controller.Admin.nhanvien;

import Command.nhanvienCommand;
import Utils.FormUtils;
import common.chucvuCommond;
import common.nhavienCommon;
import common.webConstant;
import org.example.core.dto.chucvuDTO;
import org.example.core.dto.nhanvienDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-quanlynhanvien.html", "/ajax-editnhanvien.html"})
public class qualynhanvienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienCommand nhanvienCommand = FormUtils.populate(Command.nhanvienCommand.class, req);
        nhanvienDTO nhanvienDTO = nhanvienCommand.getPojo();
        req.setAttribute(webConstant.listItem, nhavienCommon.viewnhanvien());
        req.setAttribute(webConstant.chucvu, chucvuCommond.viewsCV());
            if (nhanvienCommand.getUrlType() != null) {
                if (nhanvienCommand.getUrlType().equals(webConstant.themnhanvien)) { /*hiển thị from thêm nhân viên*/
                    req.getRequestDispatcher("/views/admin/nhanvien/themnhanvien.jsp").forward(req, resp);
                } else if (nhanvienCommand.getUrlType().equals(webConstant.updatenhanvien)) {       /*from updat nhân viên*/
                    req.setAttribute(webConstant.item, nhavienCommon.chitietnhanvien(nhanvienDTO.getId()));
                    req.getRequestDispatcher("/views/admin/nhanvien/themnhanvien.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("/views/admin/quanlynhanvien.jsp").forward(req, resp);
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        nhanvienCommand nhanvienCommand = FormUtils.populate(nhanvienCommand.class, req);
        chucvuDTO chucvuDTO = new chucvuDTO();
        chucvuDTO.setId(nhanvienCommand.getChucvu());
        nhanvienDTO dto = nhanvienCommand.getPojo();;
        dto.setChucvuEntity(chucvuDTO);
        if (nhanvienCommand.getUrlType() != null) {
            if (nhanvienCommand.getUrlType().equals(webConstant.themnhanvien)) { /*xữ lý thêm nhân viên*/
                dto.setId(null);
                nhavienCommon.addnhanvien(dto);
                /*  hien thi nhan vien va chuc vu*/
                req.setAttribute(webConstant.listItem, nhavienCommon.viewnhanvien());
                req.setAttribute(webConstant.chucvu, chucvuCommond.viewsCV());
                /* -------------------------------*/
                req.getRequestDispatcher("/views/admin/quanlynhanvien.jsp").forward(req, resp);
            }else if (nhanvienCommand.getUrlType().equals(webConstant.editnhanvien)){   /*xữ lý thêm cập chập nhân viên*/
                nhavienCommon.edtnhanhvien(dto);
                req.setAttribute(webConstant.listItem, nhavienCommon.viewnhanvien());
                req.setAttribute(webConstant.chucvu, chucvuCommond.viewsCV());
                req.getRequestDispatcher("/views/admin/quanlynhanvien.jsp").forward(req, resp);
            }else if (nhanvienCommand.getUrlType().equals(webConstant.removenhanvien)){ /*xữ lý xóa nhân viên nhân viên*/
                nhavienCommon.removenhanvien(dto);
                req.setAttribute(webConstant.listItem, nhavienCommon.viewnhanvien());
                req.setAttribute(webConstant.chucvu, chucvuCommond.viewsCV());
                req.getRequestDispatcher("/views/admin/quanlynhanvien.jsp").forward(req, resp);
            }
        }

    }

}
