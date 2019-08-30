package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import self.quintelas.main.model.Pet;
import self.quintelas.main.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pets")
public class PetController {

    private PetRepository repository;

    public PetController(PetRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("")
    public String index(Model model) {
        List<Pet> pets = repository.findAll();

        model.addAttribute("pets", pets);
        model.addAttribute("page", "Pets");
        return "pets/petLista";
    }

    @RequestMapping("{id}")
    public String show(@PathVariable int id, Model model) {
        Optional<Pet> pet = repository.findById(id);

        if (!pet.isPresent()) {
            return "home";
        }

        model.addAttribute("pet", pet.get());
        model.addAttribute("page", "Pets");
        return "pets/petEdita";
    }

    @RequestMapping(value = "editar", method = RequestMethod.POST)
    public String update(@ModelAttribute() Pet pet, Model model) {
        repository.save(pet);
        model.addAttribute("msg", "Editado com sucesso!");
        return index(model);
    }
}
