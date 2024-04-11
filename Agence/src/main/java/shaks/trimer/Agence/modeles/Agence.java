package shaks.trimer.Agence.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2,max=20, message = "Valeur comprise entre 2 et 20")
    @Column(length = 20)
    private String nom_agence;

    @OneToMany(mappedBy = "agence")
    private List<User> userList;

    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehiculeList;

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom_agence='" + nom_agence + '\'' +
                ", userList=" + userList +
                ", vehiculeList=" + vehiculeList +
                '}';
    }
}
