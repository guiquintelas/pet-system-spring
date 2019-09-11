package self.quintelas.main.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import self.quintelas.main.model.Pet;
import self.quintelas.main.repository.PetRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetRestController {

    private PetRepository petRepository;

    public PetRestController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @RequestMapping("")
    public List<Pet> index() {
        return petRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet create(@Valid @RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}
