package self.quintelas.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.quintelas.main.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Integer> {
}
