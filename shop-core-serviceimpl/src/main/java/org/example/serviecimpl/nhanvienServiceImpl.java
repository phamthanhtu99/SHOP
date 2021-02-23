package org.example.serviecimpl;

import org.example.core.dao.nhanvienDao;
import org.example.core.daoimpl.NhanVienDaoImpl;
import org.example.core.dto.nhanvienDTO;
import org.example.persistence.data.NhanVienEntity;
import org.example.service.nhanvienService;
import org.example.utisl.nhanvienBeanUtils;

import java.util.ArrayList;
import java.util.List;

public class nhanvienServiceImpl  implements nhanvienService {
    nhanvienDao nhanvienDao = new NhanVienDaoImpl();
    NhanVienEntity entity = new NhanVienEntity();
    public nhanvienDTO Kiemtranguoidung(nhanvienDTO dto) {
        NhanVienEntity entity = nhanvienDao.checklogin(dto.getEmail(),dto.getPassWord());
        return nhanvienBeanUtils.EntitysangDTO(entity);
    }

    public List<nhanvienDTO> viewsnhanvien() {
        List<NhanVienEntity> nhanVienEntities = nhanvienDao.Finall();
        List<nhanvienDTO> dtos = new ArrayList<nhanvienDTO>();
        for (NhanVienEntity entity : nhanVienEntities){
         nhanvienDTO  dto =nhanvienBeanUtils.EntitysangDTO(entity);
         dtos.add(dto);
        }
        return dtos;
    }

    public nhanvienDTO nhanvientheoID(nhanvienDTO id) {
        NhanVienEntity entity = nhanvienBeanUtils.dtosangEnityt(id);
        entity= nhanvienDao.findByID(entity.getId());
        id= nhanvienBeanUtils.EntitysangDTO(entity);
        return id;
    }

    public void save(nhanvienDTO dto) {

        entity =nhanvienBeanUtils.dtosangEnityt(dto);
        nhanvienDao.save(entity);
    }

    public void updatenhanvien(nhanvienDTO dto) {
        entity=nhanvienBeanUtils.dtosangEnityt(dto);
        nhanvienDao.updata(entity);
    }

    public boolean detele(Integer dto) {
        nhanvienDTO nhanvienDTO = new nhanvienDTO();
        nhanvienDTO.setId(dto);
        entity=nhanvienBeanUtils.dtosangEnityt(nhanvienDTO);
        if (nhanvienDao.detele(entity.getId())){
            return true;
        }
        return false;
    }
}

