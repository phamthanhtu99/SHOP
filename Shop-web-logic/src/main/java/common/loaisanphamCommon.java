package common;

import Command.loaisanphamCommand;
import org.example.service.loaisanphamService;
import org.example.serviecimpl.loaisanphamServiceImpl;

public class loaisanphamCommon {

    private static  loaisanphamService service = new loaisanphamServiceImpl();
    private static  loaisanphamCommand command = new loaisanphamCommand();
      public  static loaisanphamCommand viewLSP(){
          command.setLoaisanphamDTOList(service.Findall());
          return command;
      }
      public  static  loaisanphamCommand viewslspxe(){
          command.setListResult(service.theoid("12"));
          return command;
      }
    public  static loaisanphamCommand all(){
        command.setLoaisanphamDTOList(service.all());
        return command;
    }
}
