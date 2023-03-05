package com.mfbilgin.kodlama.io.devs.dataAccess;

import com.mfbilgin.kodlama.io.devs.entities.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
    @Query("From Framework where language.id=:languageId")
    List<Framework> getByLanguageId(int languageId);
}
