package pt.iade.ei.ShareBill.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ug")
public class Ug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ug_id")
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "ug_id_utilizador",
            referencedColumnName = "user_id",
            nullable = true
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "ug_id_grupo",
            referencedColumnName = "grupo_id",
            nullable = true
    )
    private Grupo grupo;

    // Construtor padrão
    public Ug() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
