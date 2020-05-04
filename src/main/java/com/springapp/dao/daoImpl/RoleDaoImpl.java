package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.RoleDao;
import com.springapp.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {
    public Role getUserAccessRole(String role) {
        Criteria criteria = createEntityCriteria();
        return (Role) criteria.add(Restrictions.eq("name", role)).uniqueResult();
    }

    @Override
    public List<Role> getAllRoles() {
        Criteria criteria = createEntityCriteria();
        List<Role> roles =  criteria.list();
        return roles.subList(1, roles.size());
    }
}
