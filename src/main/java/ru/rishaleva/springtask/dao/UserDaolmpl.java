package ru.rishaleva.springtask.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.rishaleva.springtask.model.User;

import java.util.List;


@Repository
public class UserDaolmpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User userUp) {
        entityManager.merge(userUp);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }
}
