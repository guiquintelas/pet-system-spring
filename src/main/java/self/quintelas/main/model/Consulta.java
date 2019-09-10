package self.quintelas.main.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Consulta extends Servico {
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Set<Vacina> vacinas;

    public Set<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(Set<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
}
