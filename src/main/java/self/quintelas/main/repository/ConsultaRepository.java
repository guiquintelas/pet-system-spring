package self.quintelas.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.quintelas.main.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
