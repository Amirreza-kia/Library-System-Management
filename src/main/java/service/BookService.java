package service;

public interface BookService {
    void addBook(String title, String author, Long subjects);
    void updateBook(Long id,String title, String author, Long subjects);
    void takeBook(Long id,String username);
}
