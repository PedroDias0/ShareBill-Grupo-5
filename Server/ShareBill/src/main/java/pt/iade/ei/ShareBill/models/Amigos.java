package pt.iade.ei.ShareBill.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "amigos")
public class Amigos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amizade_id")
    private int id;

    // Alterado para FetchType.EAGER para carregar automaticamente os dados de utilizador1 e utilizador2
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "utilizador1_id", referencedColumnName = "user_id", nullable = false)
    private User utilizador1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "utilizador2_id", referencedColumnName = "user_id", nullable = false)
    private User utilizador2;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    // Enum para representar os estados possíveis
    public enum Estado {
        Pending, Accepted, Blocked
    }

    // Construtor padrão
    public Amigos() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUtilizador1() {
        return utilizador1;
    }

    public void setUtilizador1(User utilizador1) {
        this.utilizador1 = utilizador1;
    }

    public User getUtilizador2() {
        return utilizador2;
    }

    public void setUtilizador2(User utilizador2) {
        this.utilizador2 = utilizador2;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
}
