package com.n2015542042.main.service;

import com.n2015542042.main.domain.Profile;
import com.n2015542042.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAllProfile() {
        return profileRepository.findAll();
    }

    public Profile findByIdxProfile(Long idx) {
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public Profile makeNewProfile(Profile profile) {
        Profile newProfile = profileRepository.save(profile);
        return newProfile;
    }

    public Profile updateBasic(Profile profile) {
        Profile updateProfile = profileRepository.save(profile);
        return profile;
    }

    public void deleteByIdxProfile(Long idx) {
        if (idx == null) System.out.println("idx cannot be null");
        else    profileRepository.deleteById(idx);
    }
}

