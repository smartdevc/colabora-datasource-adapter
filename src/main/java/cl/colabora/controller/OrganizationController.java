package cl.colabora.controller;

import cl.colabora.model.Organization;
import cl.colabora.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/organizations")
    public ResponseEntity <List<Organization>> getAllOrganizations(){
        List<Organization> organizations = organizationService.getAllOrganizations();
        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    @GetMapping("/organizations/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
        Organization organization = organizationService.getOrganizationById(id);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    @PostMapping("/organizations")
    public ResponseEntity<String> createOrganization(@RequestBody Organization organization){
        try{
            organizationService.createOrganization(organization);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Organization created", HttpStatus.CREATED);
    }

    @PostMapping("/organizations/{id}")
    public ResponseEntity<Organization> updateOrganization (@PathVariable Long id, @RequestBody Organization organization) {
        Organization organizationUpdate = organizationService.updateOrganization(organization);
        return new ResponseEntity<>(organizationUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/organizations/{id}")
    public ResponseEntity<String> deleteOrganization(@PathVariable Long id){
        try{
            organizationService.deleteOrganization(id);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Organization deleted", HttpStatus.OK);
    }

}
