package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Consulta;
import self.quintelas.main.repository.ConsultaRepository;
import self.quintelas.main.repository.PetRepository;

@Controller
@RequestMapping("/consultas")
public class ConsultaController extends BaseController<Consulta> {
    private PetRepository petRepository;

    public ConsultaController(ConsultaRepository repository, PetRepository petRepository) {
        super("consultas", "Consulta", repository);
        this.petRepository = petRepository;
    }

    @Override
    public String getEditandoText(Consulta model) {
        return "Editando a consulta " + model.getNome();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo uma nova consulta";
    }

    @Override
    public Consulta getModelInstance() {
        return new Consulta();
    }

    @Override
    public void injectTemplateAttr(Model model) {
        model.addAttribute("pets", petRepository.findAll());
    }
}
