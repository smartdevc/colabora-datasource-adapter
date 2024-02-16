package cl.colabora.service.impl;

import cl.colabora.model.Cause;
import cl.colabora.repository.CauseRepository;
import cl.colabora.service.CauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CauseServiceImpl implements CauseService {

    @Autowired
    private CauseRepository causeRepository;

    @Override
    public Cause createCause(Cause cause) {
        return causeRepository.save(cause);
    }

    @Override
    public List<Cause> getAllCauses() {
        return causeRepository.findAll();
    }

    @Override
    public Cause updateCause(Cause cause) {
        return null;
    }

    @Override
    public Cause getCauseById(Long id) {
        return null;
    }

    @Override
    public void deleteCause(Long id) {

    }

}
