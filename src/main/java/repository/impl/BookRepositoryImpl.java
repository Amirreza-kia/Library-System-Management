package repository.impl;

import model.Book;
import model.Subjects;
import repository.BookRepository;
import util.ApplicationContext;
import util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {
        CriteriaBuilder cb = EntityManagerProvider.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        return EntityManagerProvider.getEntityManager().createQuery(cq).getResultList();
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
        TypedQuery<Book> query = EntityManagerProvider.getEntityManager().createNamedQuery("replaceFkKey", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            try {
                em.getTransaction().begin();
                query.setParameter(1, fKey);
                book.getSubjects().setId(0L);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }


    }

    //another way find in service
    @Override
    public List<Book> findAllBookWithSubject(Long subjectId) {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT b FROM Book B WHERE subjects.id = ?1", Book.class).getResultList();
    }
}
