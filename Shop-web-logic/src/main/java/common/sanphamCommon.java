package common;

import Command.binhluanCommand;
import Command.sanphamCommand;
import org.example.core.dto.orderdto;
import org.example.core.dto.sanphamDTO;
import org.example.service.binhluanService;
import org.example.service.hienthiSerice;
import org.example.service.sanphamService;
import org.example.serviecimpl.binhluanServiceImpl;
import org.example.serviecimpl.hienthisanphamSeriveImpl;
import org.example.serviecimpl.sanphamServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class sanphamCommon {
  private static   sanphamService service = new sanphamServiceImpl();
    private static  sanphamCommand sanphamCommand = new sanphamCommand();
    private static sanphamDTO sanphamDTO = new sanphamDTO();
    private static orderdto orderdto= new orderdto();
    public static binhluanCommand chitietbinhluansanpham(sanphamDTO dto) {
        binhluanService binhluanService = new binhluanServiceImpl();
        binhluanCommand binhluanCommand = new binhluanCommand();
        binhluanCommand.setBinhluanDTOS(binhluanService.BINHLUAN_DTO_LIST(dto));
        return binhluanCommand;
    }
    public  static sanphamDTO chitietsanpham(String ID){
        sanphamDTO =service.timtheosanpham(ID);
        return sanphamDTO;
    }
    public  static sanphamCommand viewsp (){
        sanphamCommand.setSanphamDTOList(service.viewsSp());
        return sanphamCommand;
    }
    public  static sanphamCommand viewsp1 (){
        sanphamCommand.setListResult(service.viewsSp());
        return sanphamCommand;
    }
  /*  views san pham phieunhap*/
        public static sanphamCommand tongtien(TreeMap<sanphamDTO,Integer> list){
            double tien=0;
            if (list.size()>0) {
                for (Map.Entry<sanphamDTO, Integer> entry : list.entrySet()) {
                    tien = tien + entry.getKey().getGiatien() * entry.getValue();
                }
            }
            sanphamCommand.setTongtien(tien);
            return sanphamCommand;

        }
        public  static  sanphamCommand sanphamnoibac(){

            Object [] objects = service.FindByproprety1(0,4,"","");
            sanphamCommand.setSanphamnoibac((List<sanphamDTO>) objects[1]);
            return sanphamCommand;
        }
    public  static  sanphamCommand xe(sanphamCommand command){
        sanphamCommand.setListResult(service.xe(0,command.getLimit(),command.getPojo().getTensp(),command.getLoaisanpham()));
        return sanphamCommand;
    }

    public  static  sanphamCommand timkiemsanpham(sanphamCommand command){

        Object [] objects = service.timkiemsanpham(0,4,command.getPojo().getId(),command.getPojo().getTensp());
        sanphamCommand.setSanphamDTOList((List<org.example.core.dto.sanphamDTO>) objects[1]);
        sanphamCommand.setTotalItems((Integer) objects[0]);
        sanphamCommand.setMaxPageItems(4);
        sanphamCommand.setTotalPage( (int) Math.ceil((double) sanphamCommand.getTotalItems()/ sanphamCommand.getMaxPageItems()) );
        return sanphamCommand;
    }
    public  static sanphamCommand phantrang(sanphamCommand command){
            command.setMaxPageItems(4);
            command.setTotalItems((command.getPage()-1)* command.getMaxPageItems());
            Object [] objects = service.timkiemsanpham(command.getTotalItems(),4,null,null);
            sanphamCommand.setSanphamDTOList((List<org.example.core.dto.sanphamDTO>) objects[1]);
            command.setTotalItems((Integer) objects[0]);
            sanphamCommand.setMaxPageItems(4);
            sanphamCommand.setPage(command.getPage());
            return sanphamCommand;
    }
    public static void updatesanpham(sanphamCommand command){
        if (command.getUrlType() != null) {
            if (command.getUrlType().equals("xoasp")) {
                service.detele(command.getPojo().getId());
            }
        }
    }
    public static void update(sanphamDTO dto){
            service.update(dto);
    }
}
