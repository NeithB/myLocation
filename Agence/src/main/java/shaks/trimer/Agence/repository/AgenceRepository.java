package shaks.trimer.Agence.repository;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import shaks.trimer.Agence.modeles.Agence;

@ReadingConverter
public interface AgenceRepository extends JpaRepository<Agence, Integer> {


}
