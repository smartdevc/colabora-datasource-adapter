package cl.colabora.controller;

import cl.colabora.model.Cause;
import cl.colabora.service.CauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cause")
public class CauseController {
    @Autowired
    private CauseService causeService;

    @GetMapping("/causes")
    public ResponseEntity<List<Cause>> getAllCauses(){
        List<Cause> causes = causeService.getAllCauses();
        return new ResponseEntity<>(causes, HttpStatus.OK);
    }
}
