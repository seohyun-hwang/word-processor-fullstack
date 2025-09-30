package com.backend_wordProcessor1Java.backend.repositories;

import com.backend_wordProcessor1Java.backend.models.TextCharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TextCharacterRepository extends JpaRepository<TextCharacterModel, Integer> {

}
