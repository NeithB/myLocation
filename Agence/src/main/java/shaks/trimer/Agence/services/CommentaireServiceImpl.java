package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Commentaire;
import shaks.trimer.Agence.repository.CommentaireRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentaireServiceImpl implements ObjectService<Commentaire> {

    public final CommentaireRepository commentaireRepository;
    @Override
    public Commentaire save(Commentaire commentaire) {
        return this.commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire findById(Integer id) {
        return this.commentaireRepository.findById(id).orElseThrow(()->new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public List<Commentaire> findAll() {
        return this.commentaireRepository.findAll();
    }

    @Override
    public Commentaire update(Commentaire commentaireUp, Integer id) {
        Commentaire commentaireBD=findById(id);
            commentaireBD.setContenu(commentaireUp.getContenu());
            commentaireBD.setDateC(commentaireUp.getDateC());
        return save(commentaireBD);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        this.commentaireRepository.deleteById(id);
    }
}
