package project.demo.WebApi.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.demo.Business.Abstracts.LanguagesService;
import project.demo.Entities.Conceretes.Languages;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    public LanguagesService languagesService;

    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/getall")
    public List<Languages> getAll(){
        return languagesService.getAll();
    }

    @GetMapping("/getall/{id}")
    public Languages getLanguageById(@PathVariable int id) throws Exception {
        return languagesService.getById(id);
    }
    @PostMapping("/add")
    public void add(Languages languages) throws Exception {
        languagesService.add(languages);
    }@PostMapping("/remove")
    public void remove(Languages languages) throws Exception {
        languagesService.remove(languages);
    }
    @PostMapping("/update")
    public void update(Languages languages) throws Exception {
        languagesService.update(languages);
    }
}
