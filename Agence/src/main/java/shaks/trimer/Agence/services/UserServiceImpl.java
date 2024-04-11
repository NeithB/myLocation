package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.User;
import shaks.trimer.Agence.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements ObjectService<User>{

    // Injection par constructeur
    public final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    // Recherche l'utilisateur puis leve une exception s'il n'est pas trouvé
    @Override
    public User findById(Integer id) {
        return this.userRepository.findById(id).orElseThrow(()->new RuntimeException("Utilisateur non trouvé"));

    }

    // Retourne la liste des utilisateurs
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    // Recherche Modifier l'utilisateur
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
    @Override
    public void delete(Integer id) {
        //Recherche d'abord l'utilisateur et leve l'exception s'il ne trouve pas
        findById(id);
        this.userRepository.deleteById(id);
    }
}
