package cl.colabora.service;

import cl.colabora.model.Cause;

import java.util.List;

public interface CauseService {
    Cause createCause(Cause cause);

    List<Cause> getAllCauses();

    Cause updateCause(Cause cause);

    Cause getCauseById(Long id);

    void deleteCause(Long id);
}
