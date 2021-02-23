package common;

import Command.chitietphieunhaoCommand;
import Command.phieunhapCommand;
import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.orderdto;
import org.example.core.dto.phieunhapDTO;
import org.example.core.dto.sanphamDTO;
import org.example.service.chitietnhapService;
import org.example.service.phieunhapServiec;
import org.example.serviecimpl.chitietphieunhaoServiceImpl;
import org.example.serviecimpl.phieunhapServiceIpml;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class chitietphieunhapCommond {
    private static orderdto order = new orderdto();
    private static chitietnhapService chitietnhapService = new chitietphieunhaoServiceImpl();
    private static chitietphieunhaoCommand chitietphieunhaoCommand = new chitietphieunhaoCommand();
    private static chitietphieunhapDTO chitietphieunhapDTO = new chitietphieunhapDTO();
    private  static phieunhapServiec phieunhapServiec = new phieunhapServiceIpml();



    public static void savectnhap(List<orderdto> list, String MaPN) {
        phieunhapDTO phieunhapDTO = new phieunhapDTO();
        phieunhapDTO.setId(MaPN);
        chitietphieunhapDTO.setPhieunhapDTO(phieunhapDTO);
        for (orderdto orderdto:list){
            for (Map.Entry<sanphamDTO,Integer> entry: orderdto.getList().entrySet()){
                sanphamDTO sanphamDTO = new sanphamDTO();
                 sanphamDTO = entry.getKey();
                 chitietphieunhapDTO.setSanphamDTO(sanphamDTO);
                 chitietphieunhapDTO.setSoluong(entry.getValue());
                 chitietphieunhapDTO.setThanhtien(chitietphieunhapDTO.getSoluong()*orderdto.getGiaotien());
                 chitietphieunhapDTO.setGiatien(orderdto.getGiaotien());
            }
            chitietphieunhapDTO.setGiatien(orderdto.getGiaotien());
            chitietnhapService.saveCtphieunhap(chitietphieunhapDTO);

        }
//        for (Map.Entry<sanphamDTO, Integer> entry : list.entrySet()) {
//            sanphamDTO sanphamDTO = new sanphamDTO();
//            System.out.println(entry.getKey().getId());
//            sanphamDTO = entry.getKey();
//            chitietphieunhapDTO.setSanphamDTO(sanphamDTO);
//            chitietphieunhapDTO.setSoluong(entry.getValue());
//            chitietphieunhapDTO.setThanhtien(chitietphieunhapDTO.getSoluong()*sanphamDTO.getGiatien());
//            chitietnhapService.saveCtphieunhap(chitietphieunhapDTO);
//        }
    }

    public static chitietphieunhaoCommand viewschitietnhap() {
        chitietphieunhaoCommand.setChitietphieunhapDTOS(chitietnhapService.CHITIETPHIEUNHAPall());
        return chitietphieunhaoCommand;
    }
    public static chitietphieunhaoCommand chitietphieunhapthieumaphieunhap(phieunhapCommand command) {
        chitietphieunhaoCommand.setChitietphieunhapDTOS(chitietnhapService.CHITIETPHIEUNHAP_DTO(command.getPojo()));
        return chitietphieunhaoCommand;
    }
    public static chitietphieunhaoCommand phieunhap(phieunhapCommand command) {
        chitietphieunhaoCommand.setPhieunhapDTO(phieunhapServiec.timtheoid(command.getPojo().getId()));
        return chitietphieunhaoCommand;
    }


}
