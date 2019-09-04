package self.quintelas.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.quintelas.main.model.CupomDesconto;

public interface CupomDescontoRepository extends JpaRepository<CupomDesconto, Integer> {
}
