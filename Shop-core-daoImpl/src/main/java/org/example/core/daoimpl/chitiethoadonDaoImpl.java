package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.binhluanDao;
import org.example.core.dao.chitiethoadonDao;
import org.example.core.dao.chucvuDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public class chitiethoadonDaoImpl  extends AbstracDao<Integer, chitiethoadonEntity> implements chitiethoadonDao {
    public List<chitiethoadonEntity> CHITIETHOADON_ENTITIES(hoadonEntity hoadonEntity) {
        List<chitiethoadonEntity> list = new ArrayList<chitiethoadonEntity>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql=new StringBuilder("From chitiethoadonEntity ue  where ue.hoadonEntity = :SP");
            Query query = session.createQuery(sql.toString());
            query.setParameter("SP",hoadonEntity);
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
