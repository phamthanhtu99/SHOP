package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.hoadonDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.core.dto.KhachHangDTO;
import org.example.persistence.data.KhachHangEntity;
import org.example.persistence.data.hoadonEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class hoadonDaoImpl extends AbstracDao<String, hoadonEntity> implements hoadonDao {
    public List<hoadonEntity> HOADON_khachang(KhachHangEntity dto) {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.khachHangEntity = :SP AND tinhtrangEntity = 7");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP", dto);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }
    public List<hoadonEntity> lichsuda1(KhachHangEntity dto,String tinhtrang) {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.khachHangEntity = :SP and ue.tinhtrangEntity ='"+tinhtrang+"'  ORDER BY ue.ngaymua , MONTH(ue.ngaymua)");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP", dto);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }

    public List<hoadonEntity> dhchuaxacnhan(KhachHangEntity dto) {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.khachHangEntity = :SP and ue.tinhtrangEntity =  1  ORDER BY ue.ngaymua , MONTH(ue.ngaymua)");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP", dto);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }

    public List<hoadonEntity> hoadon() {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.tinhtrangEntity = 1");
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }

    public List<hoadonEntity> quanlyhoadon(String ngaymua, String mahoadon) {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder(" From hoadonEntity ue ");

            if (ngaymua != null || mahoadon != null) {
                sql.append(" where ");
            }
            if (ngaymua != null) {
                sql.append(" DATE(ue.ngaymua) = '" + ngaymua + "'");
            }
            if (mahoadon != null & ngaymua != null) {
                sql.append(" and ");
            }
            if (mahoadon != null) {
                sql.append("ue.id = :HD");
            }
            Query query = session.createQuery(sql.toString());
            query.setParameter("HD", mahoadon);
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        return list;
    }

    public List<hoadonEntity> giaohang() {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.tinhtrangEntity = 4");
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }

    public List<hoadonEntity> thongke() {
        List<hoadonEntity> list = new ArrayList<hoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("From hoadonEntity ue  where ue.tinhtrangEntity = 7");
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;

        } finally {
            session.close();
        }
        return list;
    }

}
