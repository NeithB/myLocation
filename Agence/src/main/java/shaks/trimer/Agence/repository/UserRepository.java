package shaks.trimer.Agence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shaks.trimer.Agence.modeles.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndMdp(String login,String mdp);
    User findByLogin(String login);

}
