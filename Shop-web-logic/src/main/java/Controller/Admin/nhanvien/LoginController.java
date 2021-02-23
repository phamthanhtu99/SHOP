package Controller.Admin.nhanvien;

import Command.nhanvienCommand;
import Utils.FormUtils;
import common.webConstant;
import org.example.core.dto.nhanvienDTO;
import org.example.core.dto.nhanvienquanlyhoadonDTO;
import org.example.service.nhanvienService;
import org.example.serviecimpl.nhanvienServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/LoginAdmin.py","/ajax-admin.html"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(webConstant.idnhanvien);
        nhanvienCommand command = FormUtils.populate(nhanvienCommand.class, req);
        if (command.getUrlType()!=null){
            if (command.getUrlType().equals("dangxuat")){
                req.getSession().removeAttribute(webConstant.idnhanvien);
                req.getSession().removeAttribute(webConstant.nhanvienbanhang);
            }
        }
        req.getRequestDispatcher("views/admin/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhanvienCommand command = FormUtils.populate(nhanvienCommand.class, req);
        nhanvienDTO dto = command.getPojo();
        nhanvienService service = new nhanvienServiceImpl();
        if(command.getUrlType().equals(webConstant.login)){
            try {
                if (service.Kiemtranguoidung(dto) != null && service.Kiemtranguoidung(dto).getEmail()!=null) {
                    System.out.println( service.Kiemtranguoidung(dto).getChucvuEntity().getTenChucVu());
                    if (service.Kiemtranguoidung(dto).getChucvuEntity().getTenChucVu().equals(webConstant.admin)) {
                        req.setAttribute(webConstant.MESSAGE_RESPONSE, "sussces");
                        req.getSession().setAttribute(webConstant.idnhanvien,service.Kiemtranguoidung(dto).getId());
                        req.getSession().setAttribute(webConstant.nhanvienquanly,service.Kiemtranguoidung(dto).getTennhanvien());
                        resp.sendRedirect("/admin-quanlysanpham.jsp");
                    }else if (service.Kiemtranguoidung(dto).getChucvuEntity().getTenChucVu().equals(webConstant.quanly)){
                        req.setAttribute(webConstant.MESSAGE_RESPONSE, "sussces");
                        req.getSession().setAttribute(webConstant.idnhanvien,service.Kiemtranguoidung(dto).getId());
                        req.getSession().setAttribute(webConstant.nhanvienquanly,service.Kiemtranguoidung(dto).getTennhanvien());
                        resp.sendRedirect("/admin-quanlysanpham.jsp");
                    }else if (service.Kiemtranguoidung(dto).getChucvuEntity().getTenChucVu().equals(webConstant.nhanvienbanhang)){
                        req.setAttribute(webConstant.MESSAGE_RESPONSE, "sussces");
                        req.getSession().setAttribute(webConstant.idnhanvien,service.Kiemtranguoidung(dto).getId());
                        req.getSession().setAttribute(webConstant.nhanvienquanly,service.Kiemtranguoidung(dto).getTennhanvien());
                        resp.sendRedirect("/admin-quanlysanpham.jsp");
                    }
                }
            } catch (NullPointerException e) {
               /* req.setAttribute(webConstant.ALERT, webConstant.Type_ERROR);*/
                req.setAttribute(webConstant.MESSAGE_RESPONSE, "err");

            }
        }


    }

}
