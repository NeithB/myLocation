package shaks.trimer.Agence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shaks.trimer.Agence.modeles.Categories;
import shaks.trimer.Agence.modeles.Vehicule;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
