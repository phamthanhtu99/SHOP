package common;

import Command.chucvuCommand;
import org.example.service.chucvuService;
import org.example.serviecimpl.chucvuServiceImpl;

import java.util.List;

public class chucvuCommond {
    private  static chucvuCommand chucvuCommand = new chucvuCommand();
    private  static chucvuService chucvuService = new chucvuServiceImpl();
    public static chucvuCommand viewsCV(){
        chucvuCommand.setChucvuDTOS(chucvuService.CHUCVU_DTOS());
        return chucvuCommand;
    }
}
