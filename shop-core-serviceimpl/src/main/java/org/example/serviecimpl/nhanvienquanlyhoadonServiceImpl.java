package org.example.serviecimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.nhanvienquanlyhoadonDao;
import org.example.core.daoimpl.nhanvienquanlyhoadonDaoImpl;
import org.example.core.dto.*;
import org.example.persistence.data.chitiethoadonEntity;
import org.example.persistence.data.hoadonEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;
import org.example.persistence.data.sanphamEntity;
import org.example.service.nhanvienquanlyhoadonService;
import org.example.utisl.chitiethoadonBeanUtisl;
import org.example.utisl.hoadonBeanUtlis;
import org.example.utisl.nhanvienBeanUtils;
import org.example.utisl.nhanvienquanlyhoadonBeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nhanvienquanlyhoadonServiceImpl implements nhanvienquanlyhoadonService {
    nhanvienquanlyhoadonDao nhanvienquanlyhoadonDao = new nhanvienquanlyhoadonDaoImpl();
    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);


    public void savenhanvienquanlyhoadon(hoadonDTO hoadonDTO, nhanvienDTO dto) {
        nhanvienquanlyhoadonEntity nhanvienquanlyhoadonEntity = new nhanvienquanlyhoadonEntity();
        nhanvienquanlyhoadonEntity.setHoadonEntity(hoadonBeanUtlis.dtosangEnityt(hoadonDTO));
        nhanvienquanlyhoadonEntity.setNhanVienEntity(nhanvienBeanUtils.dtosangEnityt(dto));
        nhanvienquanlyhoadonEntity.setNgaythuchien(date);
        nhanvienquanlyhoadonEntity.setId(null);
        nhanvienquanlyhoadonDao.save(nhanvienquanlyhoadonEntity);
    }

    public List<nhanvienquanlyhoadonDTO> views(String hoadon, String ngaydau, String ngaycuoi, String id) {

        List<nhanvienquanlyhoadonEntity> nhanvienquanlyhoadonEntities = nhanvienquanlyhoadonDao.quanlyhoadin(hoadon, ngaydau, ngaycuoi, id);
        List<nhanvienquanlyhoadonEntity> tg = new ArrayList<org.example.persistence.data.nhanvienquanlyhoadonEntity>();
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonDTOS = new ArrayList<nhanvienquanlyhoadonDTO>();

        for (nhanvienquanlyhoadonEntity entity : nhanvienquanlyhoadonEntities) {
            nhanvienquanlyhoadonDTO dto = new nhanvienquanlyhoadonDTO();
            dto = nhanvienquanlyhoadonBeanUtils.entitysandto(entity);
            nhanvienquanlyhoadonDTOS.add(dto);
        }

        return nhanvienquanlyhoadonDTOS;
    }

    public List<nhanvienquanlyhoadonDTO> danhthu(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien) {
        List<nhanvienquanlyhoadonEntity> hoadonEntities = nhanvienquanlyhoadonDao.danhthu(ngaymua, ngaycuoi, hoadon, sanpham, idnhanvien);
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonDTOS = new ArrayList<nhanvienquanlyhoadonDTO>();

        for (nhanvienquanlyhoadonEntity entity : hoadonEntities) {
            nhanvienquanlyhoadonDTO nhanvienquanlyhoadonDTO = new nhanvienquanlyhoadonDTO();
            nhanvienquanlyhoadonDTO = nhanvienquanlyhoadonBeanUtils.entitysandto(entity);
            List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<chitiethoadonDTO>();
            for (chitiethoadonEntity entity1 : entity.getHoadonEntity().getChitiethoadonEntities()) {
                chitiethoadonDTO dto = new chitiethoadonDTO();
                dto = chitiethoadonBeanUtisl.entitysangDTo(entity1);
                chitiethoadonDTOS.add(dto);
            }
            nhanvienquanlyhoadonDTO.getHoadonDTO().setChitiethoadonDTOS(chitiethoadonDTOS);
            nhanvienquanlyhoadonDTO.setDtos(chitiethoadonDTOS);
            nhanvienquanlyhoadonDTOS.add(nhanvienquanlyhoadonDTO);

        }
        return nhanvienquanlyhoadonDTOS;
    }

    public List<nhanvienquanlyhoadonDTO> quanlysanpham(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien, String tinhtrang) {
        List<nhanvienquanlyhoadonEntity> hoadonEntities = nhanvienquanlyhoadonDao.quanlysanpham(ngaymua, ngaycuoi, hoadon, sanpham, idnhanvien,tinhtrang);
        List<nhanvienquanlyhoadonDTO> nhanvienquanlyhoadonDTOS = new ArrayList<nhanvienquanlyhoadonDTO>();
        for (nhanvienquanlyhoadonEntity entity : hoadonEntities) {
            nhanvienquanlyhoadonDTO nhanvienquanlyhoadonDTO = new nhanvienquanlyhoadonDTO();
            nhanvienquanlyhoadonDTO = nhanvienquanlyhoadonBeanUtils.entitysandto(entity);
            List<chitiethoadonDTO> chitiethoadonDTOS = new ArrayList<chitiethoadonDTO>();
            for (chitiethoadonEntity entity1 : entity.getHoadonEntity().getChitiethoadonEntities()) {
                chitiethoadonDTO dto = new chitiethoadonDTO();
                dto = chitiethoadonBeanUtisl.entitysangDTo(entity1);
                chitiethoadonDTOS.add(dto);
            }
            nhanvienquanlyhoadonDTO.getHoadonDTO().setChitiethoadonDTOS(chitiethoadonDTOS);
            nhanvienquanlyhoadonDTO.setDtos(chitiethoadonDTOS);
            nhanvienquanlyhoadonDTOS.add(nhanvienquanlyhoadonDTO);

        }
        return nhanvienquanlyhoadonDTOS;
    }

    public List<nhanvienquanlyhoadonDTO>  danhthusanpham(String thang ,String nam) {
        List<nhanvienquanlyhoadonEntity> hoadonEntities = nhanvienquanlyhoadonDao.danhthusanpham(thang, nam);
        List<nhanvienquanlyhoadonDTO> hoadonDTOS = new ArrayList<nhanvienquanlyhoadonDTO>();
        for (nhanvienquanlyhoadonEntity entity : hoadonEntities) {
            nhanvienquanlyhoadonDTO dto = new nhanvienquanlyhoadonDTO();
            dto = nhanvienquanlyhoadonBeanUtils.entitysandto(entity);
            hoadonDTOS.add(dto);

        }
        return hoadonDTOS;
    }

    public void update(nhanvienquanlyhoadonDTO nhanvienquanlyhoadonDTO) {
        nhanvienquanlyhoadonEntity entity= nhanvienquanlyhoadonDao.timtheohd(hoadonBeanUtlis.dtosangEnityt(nhanvienquanlyhoadonDTO.getHoadonDTO()));
        entity.setNgaygiao(date);
        nhanvienquanlyhoadonDao.updata(entity);
    }


}
