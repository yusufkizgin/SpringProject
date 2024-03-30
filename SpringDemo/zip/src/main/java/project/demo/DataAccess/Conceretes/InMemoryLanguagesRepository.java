package project.demo.DataAccess.Conceretes;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import project.demo.DataAccess.Abstracts.LanguageRepository;
import project.demo.Entities.Conceretes.Languages;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryLanguagesRepository implements LanguageRepository {
    List<Languages> languages;

    public InMemoryLanguagesRepository() {
        languages = new ArrayList<Languages>();
        languages.add(new Languages(1, "Python"));
        languages.add(new Languages(2, "Java"));
        languages.add(new Languages(3, "C#"));
    }
    @Override
    public List<Languages> getAll() {
        return languages;
    }

    @Override
    public Languages getById(int id) throws Exception {
        for(Languages l : this.languages) {
            if(l.getId() == id) {
                return l;
            }
        }
        throw new Exception("Aranan ID'de Dil Yok");
    }

    @Override
    public void update(Languages language){
        for (Languages l : languages) {
            if (l.getId()==language.id) {
                l.setName(language.name);
            }
        }
    }

    @Override
    public void add(Languages language) {
        languages.add(language);
    }

    @Override
    public void remove(Languages language) {
        languages.remove(language.id-1);
    }
}
