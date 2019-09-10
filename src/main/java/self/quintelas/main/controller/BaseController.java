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
    public String index(Model model) {
        List<ModelType> models = repository.findAll();

        model.addAttribute("page", pageName);
        model.addAttribute("pagePath", pagePath);
        model.addAttribute("models", models);

        return pagePath + "/lista";
    }

    @RequestMapping("{id}")
    public String show(@PathVariable int id, Model model) {
        Optional<ModelType> optEntity = repository.findById(id);

        if (!optEntity.isPresent()) {
            return "home";
        }

        injectTemplateAttr(model);

        ModelType entity = optEntity.get();

        model.addAttribute("page", pageName);
        model.addAttribute("pagePath", pagePath);
        model.addAttribute("model", entity);
        model.addAttribute("editandoText", getEditandoText(entity));
        return "form";
    }

    @RequestMapping("/inserir")
    public String showInsert(Model model) {
        injectTemplateAttr(model);

        model.addAttribute("page", pageName);
        model.addAttribute("pagePath", pagePath);
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
}
