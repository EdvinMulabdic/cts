package com.springapp.dao.daoImpl;

import com.springapp.dao.AbstractDao;
import com.springapp.dao.AppUserDao;
import com.springapp.model.AppUser;
import com.springapp.model.EA14001;
import com.springapp.model.EA9001;
import com.springapp.model.Role;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class AppUserDaoImpl extends AbstractDao<Integer, AppUser> implements AppUserDao  {

    public AppUser findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_isActive = Restrictions.eq("isActive", true);
        Criterion criterion_email = Restrictions.eq("email", email);
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_isActive).add(criterion_email);
        return (AppUser) criteria.add(completeCriterion).uniqueResult();
    }

    public AppUser getUserById(Integer userId) {
        Criteria criteria = createEntityCriteria();
        return (AppUser) criteria.add(Restrictions.eq("id", userId)).uniqueResult();
    }

    /** retrieves all active users that are not admins **/
    public List<AppUser> getAllUsers() {
        Criteria criteria = createEntityCriteria();
        Criterion criterion_isActive = Restrictions.eq("isActive", true);
        Criterion criterion_role_id = Restrictions.ne("role.id", 1);
        Criterion completeCriterion = Restrictions.conjunction().add(criterion_isActive).add(criterion_role_id);
        return criteria.add(completeCriterion).list();
    }

    /** retrieves all ea codes for user **/
    public List<EA9001> getAllEA9001FromUser(Integer userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", userId));
        AppUser appUser = (AppUser) criteria.uniqueResult();
        return appUser.getEa9001List();
    }

    public List<EA14001> getAllEA14001FromUser(Integer userId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", userId));
        AppUser appUser = (AppUser) criteria.uniqueResult();
        return appUser.getEa14001List();
    }


    /** method for creating user **/
    public Boolean createUser(String name, String address, String city, String email, String phone, String qualifications, Role role, String password, List<EA9001> ea9001, List<EA14001> ea14001) {
        AppUser appUser = new AppUser();
        appUser.setName(name);
        appUser.setAddress(address);
        appUser.setCity(city);
        appUser.setEmail(email);
        appUser.setPhone(phone);
        appUser.setQualifications(qualifications);
        appUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        appUser.setIsActive(true);
        appUser.setRole(role);
        if(ea9001.size() > 0)
            appUser.setEa9001List(ea9001);
        if(ea14001.size() > 0)
            appUser.setEa14001List(ea14001);
        return  save_update(appUser);
    }

    /** method for updating user **/
    public Boolean updateUser(String name, String address, String city, String email, String phone, String qualifications, Role role, String password, List<EA9001> ea9001, List<EA14001> ea14001, String userId) {
        AppUser appUser = getUserById(Integer.parseInt(userId));
        appUser.setName(name);
        appUser.setAddress(address);
        appUser.setCity(city);
        appUser.setEmail(email);
        appUser.setPhone(phone);
        appUser.setQualifications(qualifications);
        appUser.setRole(role);
        appUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        appUser.setEa9001List(ea9001);
        appUser.setEa14001List(ea14001);
        return update(appUser);
    }

    /** method for deleting user **/
    public Boolean deleteUser(Integer userId) {
        AppUser appUser = getUserById(userId);
        appUser.setIsActive(false);
        return update(appUser);
    }

    @Override
    public AppUser doesUserWithEmailExist(String email) {
        Criteria criteria = createEntityCriteria();
        return (AppUser) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public List<AppUser> getAllAuditUsers() {
        List<Integer> idList = new ArrayList<>();
        idList.add(2);
        idList.add(6);
        Criteria criteria = createEntityCriteria();
        Criterion criterion_isActive = Restrictions.eq("isActive", true);
        Criterion criterion_role_id_audit = Restrictions.in("role.id", idList);

        Criterion completeCriterion = Restrictions.conjunction().add(criterion_isActive).add(criterion_role_id_audit);
        return criteria.add(completeCriterion).list();
    }
}
