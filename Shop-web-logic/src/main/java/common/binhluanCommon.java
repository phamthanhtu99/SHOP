package common;

import Command.binhluanCommand;
import org.example.service.binhluanService;
import org.example.serviecimpl.binhluanServiceImpl;

public class binhluanCommon {
    private static binhluanService binhluanService = new binhluanServiceImpl();
    public static void xoabl(binhluanCommand command){
        binhluanService.xoab(command.getPojo().getId());
    }
}
