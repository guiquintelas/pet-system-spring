package self.quintelas.main.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Consulta extends Servico {
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Set<Vacina> vacinas;

    @ManyToOne
    private Pet pet;

    public Set<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(Set<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return ";Id;" + getId() +
                ";Nome;" + getNome()+
                ";Preco;" + getPreco();
    }
}
