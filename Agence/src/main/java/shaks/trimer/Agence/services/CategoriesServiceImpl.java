package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Categories;
import shaks.trimer.Agence.repository.CategoriesRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoriesServiceImpl implements ObjectService<Categories>{

    public final CategoriesRepository categoriesRepository;
    @Override
    public Categories save(Categories categories) {
        return this.categoriesRepository.save(categories);
    }

    @Override
    public Categories findById(Integer id) {
        return this.categoriesRepository.findById(id).orElseThrow(()->new RuntimeException("Pas de categorie trouvée!"));
    }

    @Override
    public List<Categories> findAll() {
        return this.categoriesRepository.findAll();
    }

    @Override
    public Categories update(Categories categoriesUp, Integer id) {
        Categories categoriesBD=findById(id);
            categoriesBD.setNom_categorie(categoriesUp.getNom_categorie());
        return save(categoriesBD) ;
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        this.categoriesRepository.deleteById(id);

    }
}
