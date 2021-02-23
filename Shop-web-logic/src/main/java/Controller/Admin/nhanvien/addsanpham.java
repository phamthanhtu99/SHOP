package Controller.Admin.nhanvien;

import Command.nhacungcapCommand;
import Command.sanphamCommand;
import Utils.FormUtils;
import common.loaisanphamCommon;
import common.nhacungcapCommon;
import common.sanphamCommon;
import common.webConstant;
import org.apache.commons.lang.StringUtils;
import org.example.core.comon.utils.uploadUtil;
import org.example.core.dto.hinhanhDTO;
import org.example.core.dto.loaisanphamDTO;
import org.example.core.dto.nhacungcapDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.hinhanhService;
import org.example.service.nhacungcapService;
import org.example.service.sanphamService;
import org.example.serviecimpl.hinhanhserviceImpl;
import org.example.serviecimpl.nhacungcapServiceImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet( urlPatterns = {"/admin-themsanpham.html","/ajax-themsanpham.html"})
public class addsanpham extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            sanphamCommand command = FormUtils.populate(sanphamCommand.class, req);
            req.setAttribute(webConstant.loaisanpham, loaisanphamCommon.all());
            /*  nhà cung cấp*/
            req.setAttribute(webConstant.nhacungcap, nhacungcapCommon.ViewsNCC());

            if (command.getUrlType() != null) {
                if (command.getUrlType().equals("nhacungcap1")) {  /*hiện tho from thêm nhà cung cấp*/
                    req.getRequestDispatcher("views/admin/sanpham/edit.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("views/admin/addsanpham.jsp").forward(req, resp);
                req.getSession().removeAttribute(webConstant.thongbao);
                req.getSession().removeAttribute(webConstant.ketqua);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanphamCommand command = FormUtils.populate(sanphamCommand.class, req);
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        sanphamService sanphamService = new sanphamServiceImpl();
        hinhanhService hinhanhService = new hinhanhserviceImpl();
        if (command.getUrlType() != null) {
            if (command.getUrlType().equals(webConstant.themsanpham)) {    /*thêm sản phẩm*/
                uploadUtil uploadUtil = new uploadUtil();
                Set<String> valueTitle = BuidsetValueListenguidline(); /*lấy các name trong from add sản phẩm*/
                try {
                    Object[] objects = uploadUtil.writeorUpload(req, valueTitle, webConstant.sanpham);
                    Map<String, String> mapValue = (Map<String, String>) objects[3];
                    command = returnvalueListenguidlineCommand(valueTitle, command, mapValue);  /*truyền dữ liệu vào command -> pojo    */
                    sanphamDTO dto = command.getPojo();
                  /*  if (sanphamService.timtheosanpham(dto.getId())==null) { *//*kiêm tra ma sản phẩm có tồn tại*/
                        List<String> strings = (List<String>) objects[2];  /*lấy tên hình ảnh từ objects */
                        if (StringUtils.isNotBlank(command.getPojo().getId()) && StringUtils.isNotBlank(command.getPojo().getTensp()) && command.getPojo().getLoaisanpham().getId() >= 1 && command.getPojo().getNhacungcapdto().getId() >= 1) {
                            sanphamService.save(dto);
                            for (String s : strings) { /*lọc từ tên của ảnh*/
                                hinhanhDTO hinhanhDTO = new hinhanhDTO();
                                hinhanhDTO.setSanphamDTO(dto);
                                hinhanhDTO.setTenhinh(s);
                                hinhanhService.savehinhanh(hinhanhDTO);   /*thêm hình ảnh vào csdl*/
                            }
                        }
                        req.getSession().setAttribute(webConstant.ketqua, "success");
                        req.getSession().setAttribute(webConstant.thongbao, "Thêm sản phẩm thành công");
                        resp.sendRedirect("/admin-themsanpham.html");
                   /* }else {
                        req.getSession().setAttribute(webConstant.ketqua, "danger");
                        req.getSession().setAttribute(webConstant.thongbao, "Mã sản phẩm tồn tại");
                        resp.sendRedirect("/admin-themsanpham.html");
                    }*/
                } catch (Exception e) {
                    req.getSession().setAttribute(webConstant.ketqua,"danger");
                    req.getSession().setAttribute(webConstant.thongbao,"Thêm Thất bại thất bại");
                    resp.sendRedirect("/admin-themsanpham.html");
                }

            } else if (command.getUrlType().equals("nhacungcap")) {
                nhacungcapCommand command1 = FormUtils.populate(nhacungcapCommand.class, req);
                nhacungcapDTO dto = command1.getPojo();
                nhacungcapService nhacungcapService = new nhacungcapServiceImpl();
                nhacungcapService.save(dto);
                req.setAttribute(webConstant.MESSAGE_RESPONSE, webConstant.Type_ERROR);
                req.setAttribute(webConstant.sanpham, sanphamCommon.viewsp());
                /*  --------------------------------------------------------------------*/
                req.setAttribute(webConstant.loaisanpham, loaisanphamCommon.all());
                req.setAttribute(webConstant.nhacungcap, nhacungcapCommon.ViewsNCC());
//                ----------------------------------------------------------------------
                req.getRequestDispatcher("views/admin/addsanpham.jsp").forward(req, resp);
            }
        }
    }

    private Set<String> BuidsetValueListenguidline() { /*thêm các name trong input của from*/
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.id");
        returnValue.add("pojo.tensp");
        returnValue.add("pojo.giatien");
        returnValue.add("pojo.mota");
        returnValue.add("pojo.loaisanpham");
        returnValue.add("pojo.nhacungcapdto");
        return returnValue;
    }

    private sanphamCommand returnvalueListenguidlineCommand(Set<String> valueTitle, sanphamCommand command, Map<String, String> mapValue) { /*truyền dữ liệu và sanphamcomaad*/

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
