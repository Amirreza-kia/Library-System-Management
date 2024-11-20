package service.impl;

import model.Book;
import model.Subjects;
import service.SubjectsService;
import util.ApplicationContext;

import java.util.Date;
import java.util.List;

public class SubjectsServiceImpl implements SubjectsService {
    @Override
    public void addSubject(String name) {
        Subjects subjects = Subjects.builder()
                .name(name)
                .build();
        subjects.setCreated(new Date());
        ApplicationContext.subjectsRepository.saveOrUpdate(subjects);
    }

    @Override
    public void deleteSubject(Long id) {
        if (ApplicationContext.subjectsRepository.findById(id).isPresent()) {
//            ApplicationContext.bookRepository.deleteByFKey(id);
            ApplicationContext.subjectsRepository.delete(id);
        }
    }

    @Override
    public void updateSubject(Long id, String name) {
        if(ApplicationContext.subjectsRepository.findById(id).isPresent()){
            Subjects subjects = ApplicationContext.subjectsRepository.findById(id).get();
            subjects.setName(name);
            ApplicationContext.subjectsRepository.saveOrUpdate(subjects);
        }else System.out.println("id not found");
    }

    @Override
    public List<Book> findAllBookWithSubject(Long subjectId) {
        if (ApplicationContext.subjectsRepository.findById(subjectId).isEmpty()) {
            System.out.println("subjectId not found");
        }
        return ApplicationContext.subjectsRepository.findById(subjectId).get().getBooks();
    }

}
