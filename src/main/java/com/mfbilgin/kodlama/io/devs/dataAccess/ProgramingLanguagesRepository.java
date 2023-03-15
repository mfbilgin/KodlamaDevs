package com.mfbilgin.kodlama.io.devs.dataAccess;

import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramingLanguagesRepository extends JpaRepository<ProgramingLanguage,Integer>{
    boolean existsByName(String name);
}
