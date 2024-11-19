package service;

public interface SubjectsService {
    void addSubject(String name);
    void deleteSubject(Long id);
    void updateSubject(Long id, String name);
}
