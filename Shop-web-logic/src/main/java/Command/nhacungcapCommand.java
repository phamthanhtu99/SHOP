package Command;

import command.AbstractCommand;
import org.example.core.dto.nhacungcapDTO;

import java.util.List;

public class nhacungcapCommand extends AbstractCommand<nhacungcapDTO> {
    private List<nhacungcapDTO> nhacungcapDTOList ;
    public nhacungcapCommand (){
        this.pojo=new nhacungcapDTO();
    }
    public List<nhacungcapDTO> getNhacungcapDTOList() {
        return nhacungcapDTOList;
    }

    public void setNhacungcapDTOList(List<nhacungcapDTO> nhacungcapDTOList) {
        this.nhacungcapDTOList = nhacungcapDTOList;
    }
}
