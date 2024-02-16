package cl.colabora.repository;

import cl.colabora.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository <Profile, Long> {
}
