package cl.colabora.controller;

import cl.colabora.model.Organization;
import cl.colabora.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orgganization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/organizations")
    public ResponseEntity <List<Organization>> getAllOrganizations(){
        List<Organization> organizations = organizationService.getAllOrganizations();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }
}
