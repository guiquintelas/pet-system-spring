package self.quintelas.main.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Consulta;
import self.quintelas.main.repository.ConsultaRepository;

@Controller
@RequestMapping("/consultas")
public class ConsultaController extends BaseController<Consulta> {
    public ConsultaController(ConsultaRepository repository) {
        super("consultas", "Consulta", repository);
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
}
