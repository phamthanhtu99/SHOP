package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.loaisanphamDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.loaisanphamEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class loaisanphamDaoImpl extends AbstracDao<Integer, loaisanphamEntity> implements loaisanphamDao {
    public List<loaisanphamEntity> theodanhmuccha(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<loaisanphamEntity> list = new ArrayList<loaisanphamEntity>();
        try {

            StringBuilder sql= new StringBuilder(" from ");
            sql.append(getPresistenceClass());
            sql.append(" Where danhmuccon ='"+id+"'");
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
