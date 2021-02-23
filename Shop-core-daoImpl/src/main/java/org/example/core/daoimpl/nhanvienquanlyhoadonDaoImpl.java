package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.nhanvienquanlyhoadonDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.hoadonEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class nhanvienquanlyhoadonDaoImpl extends AbstracDao<Integer, nhanvienquanlyhoadonEntity> implements nhanvienquanlyhoadonDao {


    public List<nhanvienquanlyhoadonEntity> quanlyhoadin(String hoadon, String ngaydau, String ngaycuoi, String id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<nhanvienquanlyhoadonEntity> list = new ArrayList<nhanvienquanlyhoadonEntity>();
        try {
            StringBuilder sql = new StringBuilder(" SELECT DISTINCT  ue  FROM nhanvienquanlyhoadonEntity ue ,hoadonEntity  hd ");
            if (hoadon != null || ngaydau != null || ngaycuoi != null || id != null) {
                sql.append(" where ue.hoadonEntity=hd.id");
            }
            if (ngaydau != null && ngaycuoi != null) {
                sql.append(" and date(hd.ngaymua) between'" + ngaydau + "' and '" + ngaycuoi + "' ");
            } else if (ngaydau != null) {
                sql.append(" and DATE(hd.ngaymua) = '" + ngaydau + "'");
            }
            if (id != null && ngaydau != null) {
                sql.append(" and ue.nhanVienEntity = '" + id + "'");
            } else if (id != null) {
                sql.append(" and ue.nhanVienEntity = '" + id + "'");
            }
            if (hoadon != null && id != null && ngaydau != null) {
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            } else if (hoadon!=null){
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            }

            Query query = session.createQuery(sql.toString());
            Object i =null;
            list=query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }
    public List<nhanvienquanlyhoadonEntity> danhthu(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien) {
        List<nhanvienquanlyhoadonEntity> list = new ArrayList<nhanvienquanlyhoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder(" SELECT DISTINCT  ue  FROM nhanvienquanlyhoadonEntity ue ,hoadonEntity  hd ,chitiethoadonEntity ct");
            sql.append(" where ue.hoadonEntity=hd.id and hd.id=ct.hoadonEntity ");
            if (ngaymua != null && ngaycuoi != null) {
                sql.append(" and date(hd.ngaymua) between'" + ngaymua + "' and '" + ngaycuoi + "' ");
            } else if (ngaymua != null) {
                sql.append(" and DATE(hd.ngaymua) = '" + ngaymua + "'");
            }
            if (idnhanvien != null && ngaymua != null) {
                sql.append(" and ue.nhanVienEntity = '" + idnhanvien + "'");
            } else if (idnhanvien != null) {
                sql.append(" and ue.nhanVienEntity = '" + idnhanvien + "'");
            }
            if (hoadon != null && idnhanvien != null && ngaymua != null) {
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            } else if (hoadon!=null){
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            }else if (sanpham!=null){
                sql.append(" and ct.sanphamEntity ='"+sanpham+"'");
            }
            sql.append(" and hd.tinhtrangEntity = '7'");
            Query query = session.createQuery(sql.toString());
            list=query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }

    public List<nhanvienquanlyhoadonEntity> danhthusanpham(String thang , String nam) {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            List<nhanvienquanlyhoadonEntity> list = new ArrayList<nhanvienquanlyhoadonEntity>();
            try {
                StringBuilder sql = new StringBuilder(" SELECT DISTINCT  ue  FROM nhanvienquanlyhoadonEntity ue ,hoadonEntity  hd ,chitiethoadonEntity ct");
                sql.append(" where ue.hoadonEntity=hd.id and hd.id=ct.hoadonEntity ");
                if (thang !=null){
                    sql.append(" and month(ngaygiao)='"+thang+"'");
                }
                if (nam !=null){
                    sql.append(" and Year(ngaygiao)='"+nam+"'");
                }
                Query query= session.createQuery(sql.toString());
                list=query.list();
                transaction.commit();
            }catch (HibernateException e){
                transaction.rollback();
                throw  e;

            } finally {
                session.close();
            }
            return list;


    }

    public nhanvienquanlyhoadonEntity timtheohd(hoadonEntity entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        nhanvienquanlyhoadonEntity entity1 =new nhanvienquanlyhoadonEntity();
        try {
            StringBuilder sql = new StringBuilder(" SELECT DISTINCT  ue  FROM nhanvienquanlyhoadonEntity ue where ue.hoadonEntity= '"+entity.getId()+"' ");
            Query query= session.createQuery(sql.toString());
            entity1= (nhanvienquanlyhoadonEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;

        } finally {
            session.close();
        }
        return entity1;
    }

    public List<nhanvienquanlyhoadonEntity> quanlysanpham(String ngaymua, String ngaycuoi, String hoadon, String sanpham, String idnhanvien, String tinhtrang) {
        List<nhanvienquanlyhoadonEntity> list = new ArrayList<nhanvienquanlyhoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder(" SELECT DISTINCT  ue  FROM nhanvienquanlyhoadonEntity ue ,hoadonEntity  hd ,chitiethoadonEntity ct");
            sql.append(" where ue.hoadonEntity=hd.id and hd.id=ct.hoadonEntity ");
            if (ngaymua != null && ngaycuoi != null) {
                sql.append(" and date(hd.ngaymua) between'" + ngaymua + "' and '" + ngaycuoi + "' ");
            } else if (ngaymua != null) {
                sql.append(" and DATE(hd.ngaymua) = '" + ngaymua + "'");
            }
            if (idnhanvien != null && ngaymua != null) {
                sql.append(" and ue.nhanVienEntity = '" + idnhanvien + "'");
            } else if (idnhanvien != null) {
                sql.append(" and ue.nhanVienEntity = '" + idnhanvien + "'");
            }
            if (hoadon != null && idnhanvien != null && ngaymua != null) {
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            } else if (hoadon!=null){
                sql.append(" and ue.hoadonEntity ='" + hoadon + "'");
            }else if (sanpham!=null){
                sql.append(" and ct.sanphamEntity ='"+sanpham+"'");
            }
            if (tinhtrang!=null){
                sql.append(" and hd.tinhtrangEntity = '" + tinhtrang + "'");
            }
            Query query = session.createQuery(sql.toString());
            Object i =null;
            list=query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }

}
