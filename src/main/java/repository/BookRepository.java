package repository;

import model.Book;

public interface BookRepository extends BaseRepository<Book> {
    void deleteByFKey(Long FKey);
}
