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
    @Override
    public Agence save(Agence agence) {
        return this.agenceRepository.save(agence);
    }

    @Override
    public Agence findById(Integer id) {
        return this.agenceRepository.findById(id).orElseThrow(()->new RuntimeException("Agence non trouvée"));
    }

    @Override
    public List<Agence> findAll() {
        return this.agenceRepository.findAll();
    }

    @Override
    public Agence update(Agence agenceUp, Integer id) {
        Agence agenceBD=findById(id);
            agenceBD.setNom_agence(agenceUp.getNom_agence());
        return save(agenceBD);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        this.agenceRepository.deleteById(id);

    }
}
