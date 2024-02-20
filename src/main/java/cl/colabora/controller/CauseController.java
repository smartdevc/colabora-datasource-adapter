package cl.colabora.controller;

import cl.colabora.model.Cause;
import cl.colabora.service.CauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cause")
public class CauseController {
    @Autowired
    private CauseService causeService;

    @GetMapping("/causes")
    public ResponseEntity<List<Cause>> getAllCauses() {
        List<Cause> causes = causeService.getAllCauses();
        return new ResponseEntity<>(causes, HttpStatus.OK);
    }

    //get cause by id
    @GetMapping("/causes/{id}")
    public ResponseEntity<Cause> getCauseById(@PathVariable Long id) {
        Cause cause = causeService.getCauseById(id);
        return new ResponseEntity<>(cause, HttpStatus.OK);
    }

    //create cause

    @PostMapping("/causes")
    public ResponseEntity<String> createCause(@RequestBody Cause cause) {
        try {
            causeService.createCause(cause);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Cause created", HttpStatus.CREATED);
    }

    //update cause **

    @PatchMapping("causes/{id}")
    public ResponseEntity<Cause> updateCause(@PathVariable Long id, @RequestBody Cause cause) {
        //TODO: definir logica de actualizacion
        Cause newCause = causeService.getCauseById(id);
        newCause.setName(cause.getName());
        newCause.setDescription(cause.getDescription());
        try {
            causeService.updateCause(newCause);
        } catch (Exception ex) {
            return new ResponseEntity<>(newCause, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newCause, HttpStatus.OK);

    }

    //delete cause

    @DeleteMapping("causes/{id}")
    public ResponseEntity<String> deleteCause(@PathVariable Long id) {
        try {
            causeService.deleteCause(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Cause deleted", HttpStatus.OK);
    }

}
