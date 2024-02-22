package cl.colabora.service.impl;

import cl.colabora.model.Organization;
import cl.colabora.repository.OrganizationRepository;
import cl.colabora.service.OrganizationService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;


    @Override
    public Organization createOrganization(Organization organization) { return organizationRepository.save(organization); }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        Optional<Organization> organizationFinded = organizationRepository.findById(organization.getId());
        if (organizationFinded.isPresent()){
            Organization organizationUpdated = organizationFinded.get();
            organizationUpdated.setName(organization.getName());
            organizationRepository.save(organizationUpdated);
            return organizationUpdated;
        } else {
            throw new NoResultException("Organization with id" + organization.getId() + "was not found");
        }
    }

    @Override
    public Organization getOrganizationById(Long id) {
        Optional <Organization> organization = organizationRepository.findById(id);
        if(organization.isPresent()){
            return organization.get();
        } else {
            throw new NoResultException("Organization with id" + id + "was not found");
        }
    }

    @Override
    public void deleteOrganization(Long id) {
        Optional <Organization> organization = organizationRepository.findById(id);
        if (organization.isPresent()){
            organizationRepository.delete(organization.get());
        } else {
            throw new NoResultException("Organization with id" + id + "was not found");
        }
    }
}
