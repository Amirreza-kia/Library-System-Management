package repository.impl;

import model.Book;
import model.Subjects;
import repository.BookRepository;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT b FROM Book b ", Book.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Book obj) {
        if (obj.getId() == null) {
            persist(obj);
        } else update(obj);

    }

    @Override
    public void delete(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Book book = em.find(Book.class, id);
        try {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void persist(Book obj) {
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

    public void update(Book obj) {
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
    public void deleteByFKey(Long fKey) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        TypedQuery<Book> query1 = em.createQuery("SELECT b FROM Book b WHERE subjects.id = ?1", Book.class);
        query1.setParameter(1,fKey);
        Book books = query1.getSingleResult();
        try {
            em.getTransaction().begin();
            em.remove(books);
            em.getTransaction().commit();

        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
}
