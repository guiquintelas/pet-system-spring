package self.quintelas.main.controller;

import org.springframework.web.bind.annotation.*;
import self.quintelas.main.model.Pet;
import self.quintelas.main.repository.PetRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT)
    public Pet update(@PathVariable("id") int id, @Valid @RequestBody Pet pet) {
        pet.setId(id);
        return petRepository.save(pet);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        petRepository.deleteById(id);
    }
}
