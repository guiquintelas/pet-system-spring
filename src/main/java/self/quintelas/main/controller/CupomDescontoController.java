package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.CupomDesconto;
import self.quintelas.main.repository.CupomDescontoRepository;

@Controller
@RequestMapping("/cupom-descontos")
public class CupomDescontoController extends BaseController<CupomDesconto> {


    public CupomDescontoController(CupomDescontoRepository repository) {
        super("cupom-descontos", "Cupom de Descontos", repository);
    }

    @Override
    public String getEditandoText(CupomDesconto model) {
        return "Editando o cupom de desconto " + model.getCodigo();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo um novo Cupom de Desconto";
    }

    @Override
    public CupomDesconto getModelInstance() {
        return new CupomDesconto();
    }
}
