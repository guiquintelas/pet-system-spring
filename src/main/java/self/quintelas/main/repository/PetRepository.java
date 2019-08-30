package self.quintelas.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.quintelas.main.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
