package self.quintelas.main.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import self.quintelas.main.model.Pet;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<ModelType> {
    protected String pagePath;
    protected String pageName;

    protected JpaRepository repository;

    public BaseController(String pagePath, String pageName, JpaRepository repository) {
        this.pagePath = pagePath;
        this.pageName = pageName;
        this.repository = repository;
    }

    public abstract String getEditandoText(ModelType model);
    public abstract String getInserindoText();
    public abstract ModelType getModelInstance();

    public void injectTemplateAttr(Model model) {

    }

    @RequestMapping("")
    public String index(Model model, HttpSession httpSession) {
        List<ModelType> models = repository.findAll();

        model.addAttribute("models", models);
        addPageInfo(model, httpSession);
        return pagePath + "/lista";
    }

    @RequestMapping("{id}")
    public String show(@PathVariable int id, Model model, HttpSession httpSession) {
        Optional<ModelType> optEntity = repository.findById(id);

        if (!optEntity.isPresent()) {
            return "home";
        }

        injectTemplateAttr(model);

        ModelType entity = optEntity.get();

        addPageInfo(model, httpSession);
        model.addAttribute("model", entity);
        model.addAttribute("editandoText", getEditandoText(entity));
        return "form";
    }

    @RequestMapping("/inserir")
    public String showInsert(Model model, HttpSession httpSession) {
        injectTemplateAttr(model);

        addPageInfo(model, httpSession);
        model.addAttribute("model", getModelInstance());
        model.addAttribute("inserindoText", getInserindoText());
        return "form";
    }

    @RequestMapping(value = "inserir", method = RequestMethod.POST)
    public String insert(@ModelAttribute() ModelType entity, RedirectAttributes redir) {
        repository.save(entity);

        redir.addFlashAttribute("msg", "Inserido com sucesso!");
        return "redirect:/" + pagePath;
    }

    @RequestMapping(value = "editar", method = RequestMethod.POST)
    public String update(@ModelAttribute() ModelType entity, RedirectAttributes redir) {
        repository.save(entity);

        redir.addFlashAttribute("msg", "Editado com sucesso!");
        return "redirect:/" + pagePath;
    }

    @RequestMapping("{id}/deletar")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redir) {
        repository.deleteById(id);

        redir.addFlashAttribute("msg", "Deletado com sucesso!");
        return "redirect:/" + pagePath;
    }

    private void addPageInfo(Model model, HttpSession httpSession) {
        model.addAttribute("history", getHistory(httpSession));
        model.addAttribute("page", pageName);
        model.addAttribute("pagePath", pagePath);
    }

    private List<String> getHistory(HttpSession httpSession) {
        Object preHistory = httpSession.getAttribute("history");

        ArrayList<String> history;

        if (preHistory instanceof ArrayList) {
            history = (ArrayList<String>) preHistory;
        } else {
            history = new ArrayList<>();
        }

        if (history.isEmpty() || history.get(history.size() - 1) != this.pageName) {
            history.add(pageName);
        }

        while (history.size() > 5) {
            history.remove(0);
        }

        httpSession.setAttribute("history", history);

        return history;
    }
}
