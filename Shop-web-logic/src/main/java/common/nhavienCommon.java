package common;

import Command.nhanvienCommand;
import org.example.core.dto.nhanvienDTO;
import org.example.service.nhanvienService;
import org.example.serviecimpl.nhanvienServiceImpl;

public class nhavienCommon {
    private static nhanvienCommand nhavienCommand = new nhanvienCommand();
    private static nhanvienService nhanvienService = new nhanvienServiceImpl();
    private static nhanvienDTO nhanvienDTO = new nhanvienDTO();

    public static nhanvienCommand viewnhanvien() {
        nhavienCommand.setNhanvienDTOS(nhanvienService.viewsnhanvien());
        return nhavienCommand;
    }

    public static nhanvienCommand chitietnhanvien(Integer id) {
        nhanvienDTO.setId(id);
        nhavienCommand.setPojo(nhanvienService.nhanvientheoID(nhanvienDTO));
        return nhavienCommand;
    }

    public static void addnhanvien(nhanvienDTO dto) {
        nhanvienService.save(dto);
    }

    public static void edtnhanhvien(nhanvienDTO dto) {
        nhanvienService.updatenhanvien(dto);
    }

    public static void removenhanvien(nhanvienDTO dto) {
        nhanvienService.detele(dto.getId());
    }
}
