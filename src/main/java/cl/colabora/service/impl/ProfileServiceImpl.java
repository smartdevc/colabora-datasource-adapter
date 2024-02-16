package cl.colabora.service.impl;

import cl.colabora.model.Profile;
import cl.colabora.repository.ProfileRepository;
import cl.colabora.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile getProfileById(Long id) {
        return null;
    }

    @Override
    public void deleteProfile(Long id) {

    }
}
