package cl.colabora.service;

import cl.colabora.model.Cause;

import java.util.List;

public interface CauseService {
    Cause createCause(Cause cause);

    List<Cause> getAllCauses();
}
