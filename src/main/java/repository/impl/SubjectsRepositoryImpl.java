package repository.impl;

import model.Subjects;
import repository.SubjectsRepository;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class SubjectsRepositoryImpl implements SubjectsRepository {
    @Override
    public Optional<Subjects> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Subjects.class, id));
    }

    @Override
    public List<Subjects> findAll() {
        return EntityManagerProvider.getEntityManager().createQuery("from Subjects ", Subjects.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Subjects obj) {
        if (obj.getId() == null){
            persist(obj);
        }else update(obj);

    }

    @Override
    public void delete(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Subjects obj = em.find(Subjects.class, id);
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
    public void persist(Subjects obj) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
    public void update(Subjects obj) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Subjects> findSubjectsWhitOneBook() {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT s from Subjects s WHERE books.size = 1", Subjects.class).getResultList();
    }
}
