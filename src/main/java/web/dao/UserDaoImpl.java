package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;

    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void delete(long id) {
        Query q = entityManager.createQuery("delete from User where id=:id");
        q.setParameter("id", id);
        q.executeUpdate();

    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
