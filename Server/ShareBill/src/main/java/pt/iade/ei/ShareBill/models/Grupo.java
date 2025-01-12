package pt.iade.ei.ShareBill.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grupo_id")
    private int id;

    @Column(name = "grupo_nome", nullable = false)
    private String nome;

    @Column(name = "grupo_descricao")
    private String descricao;

    @Column(name = "grupo_montante")
    private Double montante;

    public Grupo() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMontante() {
        return montante;
    }

    public void setMontante(Double montante) {
        this.montante = montante;
    }
}



