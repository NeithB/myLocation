package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Vehicule;
import shaks.trimer.Agence.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements ObjectService<Vehicule>{

    public final VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule save(Vehicule vehicule) {
        return this.vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(Integer id) {
        return this.vehiculeRepository.findById(id).orElseThrow(()->new RuntimeException("Vehicule non trouvé"));
    }

    @Override
    public List<Vehicule> findAll() {
        return this.vehiculeRepository.findAll();
    }

    @Override
    public Vehicule update(Vehicule vehiculeUp, Integer id) {
        Vehicule vehiculeBD=findById(id);
            vehiculeBD.setNR(vehiculeUp.getNR());
            vehiculeBD.setAgence(vehiculeUp.getAgence());
            vehiculeBD.setCategories(vehiculeUp.getCategories());
            vehiculeBD.setCouleur(vehiculeUp.getCouleur());
            vehiculeBD.setMarque(vehiculeUp.getMarque());
            vehiculeBD.setPrixJ(vehiculeUp.getPrixJ());
            vehiculeBD.setDescription(vehiculeUp.getDescription());

        return save(vehiculeBD);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        this.vehiculeRepository.deleteById(id);
    }
}
