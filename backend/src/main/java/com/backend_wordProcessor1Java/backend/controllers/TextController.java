package com.backend_wordProcessor1Java.backend.controllers;

import com.backend_wordProcessor1Java.backend.BackendApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/text-control")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TextController {

    @PostMapping("/createNewUser")
    public static void createNewUser() {
        BackendApplication.createNewElement_mainUserArray(1);
    }

    @PutMapping("/deleteSelectedChars/user={userIndex}")
    public static void deleteSelectedChars(@PathVariable("userIndex") Byte userIndex, int[] positionsOfDeletedChars) {
        for (int i = 0; i < positionsOfDeletedChars.length; i++) {
            BackendApplication.deleteChar(userIndex, positionsOfDeletedChars[i]);
        }
    }
    @PostMapping("/insertChars/user={userIndex}&poi={positionOfInsertion}")
    public static void insertChars(@PathVariable("userIndex") Byte userIndex, String[] insertedChars, @PathVariable("positionOfInsertion") Integer positionOfInsertion) {

        char[] insertedChars_charType = BackendApplication.convertStringToChar_array(insertedChars);

        for (int i = 0; i < insertedChars.length; i++) {
            BackendApplication.insertChar(userIndex, insertedChars_charType[i], positionOfInsertion);
        }
    }
    @PutMapping("/undo_aModification/user={userIndex}")
    public static void undo_aModification(@PathVariable("userIndex") Byte userIndex) {
        BackendApplication.undo_aModification(userIndex);
    }
    @PutMapping("redo_anUndoneModification/user={userIndex}")
    public static void redo_anUndoneModification(@PathVariable("userIndex") Byte userIndex) {
        BackendApplication.redo_anUndoneModification(userIndex);
    }

    @PutMapping("/copySelectedChars/user={userIndex}")
    public static void copySelectedChars(@PathVariable("userIndex") Byte userIndex, int[] positionsOfCopiedChars) {
        BackendApplication.copySelectedChars(userIndex, positionsOfCopiedChars);
    }
    @PutMapping("/pasteCopiedChars/user={userIndex}&poi={positionOfInsertion}")
    public static void pasteCopiedChars(@PathVariable("userIndex") Byte userIndex, @PathVariable("positionOfInsertion") Integer positionOfInsertion) {
        BackendApplication.pasteCopiedChars(userIndex, positionOfInsertion);
    }


    @PutMapping("/reStyleSelectedChar_bold/posc={positionOfSelectedChar}&bolding={appliedBolding}")
    public static void reStyleSelectedChar_bold(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedBolding") Byte appliedBolding) {
        BackendApplication.reStyleSelectedChar_bold(positionOfSelectedChar, appliedBolding);
    }
    @PutMapping("/reStyleSelectedChar_italic/posc={positionOfSelectedChar}&italic={appliedItalic}")
    public static void reStyleSelectedChar_italic(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedItalic") Byte appliedItalic) {
        BackendApplication.reStyleSelectedChar_italic(positionOfSelectedChar, appliedItalic);
    }
    @PutMapping("/reStyleSelectedChar_underline/posc={positionOfSelectedChar}&underline={appliedUnderline}")
    public static void reStyleSelectedChar_underline(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedUnderline") Byte appliedUnderline) {
        BackendApplication.reStyleSelectedChar_underline(positionOfSelectedChar, appliedUnderline);
    }
    @PutMapping("/reStyleSelectedChar_typeface/posc={positionOfSelectedChar}&typeface={appliedTypeface}")
    public static void reStyleSelectedChar_typeface(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedTypeface") String appliedTypeface) {
        BackendApplication.reStyleSelectedChar_typeface(positionOfSelectedChar, appliedTypeface);
    }
    @PutMapping("/reColorSelectedChar_text/posc={positionOfSelectedChar}&textColor={appliedTextColor}")
    public static void reColorSelectedChar_text(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedTextColor") String appliedTextColor) {
        BackendApplication.reColorSelectedChar_text(positionOfSelectedChar, appliedTextColor);
    }
    @PutMapping("/reColorSelectedChar_highlight/posc={positionOfSelectedChar}&highlightColor={appliedHighlightColor}")
    public static void reColorSelectedChar_highlight(@PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar, @PathVariable("appliedHighlightColor") String appliedHighlightColor) {
        BackendApplication.reColorSelectedChar_highlight(positionOfSelectedChar, appliedHighlightColor);
    }

    @GetMapping("/getCharacterInFocus/mcai={mainCharArrayIndex}")
    public static String getCharacterInFocus(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getCharacterInFocus().toString();
    }

    @GetMapping("/getLeftward_ilili/mcai={mainCharArrayIndex}")
    public static int getLeftward_ilili(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getLeftward_ilili();
    }

    @GetMapping("/getRightward_ilili/mcai={mainCharArrayIndex}")
    public static int getRightward_ilili(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getRightward_ilili();
    }

    @GetMapping("/getAppliedBolding/mcai={mainCharArrayIndex}")
    public static int getAppliedBolding(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedBolding();
    }

    @GetMapping("/getAppliedItalic/mcai={mainCharArrayIndex}")
    public static int getAppliedItalic(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedItalic();
    }

    @GetMapping("/getAppliedUnderline/mcai={mainCharArrayIndex}")
    public static int getAppliedUnderline(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedUnderline();
    }

    @GetMapping("/getAppliedTypeface/mcai={mainCharArrayIndex}")
    public static String getAppliedTypeface(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedTypeface();
    }

    @GetMapping("/getAppliedTextColor/mcai={mainCharArrayIndex}")
    public static String getAppliedTextColor(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedTextColor();
    }

    @GetMapping("/getAppliedHighlightColor/mcai={mainCharArrayIndex}")
    public static String getAppliedHighlightColor(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedHighlightColor();
    }
}
