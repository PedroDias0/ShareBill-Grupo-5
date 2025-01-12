package pt.iade.ei.ShareBill.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "despesas")
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "despesas_id")
    private int id;

    @Column(name = "despesas_valor", nullable = false)
    private Double valor;

    @Column(name = "despesas_descricao")
    private String descricao;

    @Column(name = "data")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(
            name = "despesas_id_utilizador",
            referencedColumnName = "user_id",
            nullable = true
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "despesas_id_grupo",
            referencedColumnName = "grupo_id",
            nullable = true
    )
    private Grupo grupo;

    // Construtor padrão
    public Despesas() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
