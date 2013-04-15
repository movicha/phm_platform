package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import models.PatientUser;
import models.User;
import models.UserType;
import models.Visit;
import play.db.jpa.JPA;

public class CoreDaoImpl implements CoreDao {

	@Override
	public List<User> findUser(String username, String password, int userType) {
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
//		if(userRes!=null&&userRes.size()>0)
//			return true;
//		else
//			return false;
		
		return userRes;

	}
	
	/**
	 * 
	    CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> user = query.from(User.class);
		TypedQuery<User> userResult = JPA.em().createQuery(query);
		List<User> userRes = userResult.getResultList();
	 */
	
	@Override
	public List<PatientUser> findPatientByUserId(Integer userId)
	{
		CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
		CriteriaQuery<PatientUser> query = cb.createQuery(PatientUser.class);
		Root<PatientUser> user = query.from(PatientUser.class);
		query.select(user);

		Predicate preUsername = cb.equal(user.get("user"),userId); //Step 4
		Predicate pAnd = cb.and(preUsername); //Step 4
		query.where(pAnd);
		TypedQuery<PatientUser> userResult = JPA.em().createQuery(query);
		List<PatientUser> userRes = userResult.getResultList();
		
//		for(User us : userRes)
//		{
//			System.out.println(us.getPassword());
//		}
//		if(userRes!=null&&userRes.size()>0)
//			return true;
//		else
//			return false;
		
		return userRes;
	}
	
	@Override
	public void saveOnStartService(Visit visit) throws Exception
	{
		EntityManager em = JPA.em();
		em.persist(visit);
		//visit.
	}
	
	
	@Override
	public void updateOnStartService(Visit visit) throws Exception
	{
		
		try{EntityManager em = JPA.em();
		Visit readVisit = em.find(Visit.class,visit.getId());
		readVisit.setVisit_Completed(visit.getVisit_Completed());
		readVisit.setScheduled_Duration(visit.getScheduled_Duration());
		//readVisit
		//em.(readVisit);
		em.persist(readVisit);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//visit.
	}
	

}
