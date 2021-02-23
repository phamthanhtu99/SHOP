package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.binhluanDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.core.dto.binhluanDTO;
import org.example.persistence.data.binhluanEntity;
import org.example.persistence.data.sanphamEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class binhluanDaoImpl  extends AbstracDao<Integer, binhluanEntity> implements binhluanDao {

    public List<binhluanEntity> BINHLUAN_DAOS(sanphamEntity SP) {
        List<binhluanEntity> list = new ArrayList<binhluanEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql=new StringBuilder("From binhluanEntity ue  where ue.sanphamEntity = :SP");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP",SP);
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

    public List<binhluanEntity> BINHLUAN_DAOS1(binhluanEntity SP) {
        List<binhluanEntity> list = new ArrayList<binhluanEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql=new StringBuilder("From binhluanEntity ue  where ue.sanphamEntity = :SP");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP",SP);
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
}
