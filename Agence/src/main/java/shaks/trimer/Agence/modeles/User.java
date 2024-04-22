package shaks.trimer.Agence.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.aspectj.bridge.IMessage;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 25)
    @Column(length = 25)
    private String nom;

    @Size(min = 2, max = 30, message = "Valeur du champ comprise entre 2 et 30")
    @Column(length = 30)

    private String prenom;

    @Size(min = 2, max = 15)
    @Column(length = 15)
    private String sexe;

    @Column(length = 10)
    private String role="CLIENT";

    @Column(length = 50, unique = true)
    private String adresse;

    @Size(min = 6, max = 8, message="Valleur du champ comprise entre 6 et 8")
    @Column(length = 8, unique = true)
    @NotNull
    private String login;

    @Size(min = 2, max = 10, message="Valeur comprise entre 2 et 10")
    @Column(length = 10)
    private String mdp;

    @Column(length = 30, unique = true)
    private String email;

    private Integer phone;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "user")
    private List<Commentaire> commentaireList;

    @OneToMany(mappedBy = "user")
    private List<Categories> categoriesList;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservationList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", adresse='" + adresse + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", agence=" + agence +
                ", commentaireList=" + commentaireList +
                ", categoriesList=" + categoriesList +
                ", reservationList=" + reservationList +
                '}';
    }
}
