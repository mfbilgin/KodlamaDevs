package com.mfbilgin.kodlama.io.devs.dataAccess;

import com.mfbilgin.kodlama.io.devs.entities.Framework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
    boolean existsByName(String name);
    //boolean existsByLanguage(ProgramingLanguage language);
    List<Framework> findAllByLanguage_Id(int languageId);
}
