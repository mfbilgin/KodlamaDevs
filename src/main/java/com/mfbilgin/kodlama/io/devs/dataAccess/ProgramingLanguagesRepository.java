package com.mfbilgin.kodlama.io.devs.dataAccess;

import com.mfbilgin.kodlama.io.devs.entities.ProgramingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramingLanguagesRepository extends JpaRepository<ProgramingLanguage,Integer>{
    @Query(value = "select case when count(p)>0 then true else false end from ProgramingLanguage p where p.name=:name")
    boolean existsByName(String name);
}
