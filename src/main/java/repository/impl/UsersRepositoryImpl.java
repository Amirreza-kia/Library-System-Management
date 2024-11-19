package repository.impl;

import model.Address;
import model.User;
import model.Users;
import repository.UsersRepository;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {
    @Override
    public Optional<Users> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Users.class, id));
    }

    @Override
    public List<Users> findAll() {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT u FROM Users u ", Users.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Users obj) {
        if (obj.getId() == null) {
            persist(obj);
        } else update(obj);

    }

    @Override
    public void delete(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Users.class, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    public void persist(Users obj) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Users obj) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<User> login(String username, String password) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsernameAndPassword", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        if (query.getResultList().isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        TypedQuery<Users> query = entityManager.createNamedQuery("User.findByUsername", Users.class);
        query.setParameter(1, username);
        return Optional.ofNullable(query.getSingleResult());
    }


}

