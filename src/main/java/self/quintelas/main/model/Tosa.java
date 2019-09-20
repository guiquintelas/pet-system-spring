package self.quintelas.main.model;

import javax.persistence.Entity;

@Entity
public class Tosa extends Servico {
    private boolean comBanho;

    public boolean isComBanho() {
        return comBanho;
    }

    public void setComBanho(boolean comBanho) {
        this.comBanho = comBanho;
    }

    @Override
    public String toString() {
        return ";Id;" + getId() +
                ";Nome;" + getNome()+
                ";Preco;" + getPreco() +
                ";Com Banho?;" + isComBanho();
    }
}
