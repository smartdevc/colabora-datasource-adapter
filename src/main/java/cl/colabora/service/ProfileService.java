package cl.colabora.service;


import cl.colabora.model.Profile;

import java.util.List;

public interface ProfileService {


    Profile createProfile(Profile profile);

    List<Profile> getAllProfile();

    Profile updateProfile(Profile profile);

    Profile getProfileById(Long id);

    void deleteProfile(Long id);
}
