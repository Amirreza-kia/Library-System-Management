package service.impl;

import model.Subjects;
import service.SubjectsService;
import util.ApplicationContext;

import java.util.Date;

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
        ApplicationContext.bookRepository.deleteByFKey(id);
        ApplicationContext.subjectsRepository.delete(id);
    }

    @Override
    public void updateSubject(Long id, String name) {
        Subjects subjects = new Subjects();
        if(ApplicationContext.subjectsRepository.findById(id).isPresent()){
            subjects.setName(name);
            ApplicationContext.subjectsRepository.saveOrUpdate(subjects);
        }else System.out.println("id not found");
    }

}
