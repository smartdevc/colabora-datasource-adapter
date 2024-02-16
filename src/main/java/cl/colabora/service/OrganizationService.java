package cl.colabora.service;

import cl.colabora.model.Organization;

import java.util.List;

public interface OrganizationService {

    Organization createOrganization(Organization organization);

    List<Organization> getAllOrganizations();

    Organization updateOrganization(Organization organization);

    Organization getOrganizationById(Long id);

    void deleteOrganization(Long id);
}
