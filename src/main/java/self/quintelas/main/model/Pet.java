package self.quintelas.main.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String raca;
    @ManyToOne() CupomDesconto cupomDesconto;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Consulta> consultas;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Tosa> tosas;

    public Set<Tosa> getTosas() {
        return tosas;
    }

    public void setTosas(Set<Tosa> tosas) {
        this.tosas = tosas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        CupomDesconto cupomDesconto = getCupomDesconto();

        String codigo = (cupomDesconto != null) ? cupomDesconto.getCodigo() : "nenhum";

        return ";Id;" + getId() +
                ";Nome;" + getNome()+
                ";Raca;" + raca +
                ";Cupom de Desconto;" + codigo;
    }
}
