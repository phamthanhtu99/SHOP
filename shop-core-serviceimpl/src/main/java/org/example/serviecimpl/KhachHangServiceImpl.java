package org.example.serviecimpl;

import org.example.core.dao.KhachHangDao;
import org.example.core.daoimpl.KhachHangDaoImpl;
import org.example.core.dto.KhachHangDTO;
import org.example.core.dto.hoadonDTO;
import org.example.persistence.data.KhachHangEntity;
import org.example.persistence.data.hoadonEntity;
import org.example.service.KhachHangService;
import org.example.utisl.hoadonBeanUtlis;
import org.example.utisl.khachHangBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {
    KhachHangDao dao = new KhachHangDaoImpl();
    public KhachHangDTO Kiemtranguoidung(KhachHangDTO dto) {
        KhachHangEntity entity = dao.CheckLoginKhachHang(dto.getEmail(),dto.getPassWord());
        return khachHangBeanUtils.entitysangdto(entity);
    }

    public boolean Checkemail(KhachHangDTO dto) {
        boolean ketqua;
        ketqua= dao.CheckEmial(dto.getEmail());
        if (ketqua==false){
            return false;
        }else
        return true;
    }

    public void save(KhachHangDTO dto) {
        KhachHangEntity entity=khachHangBeanUtils.dtosangentity(dto);
        dao.save(entity);
    }

    public void update(KhachHangDTO dto) {
        KhachHangEntity entity = khachHangBeanUtils.dtosangentity(dto);
        dao.updata(entity);
    }

    public KhachHangDTO timtheoid(KhachHangDTO dto) {
        KhachHangEntity entity = dao.findByID(dto.getId());
        return khachHangBeanUtils.entitysangdto(entity);
    }

    public List<KhachHangDTO> khachhang(String name, String sdt) {
        List<KhachHangEntity> khachHangEntityList = dao.viewskhach(name,sdt);
        List<KhachHangDTO>khachHangDTOS = new ArrayList<KhachHangDTO>();
        List<hoadonDTO> entities = new ArrayList<hoadonDTO>();
        for (KhachHangEntity entity :khachHangEntityList){
            KhachHangDTO dto = new KhachHangDTO();
            dto=khachHangBeanUtils.entitysangdto(entity);

            for (hoadonEntity entity1:entity.getHoadonEntities()){
                    hoadonDTO hoadonDTO= new hoadonDTO();
                    hoadonDTO= hoadonBeanUtlis.EntitysangDTO(entity1);
                    entities.add(hoadonDTO);
            }
            dto.setHoadonDTOS(entities);
            khachHangDTOS.add(dto);
        }
        return khachHangDTOS;
    }


}
