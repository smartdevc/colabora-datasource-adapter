package cl.colabora.service.impl;

import cl.colabora.model.Cause;
import cl.colabora.repository.CauseRepository;
import cl.colabora.service.CauseService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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
        Optional<Cause> causeFinded= causeRepository.findById(cause.getId());
        if(causeFinded.isPresent()){
            Cause causeUpdated = causeFinded.get();
            causeUpdated.setName(cause.getName());
            causeUpdated.setDescription(cause.getDescription());
            causeRepository.save(causeUpdated);
            return causeUpdated;
        }else {
            throw new NoResultException("Cause with id" + cause.getId() + "was not found");
        }
    }

    @Override
    public Cause getCauseById(Long id) {
        Optional<Cause> cause = causeRepository.findById(id);
        if(cause.isPresent()){
            return cause.get();
        }else {
            throw new NoResultException("Cause with id" + id + "was not found");
        }
    }

    @Override
    public void deleteCause(Long id) {
        Optional<Cause> cause = causeRepository.findById(id);
        if(cause.isPresent()){
            causeRepository.delete(cause.get());
        }else {
            throw new NoResultException("Cause with id" + id + "was not found");
        }
    }

}
