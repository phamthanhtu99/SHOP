package org.example.serviecimpl;

import org.example.core.dao.phieunhapDao;
import org.example.core.daoimpl.phieunhapDaoImpl;
import org.example.core.dto.phieunhapDTO;
import org.example.persistence.data.phieunhapEntity;
import org.example.service.phieunhapServiec;
import org.example.utisl.phieunhapBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class phieunhapServiceIpml implements phieunhapServiec {
    phieunhapDao phieunhapDao =new phieunhapDaoImpl();
    public void savephieunhap(phieunhapDTO dto) {
        phieunhapEntity phieunhapEntity = phieunhapBeanUtils.dtosangEntity(dto);
        phieunhapDao.save(phieunhapEntity);
    }

    public List<phieunhapDTO> PHIEUNHAP_DTOS() {
        List<phieunhapEntity> phieunhapEntities = phieunhapDao.Finall();
        List<phieunhapDTO> phieunhapDTOS =new ArrayList<phieunhapDTO>();
        for (phieunhapEntity phieunhapEntity : phieunhapEntities){
            phieunhapDTO phieunhapDTO= new phieunhapDTO();
            phieunhapDTO=phieunhapBeanUtils.Entitysangdto(phieunhapEntity);
            phieunhapDTOS.add(phieunhapDTO);
        }
        return phieunhapDTOS;
    }

    public List<phieunhapDTO> viewphieunhapDTO(String mapn, String ngaydau, String ngaycuoi) {
        List<phieunhapEntity> phieunhapEntities = phieunhapDao.viewphieunhap(mapn,ngaydau,ngaycuoi);
        List<phieunhapDTO> phieunhapDTOS =new ArrayList<phieunhapDTO>();
        for (phieunhapEntity phieunhapEntity : phieunhapEntities){
            phieunhapDTO phieunhapDTO= new phieunhapDTO();
            phieunhapDTO=phieunhapBeanUtils.Entitysangdto(phieunhapEntity);
            phieunhapDTOS.add(phieunhapDTO);
        }
        return phieunhapDTOS;
    }

    public phieunhapDTO timtheoid(String id) {
        phieunhapDTO phieunhapDTO = phieunhapBeanUtils.Entitysangdto(phieunhapDao.findByID(id));
        return phieunhapDTO;
    }

    public List<phieunhapDTO> stnhap(String nam, String thang) {
        List<phieunhapEntity> phieunhapEntities = phieunhapDao.stnhap(nam,thang);
        List<phieunhapDTO> phieunhapDTOS =new ArrayList<phieunhapDTO>();
        for (phieunhapEntity phieunhapEntity : phieunhapEntities){
            phieunhapDTO phieunhapDTO= new phieunhapDTO();
            phieunhapDTO=phieunhapBeanUtils.Entitysangdto(phieunhapEntity);
            phieunhapDTOS.add(phieunhapDTO);
        }
        return phieunhapDTOS;
    }
}
