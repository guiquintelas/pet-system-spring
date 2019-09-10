package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Vacina;
import self.quintelas.main.repository.ConsultaRepository;
import self.quintelas.main.repository.VacinaRepository;

@Controller
@RequestMapping("/vacinas")
public class VacinaController extends BaseController<Vacina> {
    private ConsultaRepository consultaRepository;

    public VacinaController(VacinaRepository repository, ConsultaRepository consultaRepository) {
        super("vacinas", "Vacinas", repository);
        this.consultaRepository = consultaRepository;
    }

    @Override
    public String getEditandoText(Vacina model) {
        return "Editando a vacina " + model.getNome();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo nova vacina";
    }

    @Override
    public Vacina getModelInstance() {
        return new Vacina();
    }

    @Override
    public void injectTemplateAttr(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
    }
}
