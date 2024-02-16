package cl.colabora.repository;

import cl.colabora.model.Cause;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CauseRepository extends JpaRepository <Cause, Long> {
}
