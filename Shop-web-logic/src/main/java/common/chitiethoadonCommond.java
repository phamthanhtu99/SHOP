package common;

import Command.chitiethoadonCommand;
import Command.chucvuCommand;
import Command.hoadonCommand;
import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.hoadonDTO;
import org.example.core.dto.sanphamDTO;
import org.example.persistence.data.chitiethoadonEntity;
import org.example.service.chitiethoadonService;
import org.example.service.hoadonService;
import org.example.serviecimpl.chitiethoadonServiceImpl;
import org.example.serviecimpl.hoadomServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class chitiethoadonCommond {
    private static chitiethoadonEntity chitiethoadonEntity = new chitiethoadonEntity();
    private static hoadonService hoadonService = new hoadomServiceImpl();
    private static chitiethoadonService chitiethoadonService = new chitiethoadonServiceImpl();
    private static hoadonDTO hoadonDTO = new hoadonDTO();
    private static chitiethoadonDTO chitiethoadonDTO = new chitiethoadonDTO();
    private static sanphamDTO sanphamDTO = new sanphamDTO();
    private static chitiethoadonCommand chitiethoadonCommand = new chitiethoadonCommand();
    private static hoadonCommand hoadonCommand = new hoadonCommand();
    private static KhachHangDTO khachHangDTO = new KhachHangDTO();

    public void luuchitiethoadon(TreeMap<sanphamDTO, Integer> sanphamDTOIntegerTreeMap, hoadonDTO hoadonDTO1) {
        chitiethoadonDTO.setHoadonDTO(hoadonDTO1);

        for (Map.Entry<sanphamDTO, Integer> entry : sanphamDTOIntegerTreeMap.entrySet()) {
            chitiethoadonDTO.setSoluong(entry.getValue());
            sanphamDTO = entry.getKey();
            chitiethoadonDTO.setSanphamDTO(sanphamDTO);
            chitiethoadonDTO.setGiatien(entry.getKey().getGiatien() * entry.getValue());
            chitiethoadonService.save(chitiethoadonDTO);
        }

    }

 /*   public static chitiethoadonCommand chitiethoadonCommandviews(hoadonCommand hoadonCammand) {
        for (hoadonDTO dto : hoadonCammand.getHoadonDTOS()) {
            if (dto.getId().equals(hoadonCammand.getPojo().getId())) {
                hoadonDTO = dto;
            }
        }
        chitiethoadonCommand.setChitiethoadonDTOS(chitiethoadonService.CHITIETHOADON_DTOS(hoadonDTO));
        chitiethoadonCommand.setHoadonDTO(hoadonDTO);
        return chitiethoadonCommand;
    }*/

    public static chitiethoadonCommand chitiethoadonthephoadon(hoadonCommand hoadonCommand) {

        List<hoadonDTO> list = hoadonService.viewstatall();
        for (hoadonDTO dto : list) {
            if (dto.getId().equals(hoadonCommand.getPojo().getId())) {
                hoadonDTO = dto;
            }
        }
        chitiethoadonCommand.setListResult(chitiethoadonService.chitiethoadontheohoadon(hoadonDTO));
        chitiethoadonCommand.setHoadonDTO(hoadonDTO);
        return chitiethoadonCommand;
    }

    public static chitiethoadonCommand chitiethoadontgiaohang(hoadonCommand hoadonCommand) {
        List<hoadonDTO> list = hoadonService.viewsgiaohang();
        for (hoadonDTO dto : list) {
            if (dto.getId().equals(hoadonCommand.getPojo().getId())) {
                hoadonDTO = dto;
            }
        }
        chitiethoadonCommand.setListResult(chitiethoadonService.chitiethoadontheohoadon(hoadonDTO));
        chitiethoadonCommand.setHoadonDTO(hoadonDTO);
        return chitiethoadonCommand;
    }

    public static chitiethoadonCommand chitiethoadon(hoadonCommand hoadonCommand) {
        hoadonDTO hoadonDTO = hoadonService.viewsID(hoadonCommand.getPojo());
        List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<chitiethoadonDTO>();
        for (chitiethoadonDTO dto : hoadonDTO.getChitiethoadonDTOS()) {
            chitiethoadonDTOS.add(dto);
        }
        chitiethoadonCommand.setHoadonDTO(hoadonDTO);
        chitiethoadonCommand.setChitiethoadonDTOS(chitiethoadonDTOS);
        return chitiethoadonCommand;
    }
}
