package cl.colabora.service.impl;

import cl.colabora.model.Profile;
import cl.colabora.repository.ProfileRepository;
import cl.colabora.service.ProfileService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Profile> profileFinded = profileRepository.findById(profile.getId());
        if (profileFinded.isPresent()){
            Profile profileUpdated = profileFinded.get();
            profileUpdated.setName(profile.getName());
            profileRepository.save(profileUpdated);
            return profileUpdated;
        } else {
            throw new NoResultException("Profile with id" + profile.getId() + "was not found");
        }
    }

    @Override
    public Profile getProfileById(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isPresent()){
            return profile.get();
        } else {
            throw new NoResultException("Profile with id" + id + "was not found");
        }
    }

    @Override
    public void deleteProfile(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        if (profile.isPresent()){
            profileRepository.delete(profile.get());
        } else {
            throw new NoResultException("Profile with id" + id + "was not found");
        }
    }
}
