package self.quintelas.main.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tosa extends Servico {
    private boolean comBanho;

    @ManyToOne
    private Pet pet;

    public boolean isComBanho() {
        return comBanho;
    }

    public void setComBanho(boolean comBanho) {
        this.comBanho = comBanho;
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
                ";Preco;" + getPreco() +
                ";Com Banho?;" + isComBanho();
    }
}
