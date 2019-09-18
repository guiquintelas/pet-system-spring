package self.quintelas.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.quintelas.main.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
