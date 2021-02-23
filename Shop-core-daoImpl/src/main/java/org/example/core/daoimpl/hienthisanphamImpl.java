package org.example.core.daoimpl;

import org.example.core.comon.utils.HibernateUtils;
import org.example.core.dao.hienthisanpham;
import org.example.core.dao.phieunhapDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.chitietphieunhapEntity;
import org.example.persistence.data.phieunhapEntity;
import org.example.persistence.data.sanphamEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class hienthisanphamImpl extends AbstracDao<String, chitietphieunhapEntity> implements hienthisanpham {
    public List<chitietphieunhapEntity> Xe(int offset, int limit, String seach, String loaixe) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<chitietphieunhapEntity> list = new ArrayList<chitietphieunhapEntity>();
        try {
            StringBuilder sql = new StringBuilder("Select ct  FROM chitietphieunhapEntity ct,sanphamEntity sp,loaisanphamEntity lsp ");
            sql.append(" where sp.Id =ct.sanphamEntity and sp.loaisanpham=lsp.id and lsp.danhmuccon = '12'");
            if(seach!=null){
                sql.append(" and sp.tensp like '%"+seach+"%'");
            }
            if (loaixe!=null){
                sql.append(" and lsp = '"+loaixe+"'");
            }
            Query query = session.createQuery(sql.toString());
            query.setFirstResult(offset);
            query.setMaxResults(limit);
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
