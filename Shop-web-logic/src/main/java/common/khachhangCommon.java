package common;

import Command.KhachHangCommand;
import org.example.core.dao.KhachHangDao;
import org.example.core.daoimpl.KhachHangDaoImpl;
import org.example.core.dto.KhachHangDTO;
import org.example.service.KhachHangService;
import org.example.serviecimpl.KhachHangServiceImpl;

public class khachhangCommon {
    static KhachHangService hangService = new KhachHangServiceImpl();
    static KhachHangCommand command = new KhachHangCommand();
    static KhachHangDTO khachHangDTO = new KhachHangDTO();

    public static KhachHangCommand viewkhachhang(KhachHangCommand command) {
        if (command.getPojo() != null && command.getPojo().getSdt() != null) {
            if (command.getPojo().getTenKhachhang().equals("")) {
                command.getPojo().setTenKhachhang(null);
            }
            if (command.getPojo().getSdt().equals("")) {
                command.getPojo().setSdt(null);
            }
        }
        command.setListResult(hangService.khachhang(command.getPojo().getTenKhachhang(), command.getPojo().getSdt()));
        return command;
    }
    public static KhachHangCommand khachangid(KhachHangCommand command){

        command.setPojo(hangService.timtheoid(command.getPojo()));
        return command;
    }
    public static void update (KhachHangCommand command){
        hangService.update(command.getPojo());
    }
}
