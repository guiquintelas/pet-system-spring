package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Pet;
import self.quintelas.main.repository.PetRepository;

@Controller
@RequestMapping("/pets")
public class PetController extends BaseController<Pet> {

    public PetController(PetRepository repository) {
        super("pets", "Pets", repository);
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
}
