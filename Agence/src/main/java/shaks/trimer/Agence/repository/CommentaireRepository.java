package shaks.trimer.Agence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shaks.trimer.Agence.modeles.Commentaire;
import shaks.trimer.Agence.modeles.User;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {
    Commentaire findByUser(User user);
}
