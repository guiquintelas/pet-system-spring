package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Pet;
import self.quintelas.main.repository.CupomDescontoRepository;
import self.quintelas.main.repository.PetRepository;

@Controller
@RequestMapping("/pets")
public class PetController extends BaseController<Pet> {

    private CupomDescontoRepository cupomDescontoRepository;

    public PetController(PetRepository repository, CupomDescontoRepository cupomDescontoRepository) {
        super("pets", "Pets", repository);
        this.cupomDescontoRepository = cupomDescontoRepository;
    }

    @Override
    public String getEditandoText(Pet model) {
        return "Editando o pet " + model.getNome();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo um novo pet";
    }

    @Override
    public Pet getModelInstance() {
        return new Pet();
    }

    @Override
    public void injectTemplateAttr(Model model) {
        model.addAttribute("cupoms", cupomDescontoRepository.findAll());
    }
}
