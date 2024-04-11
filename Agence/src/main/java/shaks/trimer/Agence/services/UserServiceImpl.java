package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Agence;
import shaks.trimer.Agence.modeles.User;
import shaks.trimer.Agence.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements ObjectService<User>{

    // Injection par constructeur
    public final UserRepository userRepository;

    /**
     * <p>Prend en parametre un objet User </p>
     *
     * <p>le sauvegarde et revoie l'gence sauvegarder</p>
     *
     * @param user ( agence est une entité )
     * @return l'objet Agence
     * @see User
     */
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    // Recherche l'utilisateur puis leve une exception s'il n'est pas trouvé

    /**
     * <p>Prend en parametre id</p>
     *
     * <p>Recherche et renvoie l'user sauvegardé</p>
     *
     * @throws RuntimeException renvoie une
     * exception si user n'existe pas
     *
     * @param id  non null ( id est une integer )
     * @return l'objet user
     * @see User
     */
    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id).orElseThrow(()->new RuntimeException("Utilisateur non trouvé"));

    }

    // Retourne la liste des utilisateurs

    /***
     * <p> renvoie la liste d'gence sauvegardé</p>
     *
     * @return la liste des  agences
     * @see List<User>
     */
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    // Recherche Modifier l'utilisateur


    /**
     * <p>Prend en parametre id</p>
     *
     * <p>Recherche et renvoie l'user sauvegardé</p>
     *
     * <p>Modifie et renvoie  l'user sauvegardé</p>
     *
     * @throws RuntimeException renvoie une
     * exception si user n'existe pas
     *
     * @param userUp  non null ( update est une Long )
     * @param id  non null
     * ( update est une object à mettre à jour )
     *
     * @return l'objet update modifié
     * @see User
     */
    @Override
    public User update(User userUp, Integer id) {
        // Recheche l'utilsiateur. s'il trouve pas, il levera l'exception
        User userBD=findById(id);
        // s'il trouve, il modifie puis enregistre dans la base des données
            userBD.setAdresse(userUp.getAdresse());
            userBD.setEmail(userUp.getEmail());
            userBD.setMdp(userUp.getMdp());
            userBD.setLogin(userUp.getLogin());
            userBD.setNom(userUp.getNom());
            userBD.setPhone(userUp.getPhone());
            userBD.setSexe(userUp.getSexe());
            userBD.setPrenom(userUp.getPrenom());
        return save(userBD);
    }
    // Supprime l'utilisateur

    /**
     * <p>Prend en parametre userId</p>
     *
     * <p>vérifie si user existe si oui il supprime</p>
     *
     * @throws RuntimeException renvoie une
     * exception si user n'existe pas
     *
     * @param id  non null ( userId est une Long )
     */
    @Override
    public void delete(Integer id) {
        //Recherche d'abord l'utilisateur et leve l'exception s'il ne trouve pas
        findById(id);
        this.userRepository.deleteById(id);
    }
}
