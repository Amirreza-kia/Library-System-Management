package repository;

import model.Book;

import java.util.List;

public interface BookRepository extends BaseRepository<Book> {
    void deleteByFKey(Long FKey);
    List<Book> findAllBookWithSubject(Long subjectId);
}
