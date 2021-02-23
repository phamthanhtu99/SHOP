package org.example.serviecimpl;

import org.example.core.dao.chitetphieunhapDao;
import org.example.core.daoimpl.chitietphieunhapImpl;
import org.example.core.dto.chitietphieunhapDTO;
import org.example.core.dto.phieunhapDTO;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.service.chitietnhapService;
import org.example.utisl.chitietphieunhapBeaUtils;
import org.example.utisl.phieunhapBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class chitietphieunhaoServiceImpl implements chitietnhapService {
    chitetphieunhapDao chitetphieunhapDao = new chitietphieunhapImpl();
    chitietphieunhapEntity entity =  new chitietphieunhapEntity();
    public void saveCtphieunhap(chitietphieunhapDTO dto) {
        chitietphieunhapEntity entity = chitietphieunhapBeaUtils.dtosangEntity(dto);
        chitetphieunhapDao.save(entity);
    }

    public List<chitietphieunhapDTO> CHITIETPHIEUNHAPall() {
        List<chitietphieunhapEntity>chitietphieunhapEntities=chitetphieunhapDao.Finall();
        List<chitietphieunhapDTO> chitietphieunhapDTOS = new ArrayList<chitietphieunhapDTO>();
        for (chitietphieunhapEntity entity :chitietphieunhapEntities){
            chitietphieunhapDTO dto = new chitietphieunhapDTO();
            dto = chitietphieunhapBeaUtils.Entitysangdto(entity);
            chitietphieunhapDTOS.add(dto);
        }

        return chitietphieunhapDTOS;
    }

    public List<chitietphieunhapDTO> CHITIETPHIEUNHAP_DTO(phieunhapDTO dto) {
        List<chitietphieunhapEntity>chitietphieunhapEntities=chitetphieunhapDao.CHITIETPHIEUNHAP_phieunhap(phieunhapBeanUtils.dtosangEntity(dto));
        List<chitietphieunhapDTO> chitietphieunhapDTOS = new ArrayList<chitietphieunhapDTO>();
        for (chitietphieunhapEntity entity : chitietphieunhapEntities){
            chitietphieunhapDTO chitietphieunhapDTO = new chitietphieunhapDTO();
            chitietphieunhapDTO=chitietphieunhapBeaUtils.Entitysangdto(entity);
            chitietphieunhapDTOS.add(chitietphieunhapDTO);
        }
        return chitietphieunhapDTOS;
    }



}
