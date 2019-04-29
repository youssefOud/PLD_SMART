package DAO;

import Model.User;

public class UserDAO {

	public UserDAO() {
		
	}
	
	public User findById(Long id){
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(User.class, id);
    }
    public void persist(User user){
        EntityManager em = JpaUtil.getEntityManager();
        em.persist(user);
    }
    public void merge(User user){
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(user);
    }
    public void remove(User user){
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(user);
    }
	
}