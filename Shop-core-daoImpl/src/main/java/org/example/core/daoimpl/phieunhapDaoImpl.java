package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.chitetphieunhapDao;
import org.example.core.dao.phieunhapDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.nhanvienquanlyhoadonEntity;
import org.example.persistence.data.phieunhapEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class phieunhapDaoImpl extends AbstracDao<String, phieunhapEntity> implements phieunhapDao {
    public List<phieunhapEntity> viewphieunhap(String mapn, String ngaydau, String ngaynhapcuoi) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<phieunhapEntity> list = new ArrayList<phieunhapEntity>();
        try {
            StringBuilder sql = new StringBuilder("  FROM phieunhapEntity ue ");
            if (ngaydau!=null || ngaynhapcuoi!=null||mapn!=null){
                sql.append(" Where ");
            }
            if (ngaydau != null && ngaynhapcuoi != null) {
                sql.append(" DATE(ue.date) between '"+ngaydau+"'  and '"+ngaynhapcuoi+"'");
            } else if (ngaydau != null) {
                sql.append("  DATE(ue.date) = '"+ngaydau+"'");
            }
           if (mapn!=null && ngaydau!=null){
                sql.append(" and ue.id ='"+mapn+"'");
            }else if (mapn!=null){
               sql.append(" ue.id ='"+mapn+" '");
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

    public List<phieunhapEntity> stnhap(String nam, String thang) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<phieunhapEntity> list = new ArrayList<phieunhapEntity>();
        try {
            StringBuilder sql = new StringBuilder("  FROM phieunhapEntity ");
            if (nam!=null){
                sql.append(" Where  month(ngaynhap) ='"+thang+"' AND Year(ngaynhap)='"+nam+"' ");
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
