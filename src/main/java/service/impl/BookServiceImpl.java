package service.impl;

import model.Book;
import model.Subjects;
import model.Users;
import service.BookService;
import util.ApplicationContext;

public class BookServiceImpl implements BookService {
    @Override
    public void addBook(String title, String author, Long subjects) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        Subjects subject = new Subjects();
        subject.setId(subjects);
        book.setSubjects(subject);
        ApplicationContext.bookRepository.saveOrUpdate(book);
    }

    @Override
    public void updateBook(Long id, String title, String author, Long subjectsId) {
        if(ApplicationContext.bookRepository.findById(id).isPresent()) {
            Book book = ApplicationContext.bookRepository.findById(id).get();
            book.setTitle(title);
            book.setAuthor(author);
            if(ApplicationContext.subjectsRepository.findById(id).isPresent()) {
                Subjects subject = ApplicationContext.subjectsRepository.findById(subjectsId).get();
                subject.setId(subjectsId);
                book.setSubjects(subject);
            }
            ApplicationContext.bookRepository.saveOrUpdate(book);
        }else System.out.println("Book not found");
    }

    @Override
    public void takeBook(Long idBook, String username) {
        if(ApplicationContext.bookRepository.findById(idBook).isPresent()) {
            Book book = ApplicationContext.bookRepository.findById(idBook).get();
            if (ApplicationContext.usersRepository.findByUsername(username).isPresent()) {
                Users users = ApplicationContext.usersRepository.findByUsername(username).get();
                users.getBooks().add(book);
                ApplicationContext.usersRepository.saveOrUpdate(users);
            }else System.out.println("User not found");
        }else System.out.println("Book not found");
    }

    @Override
    public void deleteBook(Long id) {
        if (ApplicationContext.bookRepository.findById(id).isPresent()) {
            ApplicationContext.bookRepository.delete(id);
        }else System.out.println("Book not found");
    }
}
