package Command;

import command.AbstractCommand;
import org.example.core.dto.KhachHangDTO;

import java.util.List;

public class KhachHangCommand  extends AbstractCommand<KhachHangDTO> {
    private String confirmpassword;
    private String name;
    private String password1;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KhachHangCommand(){
        this.pojo= new KhachHangDTO();
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}