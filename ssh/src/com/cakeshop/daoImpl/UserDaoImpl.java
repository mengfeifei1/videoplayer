package com.cakeshop.daoImpl;
 
import java.util.List;
 

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cakeshop.bean.UserBean;
import com.cakeshop.dao.UserDao;
 

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public UserBean findPerPerson(int userid) {
		// TODO Auto-generated method stub
		String hql="from UserBean where userId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0,userid);
		List<UserBean> userList=query.list();
		UserBean currentUser=null;
		if(userList!=null&&userList.size()>0) {
			currentUser=userList.get(0);
		}
		return currentUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean findUserByUserTel(String userTelephone) {
		// TODO Auto-generated method stub
		String hql="from UserBean where userTelephone=?";
		Query query=getSession().createQuery(hql);
		
		query.setParameter(0, userTelephone);
		List<UserBean> userList=query.list();
		System.out.print(userList.size());
		UserBean currentUser=null;
		if(userList!=null&&userList.size()>0) {
			currentUser=userList.get(0);
		}
		return currentUser;
	}

	@Override
	public int insertUser(UserBean user) {
		// TODO Auto-generated method stub
		return (int) getSession().save(user);
	}

	@Override
	public UserBean findUserByUserPhone(String userTelephone) {
		// TODO Auto-generated method stub
		UserBean user=new UserBean();
		String hql="from UserBean where userTelephone=?";
		Query query=getSession().createQuery(hql);
		query.setString(0, userTelephone);
		user=(UserBean) query.list().get(0);
		System.out.print(user);
		return user;
	}

	@Override
	public void changeUserPswd(UserBean user) {
		// TODO Auto-generated method stub
		
		Query query = getSession().createQuery("update UserBean user set user.userPassword = ? where id = ?");
		query.setString(0, user.getUserPassword());
		query.setInteger(1, user.getUserId());
		query.executeUpdate();
		return;
	}

	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		Query query = getSession()
				.createQuery("update UserBean user set user.userName =?"
						+ ", userAddress=?"
						+ ",userSex=?"
						+ ",userIntro=?"
						+ ",userBirth=?"
						+ "where userId = ?");
		query.setString(0, user.getUserName());
		query.setString(1, user.getUserAddress());
		query.setString(2, user.getUserSex());
		query.setString(3,user.getUserIntro());
		query.setString(4, user.getUserBirth());
		query.setInteger(5, user.getUserId());
		query.executeUpdate();
		return;
		
	}

	@Override
	public void updateUserPhoto(UserBean user) {
		// TODO Auto-generated method stub
		Query query = getSession()
				.createQuery("update UserBean user set user.userPhoto =?"
						+ "where userId = ?");
		query.setString(0, user.getUserPhoto());
		query.setInteger(1, user.getUserId());
		query.executeUpdate();
		return;
	}

	

	

}
