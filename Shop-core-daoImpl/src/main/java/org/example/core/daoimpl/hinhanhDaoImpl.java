package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.binhluanDao;
import org.example.core.dao.hinhanhDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.binhluanEntity;
import org.example.persistence.data.hinhanhEntity;
import org.example.persistence.data.loaisanphamEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class hinhanhDaoImpl   extends AbstracDao<Integer, hinhanhEntity> implements hinhanhDao {
    public List<hinhanhEntity> hinhanhtheosanpham(String sanpham) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<hinhanhEntity> list = new ArrayList<hinhanhEntity>();
        try {
            StringBuilder sql= new StringBuilder(" from ");
            sql.append(getPresistenceClass());
            sql.append(" Where sanpham ='"+sanpham+"'");
            Query query = session.createQuery(sql.toString());
            list=query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return list ;
    }
}
