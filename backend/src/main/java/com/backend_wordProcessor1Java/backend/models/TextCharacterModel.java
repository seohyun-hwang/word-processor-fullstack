package com.backend_wordProcessor1Java.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Getter
@Setter
public class TextCharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int position_ilili; // staring from 0, excl. head/tail; "ilili" = "inLinkedList"

    private Character characterInFocus;
    private Byte appliedBolding;
    private Byte appliedItalic;
    private Byte appliedUnderline;
    private String appliedTextColor;
    private String appliedHighlightColor;
    private String appliedTypeface;
    private Short lineIndex;
    private Byte charWidthPx;


    // Getters/Setters (for ID)
    public int getId() {
        return position_ilili;
    }
    public void setId(int id) {
        position_ilili = id;
    }
}
