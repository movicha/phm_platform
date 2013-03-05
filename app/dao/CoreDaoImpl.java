package dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.User;
import models.UserType;
import play.db.jpa.JPA;

public class CoreDaoImpl implements CoreDao {

	@Override
	public boolean findUser(String username, String password, int userType) {
		// TODO Auto-generated method stub

		CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> user = query.from(User.class);
		Join<User,UserType> userT =
				user.join("userType");
		query.select(user);

		Predicate preUsername = cb.equal(user.get("username"),username); //Step 4
		Predicate prePassword=  cb.equal(user.get("password"),password); //Step 4
		Predicate preUsertype = cb.equal(userT.get("id"),userType);

		Predicate pAnd = cb.and(preUsername,prePassword,preUsertype); //Step 4
		query.where(pAnd);
		TypedQuery<User> userResult = JPA.em().createQuery(query);
		List<User> userRes = userResult.getResultList();
		
//		for(User us : userRes)
//		{
//			System.out.println(us.getPassword());
//		}
		if(userRes!=null&&userRes.size()>0)
			return true;
		else
			return false;

	}
	
	/**
	 * 
	    CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> user = query.from(User.class);
		TypedQuery<User> userResult = JPA.em().createQuery(query);
		List<User> userRes = userResult.getResultList();
	 */

}
