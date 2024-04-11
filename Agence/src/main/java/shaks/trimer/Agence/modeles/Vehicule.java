package shaks.trimer.Agence.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=5, max=20,message = "Valeur comprise en 5 et 20")
    @Column(length = 20)
    private String marque;

    @NotNull
    @Column(length = 10)
    private String couleur;

    @NotNull
    private Double prixJ;

    @NotNull
    private Integer nR;

    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "vehicule")
    private List<Commentaire> commentaireList;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name="vehicule")
    private List<Reservation> reservationList;

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", couleur='" + couleur + '\'' +
                ", prixJ=" + prixJ +
                ", nR=" + nR +
                ", description='" + description + '\'' +
                ", agence=" + agence +
                ", commentaireList=" + commentaireList +
                ", categories=" + categories +
                ", reservationList=" + reservationList +
                '}';
    }
}
