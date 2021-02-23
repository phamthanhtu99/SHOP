package common;

import Command.nhasanxuatCommand;
import org.example.service.nhasanxuatService;
import org.example.serviecimpl.nhasanxuatServiceImpl;

public class nhasanxuatCommond {
    private static nhasanxuatService nhasanxuatService = new nhasanxuatServiceImpl();
    private static nhasanxuatCommand nhasanxuatCommond = new nhasanxuatCommand();
    public static nhasanxuatCommand viewsnsx(){
            nhasanxuatCommond.setNhasanxuatDTOS(nhasanxuatService.viewsnhanvien());
            return nhasanxuatCommond;
    }
}
