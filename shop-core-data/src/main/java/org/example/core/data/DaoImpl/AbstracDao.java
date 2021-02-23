package org.example.core.data.DaoImpl;

import org.apache.commons.lang.StringUtils;
import org.example.core.comon.utils.HibernateUtils;
import org.example.core.data.Dao.GenericDao;
import org.hibernate.*;
import sun.rmi.transport.tcp.TCPTransport;


import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstracDao <ID extends Serializable,T> implements GenericDao<ID,T> {

    private  Class<T>presistenceClass;
    public  AbstracDao(){
        this.presistenceClass= (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public  String getPresistenceClass(){
        return presistenceClass.getSimpleName();
    }
    public List<T> Finall() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<T> list = new ArrayList<T>();
        try {

            StringBuilder sql= new StringBuilder(" from ");
            sql.append(getPresistenceClass());
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

    public T updata(T entity) {
        T resut =null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object =session.merge(entity);
            resut = (T) object;
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
             throw e;
        }
        return resut;
    }

    public T save(T entity) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e ){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return entity;
    }

    public T checklogin1(String Email,String password) {

        String table = getPresistenceClass();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T  t = (T) getPresistenceClass();
        try {

            StringBuilder sql = new StringBuilder("FROM "+table+" ue WHERE ue.email= :email AND Password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("email",Email);
            query.setParameter("password",password);
            t= (T) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;

        }
        finally {
            session.close();
        }
        return t;

    }

    public Object[] FindByproprety(Integer offset, Integer limit,String seach,String loaisanpham) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<T> list =new ArrayList<T>();
        Object totalItems =0;
        try {
               StringBuilder sql1= new StringBuilder("From ").append(getPresistenceClass());
               Query query1 = session.createQuery(sql1.toString());
                totalItems= query1.list().size();
                if (offset!=null && limit!=null && offset>=0 && limit >=0){
                    StringBuilder sql =new StringBuilder("from ");
                    sql.append(getPresistenceClass());
                    if (StringUtils.isNotBlank(seach)) {
                        sql.append(" where TenSP LIKE '%"+seach+"%' ");
                    }else if (StringUtils.isNotBlank(loaisanpham)){
                        sql.append(" where Loaisanpham LIKE '%"+loaisanpham+"%' ");
                    }else {
                        sql.append(" order by rand() ");
                    }

                    Query query = session.createQuery(sql.toString());

                        query.setFirstResult(offset);
                        query.setMaxResults(limit);

                    list= query.list();
                }

                transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
        return new Object[]{totalItems,list};
    }
    public T findByID(ID id) {
        T result= null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
          result = (T) session. get(presistenceClass, id);
            if(result ==null){
                throw  new ObjectNotFoundException("not found"+id,null);
            }

        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
        return result;
    }

    public T ID(ID id) {
        T result= null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session. get(presistenceClass, id);

        }catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
        return result;
    }

    public boolean detele(ID entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            T t = (T) session.get(presistenceClass,entity);
            session.delete(t);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw  e;

        }
        return true;
    }


}
