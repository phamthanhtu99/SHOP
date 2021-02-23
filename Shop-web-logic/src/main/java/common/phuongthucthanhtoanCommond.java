package common;

import Command.phuongthucthanhtoanCommand;
import org.example.service.phuongthucthanhtoanService;
import org.example.serviecimpl.phuongthucthanhtoanServiceIpml;

public class phuongthucthanhtoanCommond {
    private static phuongthucthanhtoanService phuongthucthanhtoanService = new phuongthucthanhtoanServiceIpml();
    private  static   phuongthucthanhtoanCommand phuongthucthanhtoanCommand = new phuongthucthanhtoanCommand();
    public static phuongthucthanhtoanCommand phuongthucthanhtoan (){
        phuongthucthanhtoanCommand.setPhuongthucthanhtoanDTOS(phuongthucthanhtoanService.PHUONGTHUCTHANHTOAN_DTOS());
        return phuongthucthanhtoanCommand;
    }

}
