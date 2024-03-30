package project.demo.DataAccess.Abstracts;

import project.demo.Entities.Conceretes.Languages;

import java.util.List;

public interface LanguageRepository {
    List<Languages> getAll();
    Languages getById(int id) throws Exception;
    void update(Languages languages) throws Exception;
    void add(Languages language) throws Exception;
    void remove(Languages language) throws Exception;

}
