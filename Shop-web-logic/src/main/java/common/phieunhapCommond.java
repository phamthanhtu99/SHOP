package common;

import Command.nhanvienquanlydonhangCommand;
import Command.phieunhapCommand;
import org.example.core.dao.phieunhapDao;
import org.example.core.daoimpl.phieunhapDaoImpl;
import org.example.core.dto.nhasanxuatDTO;
import org.example.core.dto.phieunhapDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.service.chitietnhapService;
import org.example.service.phieunhapServiec;
import org.example.serviecimpl.chitietphieunhaoServiceImpl;
import org.example.serviecimpl.phieunhapServiceIpml;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class phieunhapCommond {
    public static phieunhapServiec phieunhapServiec = new phieunhapServiceIpml();
    public static phieunhapCommand phieunhapCommand = new phieunhapCommand();
    public  static chitietnhapService chitietnhapService = new chitietphieunhaoServiceImpl();
    public static void save(phieunhapCommand command) {
        nhasanxuatDTO nhasanxuatDTO = new nhasanxuatDTO();
        nhasanxuatDTO.setId(command.getNhasanxuat());
        phieunhapDTO phieunhapDTO = new phieunhapDTO();
        phieunhapDTO = command.getPojo();
        phieunhapDTO.setId(command.getId());
        phieunhapDTO.setNhasanxuatEntity(nhasanxuatDTO);
        phieunhapServiec.savephieunhap(phieunhapDTO);
    }

    public static phieunhapCommand phieunhapDTOList() {
        phieunhapCommand.setPhieunhapDTOList(phieunhapServiec.PHIEUNHAP_DTOS());
        return phieunhapCommand;
    }

    public static phieunhapCommand tongtien(TreeMap<sanphamDTO, Integer> dtoTreeMap) {
        double tien = 0;
        if (dtoTreeMap.size() > 0) {
            for (Map.Entry<sanphamDTO, Integer> entry : dtoTreeMap.entrySet()) {
                tien = tien + entry.getKey().getGiatien() * entry.getValue();
            }
        }
        phieunhapCommand.setTongtien(tien);
        return phieunhapCommand;

    }

    public static phieunhapCommand viewsphieunhap(phieunhapCommand command) {
        if (command.getIdhoadon() == "") {
            command.setIdhoadon(null);
        }
        if (command.getNgaycuoi() == "") {
            command.setNgaycuoi(null);
        }
        if (command.getNgaydau() == "") {
            command.setNgaydau(null);
        }
        phieunhapCommand.setPhieunhapDTOList(phieunhapServiec.viewphieunhapDTO(command.getIdhoadon(), command.getNgaydau(), command.getNgaycuoi()));
        return phieunhapCommand;
    }

    public static Object[] stnhap(nhanvienquanlydonhangCommand command) {
        double tien = 0;
        if (command.getNgaybatday()!=null   ){
            nhanvienquanlydonhang.xulithangnam(command);
        }
        for (phieunhapDTO dto : phieunhapServiec.stnhap(command.getNam(), command.getThang())) {
                tien=tien+dto.getTongtien();
        }
        return new Object[]{tien};
    }
}
