package cl.colabora.repository;

import cl.colabora.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository <Organization, Long> {
}
