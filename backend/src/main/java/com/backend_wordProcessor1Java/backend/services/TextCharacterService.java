package com.backend_wordProcessor1Java.backend.services;

import com.backend_wordProcessor1Java.backend.MainCharArray;
import com.backend_wordProcessor1Java.backend.repositories.TextCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextCharacterService {

    @Autowired
    private TextCharacterRepository textCharacterRepository;

    public void save_mainArrayToDatabaseColumn(List<MainCharArray> mainCharArray) {

    }
    public MainCharArray getDatabaseDataById(int id) {

        return new MainCharArray(null, null, null, null, null, null, null, null, null, null);
    }


}
