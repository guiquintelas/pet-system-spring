package self.quintelas.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import self.quintelas.main.model.Usuario;
import self.quintelas.main.repository.UsuarioRepository;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {
    private UsuarioRepository usuarioRepository;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            HttpSession httpSession,
            Model model
    ) {

        Optional<Usuario> sepaUser = usuarioRepository.findByEmailAndSenha(email, senha);

        if (!sepaUser.isPresent()) {
            model.addAttribute("loginError", true);
            return "login";
        }

        httpSession.setAttribute("usuario", sepaUser.get().getNome());
        return "redirect:/";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.setAttribute("usuario", null);
        return "redirect:/login";
    }
}
