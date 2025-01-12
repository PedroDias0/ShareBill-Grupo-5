package pt.iade.ei.ShareBill.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "atividades")
public class Atividades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private int id;

    @Column(name = "atividade_descricao", nullable = false)
    private String descricao;

    @Column(name = "data")
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(
            name = "atividade_id_categoria",
            referencedColumnName = "categoria_id",
            nullable = true
    )
    private Categorias categorias;

    // Construtor padrão
    public Atividades() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

}
