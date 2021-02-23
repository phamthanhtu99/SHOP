package common;

import Command.hoadonCommand;
import Command.nhanvienquanlydonhangCommand;
import org.apache.commons.lang.StringUtils;
import org.example.core.dto.nhanvienquanlyhoadonDTO;
import org.example.serviecimpl.nhanvienquanlyhoadonServiceImpl;

import java.util.List;

public class nhanvienquanlydonhang {
    private static nhanvienquanlyhoadonServiceImpl service = new nhanvienquanlyhoadonServiceImpl();
    private static nhanvienquanlydonhangCommand nhanvienquanlydonhangCommand = new nhanvienquanlydonhangCommand();

    public static nhanvienquanlydonhangCommand viewsnhanvien(nhanvienquanlydonhangCommand command) {
        if (command.getHoadon() == "") {
            command.setHoadon(null);
        }
        if (command.getIdnhanvien() == "") {
            command.setIdnhanvien(null);
        }
        if (command.getNgaybatday() == "") {
            command.setNgaybatday(null);
        }
        if (command.getNgaycuoi() == "") {
            command.setNgaycuoi(null);
        }
        nhanvienquanlydonhangCommand.setListResult(service.views(command.getHoadon(), command.getNgaybatday(), command.getNgaycuoi(), command.getIdnhanvien()));
        return nhanvienquanlydonhangCommand;
    }
    public static nhanvienquanlydonhangCommand danhthu(nhanvienquanlydonhangCommand command) {
        if (command.getNgaycuoi()=="") {
            command.setNgaycuoi(null);
        }
        if (command.getNgaybatday()=="") {
            command.setNgaybatday(null);
        }
        if (command.getSanpham()=="") {
            command.setSanpham(null);
        }
        if (command.getHoadon()=="") {
            command.setHoadon(null);
        }
        if (command.getIdnhanvien() == "") {
            command.setIdnhanvien(null);
        }
        nhanvienquanlydonhangCommand.setListResult(service.danhthu(command.getNgaybatday(),command.getNgaycuoi(),command.getHoadon(),command.getSanpham(),command.getIdnhanvien()));
        return nhanvienquanlydonhangCommand;
    }
    public static nhanvienquanlydonhangCommand quanlysanpham(nhanvienquanlydonhangCommand command) {
        if (command.getNgaycuoi()=="") {
            command.setNgaycuoi(null);
        }
        if (command.getNgaybatday()=="") {
            command.setNgaybatday(null);
        }
        if (command.getSanpham()=="") {
            command.setSanpham(null);
        }
        if (command.getHoadon()=="") {
            command.setHoadon(null);
        }
        if (command.getIdnhanvien() == "") {
            command.setIdnhanvien(null);
        }
        nhanvienquanlydonhangCommand.setListResult(service.quanlysanpham(command.getNgaybatday(),command.getNgaycuoi(),command.getHoadon(),command.getSanpham(),command.getIdnhanvien(),command.getTinhtrang()));
        return nhanvienquanlydonhangCommand;
    }

    public static Object[] thongkesolieu() {
        List<nhanvienquanlyhoadonDTO> nhanvienquanlydonhangs= service.views(null,null,null,null);
        double dmua=0;
        double huy=0;
        for (nhanvienquanlyhoadonDTO dto : nhanvienquanlydonhangs){
            if (dto.getHoadonDTO().getTinhtrangDTO().getId() ==7){
                    dmua=dmua+dto.getHoadonDTO().getTongtien();
            }if (dto.getHoadonDTO().getTinhtrangDTO().getId() ==6){
                    huy=huy+dto.getHoadonDTO().getTongtien();
            }
        }
        return new Object[]{dmua,huy};
    }

    public static Object[] thongkesolieu1(nhanvienquanlydonhangCommand command) {
        if (command.getNgaybatday()!=null){
            xulithangnam(command);
        }
        List<nhanvienquanlyhoadonDTO> nhanvienquanlydonhangs= service.danhthusanpham(command.getThang(),command.getNam());
        double dmua=0;
        double huy=0;
        for (nhanvienquanlyhoadonDTO dto : nhanvienquanlydonhangs){
            if (dto.getHoadonDTO().getTinhtrangDTO().getId() ==7){
                dmua=dmua+dto.getHoadonDTO().getTongtien();
            }if (dto.getHoadonDTO().getTinhtrangDTO().getId() ==6){
                huy=huy+dto.getHoadonDTO().getTongtien();
            }
        }
        return new Object[]{dmua,huy};
    }
    public static   void xulithangnam(nhanvienquanlydonhangCommand command){
        if(command.getNgaybatday()!=null){
            String nam =command.getNgaybatday();
            String [] xl=nam.split("-");
            command.setNam(xl[0]);
            command.setThang(xl[1]);
        }

    }
}
