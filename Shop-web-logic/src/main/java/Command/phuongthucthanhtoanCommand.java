package Command;

import command.AbstractCommand;
import org.example.core.dto.phuongthucthanhtoanDTO;

import java.util.List;

public class phuongthucthanhtoanCommand extends AbstractCommand<phuongthucthanhtoanDTO> {
    private List<phuongthucthanhtoanDTO> phuongthucthanhtoanDTOS;

    public List<phuongthucthanhtoanDTO> getPhuongthucthanhtoanDTOS() {
        return phuongthucthanhtoanDTOS;
    }

    public void setPhuongthucthanhtoanDTOS(List<phuongthucthanhtoanDTO> phuongthucthanhtoanDTOS) {
        this.phuongthucthanhtoanDTOS = phuongthucthanhtoanDTOS;
    }
}
