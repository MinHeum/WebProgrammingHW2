package com.n2015542042.main.repository;

import com.n2015542042.main.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
