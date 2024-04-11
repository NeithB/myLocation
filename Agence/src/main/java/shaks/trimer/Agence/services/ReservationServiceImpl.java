package shaks.trimer.Agence.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shaks.trimer.Agence.modeles.Reservation;
import shaks.trimer.Agence.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ObjectService<Reservation>{

    public final ReservationRepository reservationRepository;
    @Override
    public Reservation save(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(Integer id) {
        return this.reservationRepository.findById(id).orElseThrow(()->new RuntimeException("Reservation non trouvée!"));
    }

    @Override
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation update(Reservation reservationUP, Integer id) {
        Reservation reservationBD=findById(id);
            reservationBD.setDateDebut(reservationUP.getDateDebut());
            reservationBD.setDateFin(reservationUP.getDateFin());
            reservationBD.setUser(reservationUP.getUser());
            reservationBD.setVehicule(reservationUP.getVehicule());
            reservationBD.setPrixT(reservationUP.getPrixT());
        return save(reservationBD);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        this.reservationRepository.deleteById(id);

    }
}
