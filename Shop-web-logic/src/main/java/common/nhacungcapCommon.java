package common;

import Command.nhacungcapCommand;
import org.example.service.nhacungcapService;
import org.example.serviecimpl.nhacungcapServiceImpl;

public class nhacungcapCommon {
    private static nhacungcapService service1 = new nhacungcapServiceImpl();
    private static nhacungcapCommand nhacungcapCommand = new nhacungcapCommand();
    public static nhacungcapCommand ViewsNCC(){
        nhacungcapCommand.setNhacungcapDTOList(service1.findall());
        return nhacungcapCommand;
    }
}
