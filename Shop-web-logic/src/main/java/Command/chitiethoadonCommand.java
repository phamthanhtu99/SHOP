package Command;

import command.AbstractCommand;
import org.example.core.dto.chitiethoadonDTO;
import org.example.core.dto.hoadonDTO;

import java.util.List;

public class chitiethoadonCommand extends AbstractCommand<chitiethoadonDTO> {
    private List<chitiethoadonDTO> chitiethoadonDTOS ;
    private String Mahodon;
    private  hoadonDTO hoadonDTO;
    public org.example.core.dto.hoadonDTO getHoadonDTO() {
        return hoadonDTO;
    }

    public void setHoadonDTO(org.example.core.dto.hoadonDTO hoadonDTO) {
        this.hoadonDTO = hoadonDTO;
    }

    public String getMahodon() {
        return Mahodon;
    }

    public void setMahodon(String mahodon) {
        Mahodon = mahodon;
    }

    public List<chitiethoadonDTO> getChitiethoadonDTOS() {
        return chitiethoadonDTOS;
    }

    public void setChitiethoadonDTOS(List<chitiethoadonDTO> chitiethoadonDTOS) {
        this.chitiethoadonDTOS = chitiethoadonDTOS;
    }
}
