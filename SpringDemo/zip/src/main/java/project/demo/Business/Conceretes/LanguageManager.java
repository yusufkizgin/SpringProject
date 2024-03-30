package project.demo.Business.Conceretes;


import org.springframework.stereotype.Service;
import project.demo.Business.Abstracts.LanguagesService;
import project.demo.DataAccess.Abstracts.LanguageRepository;
import project.demo.Entities.Conceretes.Languages;

import java.util.List;

@Service
public class LanguageManager implements LanguagesService {
    LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Languages> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Languages getById(int id) throws Exception {
        return languageRepository.getById(id);
    }

    @Override
    public void update(Languages language) throws Exception{
        languageRepository.update(language);
    }

    @Override
    public void add(Languages language) throws Exception {
        for (Languages l : languageRepository.getAll()) {
            if (l.getName().equals(language.name)) {
                throw new Exception("Bu İsimde Dil Zaten Var");
            }
        }
        languageRepository.add(language);
    }

    @Override
    public void remove(Languages language) throws Exception {
        try {
            for(Languages l : languageRepository.getAll()){
                if (l.getId()==language.id){
                    languageRepository.remove(language);
                }
            }
        }catch (Exception e){
            System.out.println("Aranan Kriterlere Uygun Bir Dil Bulunamadı");
        }


    }
}
