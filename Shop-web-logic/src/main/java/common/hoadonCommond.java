package common;

import Command.hoadonCommand;
import org.example.core.dto.*;
import org.example.service.hoadonService;
import org.example.service.nhanvienquanlyhoadonService;
import org.example.serviecimpl.hoadomServiceImpl;
import org.example.serviecimpl.nhanvienquanlyhoadonServiceImpl;

import java.sql.Timestamp;
import java.util.Date;


public class hoadonCommond {
    private static hoadonService hoadonService = new hoadomServiceImpl();
    private static hoadonCommand hoadonCommand = new hoadonCommand();
    private static hoadonDTO hoadonDTO = new hoadonDTO();
    private static KhachHangDTO khachHangDTO = new KhachHangDTO();
    private static tinhtrangDTO tinhtrangDTO = new tinhtrangDTO();
    private static phuongthucthanhtoanDTO phuongthucthanhtoanDTO = new phuongthucthanhtoanDTO();
    private static nhanvienquanlyhoadonService nhanvienquanlyhoadonService = new nhanvienquanlyhoadonServiceImpl();
    private static nhanvienDTO nhanvienDTO = new nhanvienDTO();
    private static nhanvienquanlyhoadonDTO nhanvienquanlyhoadonDTO = new nhanvienquanlyhoadonDTO();
    private static long millis = System.currentTimeMillis();
    private static java.sql.Date date = new java.sql.Date(millis);

    public static hoadonDTO luuhoadon(hoadonCommand hoadonCommand) {
        Date date = new Date();
        hoadonDTO = hoadonCommand.getPojo();
        khachHangDTO.setId(hoadonCommand.getTenkhachhang());
        hoadonDTO.setKhachHangDTO(khachHangDTO);
        tinhtrangDTO.setId(1);
        hoadonDTO.setId(hoadonCommand.getIdhoadon());
        phuongthucthanhtoanDTO.setId(hoadonCommand.getPhuongthucgiaohang());
        hoadonDTO.setPhuongthucthanhtoanDTO(phuongthucthanhtoanDTO);
        hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
        hoadonDTO.setNgaymua(new Timestamp(new Date().getTime()));
        hoadonDTO = hoadonService.save(hoadonDTO);
        return hoadonDTO;
    }

   /* public static hoadonCommand viewshoadon(hoadonCommand hoadonCommand) {
        khachHangDTO.setId(hoadonCommand.getTenkhachhang());
        hoadonCommand.setHoadonDTOS(hoadonService.HOADON_DTOS(khachHangDTO));
        return hoadonCommand;
    }*/

    public static void updatehoadon(hoadonCommand hoadonCommand) {/* hủy đơn hang*/
        tinhtrangDTO.setId(3);
        hoadonDTO = hoadonService.viewsID(hoadonCommand.getPojo());
        hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
        hoadonService.update(hoadonDTO);

    }

 /*   public static void updatehoadondatlai(hoadonCommand hoadonCommand) {
        tinhtrangDTO.setId(1);
        hoadonDTO = hoadonService.viewsID(hoadonCommand.getPojo());
        hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
        hoadonService.update(hoadonDTO);

    }*/

    public static hoadonCommand viewshoadonchuaxacnhan() {
        hoadonCommand.setHoadonchuaxacnhan(hoadonService.viewstatall());
        return hoadonCommand;
    }

    public static hoadonCommand capnhathoadon(hoadonCommand hoadonCommand) {
        hoadonDTO = hoadonService.viewsID(hoadonCommand.getPojo());
        nhanvienDTO.setId(hoadonCommand.getIdnhanvien());
        if (hoadonCommand.getUrlType().equals("nhandonhang")) {
            tinhtrangDTO.setId(4);
            hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
            hoadonService.update(hoadonDTO);
            nhanvienquanlyhoadonService.savenhanvienquanlyhoadon(hoadonDTO, nhanvienDTO);
        } else if (hoadonCommand.getUrlType().equals("huydonhang")) {
            tinhtrangDTO.setId(3);
            hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
            hoadonService.update(hoadonDTO);
            nhanvienquanlyhoadonService.savenhanvienquanlyhoadon(hoadonDTO, nhanvienDTO);
        } else if (hoadonCommand.getUrlType().equals("danhan")) {/* đã giao hàng*/
            tinhtrangDTO.setId(7);
            nhanvienquanlyhoadonDTO.setNgaygiao(date);
            nhanvienquanlyhoadonDTO.setHoadonDTO(hoadonCommand.getPojo());
            hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
            hoadonService.update(hoadonDTO);
            nhanvienquanlyhoadonDTO.setHoadonDTO(hoadonDTO);
            nhanvienquanlyhoadonService.update(nhanvienquanlyhoadonDTO);
        } else if (hoadonCommand.getUrlType().equals("dahuy")) { /*đơn hàng đã hủy*/
            tinhtrangDTO.setId(6);
            hoadonDTO.setTinhtrangDTO(tinhtrangDTO);
            hoadonService.update(hoadonDTO);
        }
        return hoadonCommand;
    }

    public static hoadonCommand giaohang() {  /*hiện thị list giao hàng*/
        hoadonCommand.setListResult(hoadonService.viewsgiaohang());
        return hoadonCommand;
    }

    public static hoadonCommand viewsall() {  /*views tất cả hóa đơn*/
        hoadonCommand.setAll(hoadonService.viewsall());
        return hoadonCommand;
    }

    public static hoadonCommand hdchuaxacnhan(hoadonCommand command) { /*đơn hàng chưa xác nhận của khác hàng*/
        khachHangDTO.setId(command.getTenkhachhang());
        hoadonCommand.setListResult(hoadonService.hdchuaxacnhan(khachHangDTO));
        return hoadonCommand;
    }

    public static hoadonCommand lichsuhoadonvadahuy(hoadonCommand command) {
        khachHangDTO.setId(command.getTenkhachhang());
        if (command.getUrlType().equals("huyvalichsu") || command.getUrlType().equals("")) {
            hoadonCommand.setListResult(hoadonService.lichsuhdvadahuy(khachHangDTO, "3"));
        }else if (command.getUrlType().equals("lichsumuahang")){
            hoadonCommand.setListResult(hoadonService.lichsuhdvadahuy(khachHangDTO, "7"));
        }else {
            hoadonCommand.setListResult(hoadonService.lichsuhdvadahuy(khachHangDTO, "4"));
        }
        return hoadonCommand;
    }


}
