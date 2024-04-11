package shaks.trimer.Agence.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shaks.trimer.Agence.modeles.Agence;
import shaks.trimer.Agence.services.AgenceServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    public final AgenceServiceImpl agenceService;

    @PostMapping("/inserer")
    public Agence inserAgence(@RequestBody Agence agence){
        return agenceService.save(agence);
    }

    @GetMapping("/listAgence")
    public List<Agence> listUser(@RequestBody Agence agence){
        return agenceService.findAll();
    }

    @PutMapping("/update/{id}")
    public Agence upadteAgence(@PathVariable Integer id, @RequestBody Agence agence){
        return agenceService.update(agence,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAgence(@PathVariable Integer id){
        agenceService.delete(id);
    }

}
