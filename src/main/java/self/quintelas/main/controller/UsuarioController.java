package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.quintelas.main.model.Usuario;
import self.quintelas.main.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario> {
    public UsuarioController(UsuarioRepository repository) {
        super("usuarios", "Usuarios", repository);
    }

    @Override
    public String getEditandoText(Usuario model) {
        return "Editando o usuario " + model.getNome();
    }

    @Override
    public String getInserindoText() {
        return "Inserindo um novo usuario";
    }

    @Override
    public Usuario getModelInstance() {
        return new Usuario();
    }
}
