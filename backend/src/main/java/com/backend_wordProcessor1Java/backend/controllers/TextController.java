package com.backend_wordProcessor1Java.backend.controllers;

import com.backend_wordProcessor1Java.backend.BackendApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/text-control")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TextController {

    @PostMapping("/createNewUser")
    public static void createNewUser() {
        BackendApplication.createNewElement_mainUserArray(1);
    }

    @PutMapping("/deleteSelectedChars/user={userIndex}&podc={positionOfDeletedChar}")
    public static void deleteSelectedChars(@PathVariable("userIndex") Byte userIndex, @PathVariable("positionOfDeletedChar") Integer positionOfDeletedChar) {
        BackendApplication.deleteChar(userIndex, positionOfDeletedChar);
    }
    @PostMapping("/insertChar/user={userIndex}&poi={positionOfInsertion}$insChar={insertedChar}&cfop={doesCharFlowOffPage}")
    public static void insertChar(@PathVariable("userIndex") Byte userIndex, @PathVariable("insertedChar") String insertedChar, @PathVariable("positionOfInsertion") Integer positionOfInsertion, @PathVariable("doesCharFlowOffPage") Boolean doesCharFlowOffPage) {
        BackendApplication.insertChar(userIndex, insertedChar.charAt(0), positionOfInsertion, doesCharFlowOffPage);
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
    @GetMapping("/getCopiedChars/user={userIndex}")
    public static List<Character> getCopiedCharsList(@PathVariable("userIndex") Byte userIndex) {
        return BackendApplication.mainUserArray.get(userIndex).getCopiedCharsList();
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

    @GetMapping("/get/mcai={mainCharArrayIndex}")
    public static boolean getIsLastChar_ofLine(@PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex) {
        return BackendApplication.mainCharArray.get(mainCharArrayIndex).getIsLastChar_ofLine();
    }
}
