package self.quintelas.main.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Tosa;
import self.quintelas.main.repository.TosaRepository;

@Controller
@RequestMapping("/tosas")
public class TosaController extends BaseController<Tosa> {
    public TosaController(TosaRepository repository) {
        super("tosas", "Tosas", repository);
    }

    @Override
    public String getEditandoText(Tosa model) {
        return "Editando a tosa " + model.getNome();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo uma nova tosa";
    }

    @Override
    public Tosa getModelInstance() {
        return new Tosa();
    }
}
