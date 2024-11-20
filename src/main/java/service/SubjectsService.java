package service;

import model.Book;

import java.util.List;

public interface SubjectsService {
    void addSubject(String name);
    void deleteSubject(Long id);
    void updateSubject(Long id, String name);
    List<Book> findAllBookWithSubject(Long subjectId);
}
