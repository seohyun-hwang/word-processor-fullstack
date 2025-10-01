package com.backend_wordProcessor1Java.backend;

public class MainCharArray {
    private Character characterInFocus;
    private Byte appliedBolding;
    private Byte appliedItalic;
    private Byte appliedUnderline;
    private String appliedTextColor;
    private String appliedHighlightColor;
    private String appliedTypeface;
    private Integer leftward_ilili; // "ilili" = "inLinkedList"
    private Integer rightward_ilili;
    private Boolean isLastChar_ofLine;

    public MainCharArray(
            Character characterInFocus,
            Byte appliedBolding, Byte appliedItalic, Byte appliedUnderline, String appliedTextColor, String appliedHighlightColor, String appliedTypeface,
            Integer leftward_ilili, Integer rightward_ilili, Boolean isLastChar_ofLine)
    {
        this.characterInFocus = characterInFocus;
        this.appliedBolding = appliedBolding;
        this.appliedItalic = appliedItalic;
        this.appliedUnderline = appliedUnderline;
        this.appliedTextColor = appliedTextColor;
        this.appliedHighlightColor = appliedHighlightColor;
        this.appliedTypeface = appliedTypeface;
        this.leftward_ilili = leftward_ilili;
        this.rightward_ilili = rightward_ilili;
        this.isLastChar_ofLine = isLastChar_ofLine;
    }

    // Getters/Setters
    public Character getCharacterInFocus() { //
        return characterInFocus;
    }
    public void setCharacterInFocus(Character characterInFocus) {
        this.characterInFocus = characterInFocus;
    }

    public Byte getAppliedBolding() {
        return appliedBolding;
    }
    public void setAppliedBolding(Byte appliedBolding) {
        this.appliedBolding = appliedBolding;
    }

    public Byte getAppliedItalic() {
        return appliedItalic;
    }
    public void setAppliedItalic(Byte appliedItalic) {
        this.appliedItalic = appliedItalic;
    }

    public Byte getAppliedUnderline() {
        return appliedUnderline;
    }
    public void setAppliedUnderline(Byte appliedUnderline) {
        this.appliedUnderline = appliedUnderline;
    }

    public String getAppliedTextColor() { //
        return appliedTextColor;
    }
    public void setAppliedTextColor(String appliedTextColor) {
        this.appliedTextColor = appliedTextColor;
    }

    public String getAppliedHighlightColor() { //
        return appliedHighlightColor;
    }
    public void setAppliedHighlightColor(String appliedHighlightColor) {
        this.appliedHighlightColor = appliedHighlightColor;
    }

    public String getAppliedTypeface() { //
        return appliedTypeface;
    }
    public void setAppliedTypeface(String appliedTypeface) {
        this.appliedTypeface = appliedTypeface;
    }

    public Integer getLeftward_ilili() { //
        return leftward_ilili;
    }
    public void setLeftward_ilili(Integer leftward_ilili) {
        this.leftward_ilili = leftward_ilili;
    }

    public Integer getRightward_ilili() { //
        return rightward_ilili;
    }
    public void setRightward_ilili(Integer rightward_ilili) {
        this.rightward_ilili = rightward_ilili;
    }

    public Boolean getIsLastChar_ofLine() {
        return isLastChar_ofLine;
    }
    public void setIsLastChar_ofLine(Boolean isLastChar_ofLine) {
        this.isLastChar_ofLine = isLastChar_ofLine;
    }
}
