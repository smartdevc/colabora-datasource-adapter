package cl.colabora.service.impl;

import cl.colabora.model.Organization;
import cl.colabora.repository.OrganizationRepository;
import cl.colabora.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return null;
    }

    @Override
    public void deleteOrganization(Long id) {

    }
}
