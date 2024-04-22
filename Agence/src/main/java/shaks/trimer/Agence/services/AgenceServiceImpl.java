package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Agence;
import shaks.trimer.Agence.repository.AgenceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements ObjectService<Agence>{

    public final AgenceRepository agenceRepository;

    /**
     * <p>Prend en parametre un objet agence </p>
     *
     * <p>le sauvegarde et revoie l'gence sauvegarder</p>
     *
     * @param agence ( agence est une entité )
     * @return l'objet Agence
     * @see Agence
    */
    @Override
    public Agence save(Agence agence) {
        return this.agenceRepository.save(agence);
    }


    /**
     * <p>Prend en parametre id</p>
     *
     * <p>Recherche et renvoie l'Agence sauvegardé</p>
     *
     * @throws RuntimeException renvoie une
     * exception si user n'existe pas
     *
     * @param id  non null ( id est integer )
     * @return l'objet Agence
     * @see Agence
    */
    @Override
    public Agence findById(Integer id) {
        return this.agenceRepository.findById(id).orElseThrow(()->new RuntimeException("Agence non trouvée"));
    }


    /***
     * <p> renvoie la liste d'agence sauvegardé</p>
     *
     * @return la liste des  agences
     * @see List<Agence>
    */
    @Override
    public List<Agence> findAll() {
        return this.agenceRepository.findAll();
    }


    /**
     * <p>Prend en parametre agenceUp</p>
     *
     * <p>Recherche et renvoie l'Agence sauvegardé</p>
     *
     * <p>Modifie et renvoie  l'agence sauvegardé</p>
     *
     * @throws RuntimeException renvoie une
     * exception si agence n'existe pas
     *
     * @param agenceUp  non null ( update est une Long )
     * @param id  non null
     * ( update est une object à mettre à jour )
     *
     * @return l'objet update modifié
     * @see Agence
    */
    @Override
    public Agence update(Agence agenceUp, Integer id) {
        Agence agenceBD=findById(id);
            agenceBD.setNom_agence(agenceUp.getNom_agence());
        return save(agenceBD);
    }

    /**
     * <p>Prend en parametre Id</p>
     *
     * <p>vérifie si agence existe si oui il supprime</p>
     *
     * @throws RuntimeException renvoie une
     * exception si user n'existe pas
     *
     * @param id  non null ( id est integer)
    */
    @Override
    public void delete(Integer id) {
        findById(id);
        this.agenceRepository.deleteById(id);
    }
}
