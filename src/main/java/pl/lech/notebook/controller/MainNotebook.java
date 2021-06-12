package pl.lech.notebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lech.notebook.model.Notebook;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
@Component
public class MainNotebook {

    private NotebookRepo notebookRepo;
    private List<Notebook> notebooks;
//    private Notebook notebook;

    @Autowired
    public MainNotebook(NotebookRepo notebookRepo) {
        this.notebookRepo = notebookRepo;
    }

    @GetMapping("/notebook")
    public String showNotices(Model model) {
        notebooks = notebookRepo.findAll();
//        if (notebook == null) {
            model.addAttribute("notice", new Notebook());
//        } else {
//            model.addAttribute("notice", notebook);
//        }
        model.addAttribute("notices", notebooks);
        return "notebook";
    }

    @PostMapping("/savenotice")
    public String saveNotice(@ModelAttribute Notebook notice) {
        Notebook notebook = new Notebook();
        notebook.setAuthor(notice.getAuthor());
        notebook.setTitle(notice.getTitle());
        notebook.setNotice(notice.getNotice());
        if (notice.getDate() != null) {
            notebook.setDate(notice.getDate());
        } else {
            notebook.setDate(new Timestamp(System.currentTimeMillis()));
        }
        notebook.setUpdDate(new Timestamp(System.currentTimeMillis()));
        System.out.println(notebook.toString());
        if (notice.getId() > 0) {
            notebook.setId(notice.getId());
            notebookRepo.save(notebook);
        } else {
            notebookRepo.save(notebook);
        }
//        this.notebook = null;
        return "redirect:/notebook";
    }

    @RequestMapping("/editnotice/{id}")
    public String editNotice(@PathVariable Long id, Model model) {
        Notebook notebook = notebookRepo.getById(id);
        System.out.println(notebook.toString());
        model.addAttribute("notice", notebook);
        notebooks = notebookRepo.findAll();
        model.addAttribute("notices", notebooks);
        return "/notebook";
    }

}
