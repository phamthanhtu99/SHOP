package org.example.core.daoimpl;

import org.example.core.dao.chucvuDao;
import org.example.core.data.DaoImpl.AbstracDao;
import org.example.persistence.data.ChucVuEntity;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Id;

public class chucvuDaoImpl extends AbstracDao<Integer, ChucVuEntity> implements chucvuDao {
}
