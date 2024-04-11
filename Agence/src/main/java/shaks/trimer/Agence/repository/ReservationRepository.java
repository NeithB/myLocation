package shaks.trimer.Agence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shaks.trimer.Agence.modeles.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
