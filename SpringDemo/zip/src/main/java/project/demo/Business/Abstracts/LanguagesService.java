package project.demo.Business.Abstracts;

import project.demo.Entities.Conceretes.Languages;

import java.util.List;

public interface LanguagesService {
    List<Languages> getAll();
    Languages getById(int id) throws Exception;
    void update(Languages language) throws Exception;
    void add(Languages language) throws Exception;
    void remove(Languages language) throws Exception;
}
