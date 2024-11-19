package repository;

import model.Subjects;

import java.util.List;

public interface SubjectsRepository extends BaseRepository<Subjects>{

    List<Subjects> findSubjectsWhitOneBook();

}
