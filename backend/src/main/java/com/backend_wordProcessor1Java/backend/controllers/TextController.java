package com.backend_wordProcessor1Java.backend.controllers;

import com.backend_wordProcessor1Java.backend.BackendApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/text-control")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TextController {

        @PostMapping("/createNewUser")
        public static HttpStatus createNewUser() {
                try {
                        BackendApplication.createNewElement_mainUserArray(1);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        //-----------------------

        @PostMapping("/insertChar/user={userIndex}&poi={positionOfInsertion}$insChar={insertedChar}&cfop={doesCharFlowOffPage}&charWidthPx={charWidthPx}&charHeightPx={charHeightPx}")
        public static HttpStatus insertChar(
                @PathVariable("userIndex") Byte userIndex,
                @PathVariable("insertedChar") String insertedChar, @PathVariable("positionOfInsertion") Integer positionOfInsertion,
                @PathVariable("charWidthPx") Byte charWidthPx, @PathVariable("charHeightPx") Byte charHeightPx)
        {
                try {
                        BackendApplication.insertChar(userIndex, insertedChar.charAt(0), positionOfInsertion, charWidthPx, charHeightPx);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/deleteChar/user={userIndex}&poi={positionOfDeletedChar}")
        public static HttpStatus deleteChar(
                @PathVariable("userIndex") Byte userIndex,
                @PathVariable("positionOfDeletedChar") Integer positionOfDeletedChar)
        {
                try {
                        BackendApplication.deleteChar(userIndex, positionOfDeletedChar);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/undo_aModification/user={userIndex}")
        public static HttpStatus undo_aModification(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        BackendApplication.undo_aModification(userIndex);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("redo_anUndoneModification/user={userIndex}")
        public static HttpStatus redo_anUndoneModification(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        BackendApplication.redo_anUndoneModification(userIndex);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        //-----------------------

        @GetMapping("getUndoModificationType/user={userIndex}")
        public static ResponseEntity<Byte> getUndoModificationType(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.getUndoModificationType(userIndex), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("getUndoModificationPosition/user={userIndex}")
        public static ResponseEntity<Integer> getUndoModificationPosition(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.getUndoModificationPosition(userIndex), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("getRedoModificationType/user={userIndex}")
        public static ResponseEntity<Byte> getRedoModificationType(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.getRedoModificationType(userIndex), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("getRedoModificationPosition/user={userIndex}")
        public static ResponseEntity<Integer> getRedoModificationPosition(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.getRedoModificationPosition(userIndex), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        //-----------------------

        @PutMapping("/clearCopiedCharStack/user={userIndex}")
        public static HttpStatus clearCopiedCharStack(
                @PathVariable("userIndex") Byte userIndex)
        {
                try {
                        BackendApplication.clearCopiedCharStack(userIndex);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/addToCopiedCharStack/user={userIndex}&pocc={positionOfCopiedChar}")
        public static HttpStatus addToCopiedCharStack(
                @PathVariable("userIndex") Byte userIndex,
                @PathVariable("positionOfCopiedChar") Integer positionOfCopiedChar)
        {
                try {
                        BackendApplication.addToCopiedCharStack(userIndex, positionOfCopiedChar);
                        return HttpStatus.CREATED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        //-----------------------

        @PutMapping("/reStyleSelectedChar_bold/posc={positionOfSelectedChar}&bolding={appliedBolding}")
        public static HttpStatus reStyleSelectedChar_bold(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedBolding") Byte appliedBolding)
        {
                try {
                        BackendApplication.reStyleSelectedChar_bold(positionOfSelectedChar, appliedBolding);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reStyleSelectedChar_italic/posc={positionOfSelectedChar}&italic={appliedItalic}")
        public static HttpStatus reStyleSelectedChar_italic(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedItalic") Byte appliedItalic)
        {
                try {
                        BackendApplication.reStyleSelectedChar_italic(positionOfSelectedChar, appliedItalic);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reStyleSelectedChar_underline/posc={positionOfSelectedChar}&underline={appliedUnderline}")
        public static HttpStatus reStyleSelectedChar_underline(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedUnderline") Byte appliedUnderline)
        {
                try {
                        BackendApplication.reStyleSelectedChar_underline(positionOfSelectedChar, appliedUnderline);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reStyleSelectedChar_typeface/posc={positionOfSelectedChar}&typeface={appliedTypeface}&charWidthPxDefault={charWidthPxDefault}")
        public static HttpStatus reStyleSelectedChar_typeface(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedTypeface") String appliedTypeface,
                @PathVariable("charWidthPxDefault") Byte charWidthPxDefault)
        {
                try {
                        BackendApplication.reStyleSelectedChar_typeface(positionOfSelectedChar, appliedTypeface, charWidthPxDefault);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reStyleSelectedChar_heightInPx/posc={positionOfSelectedChar}&charHeightPx={charHeightPx}")
        public static HttpStatus reStyleSelectedChar_heightInPx(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedCharHeightPx") Byte charHeightPx)
        {
                try {
                        BackendApplication.reStyleSelectedChar_heightInPx(positionOfSelectedChar, charHeightPx);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reColorSelectedChar_text/posc={positionOfSelectedChar}&textColor={appliedTextColor}")
        public static HttpStatus reColorSelectedChar_text(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedTextColor") String appliedTextColor)
        {
                try {
                        BackendApplication.reColorSelectedChar_text(positionOfSelectedChar, appliedTextColor);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        @PutMapping("/reColorSelectedChar_highlight/posc={positionOfSelectedChar}&highlightColor={appliedHighlightColor}")
        public static HttpStatus reColorSelectedChar_highlight(
                @PathVariable("positionOfSelectedChar") Integer positionOfSelectedChar,
                @PathVariable("appliedHighlightColor") String appliedHighlightColor)
        {
                try {
                        BackendApplication.reColorSelectedChar_highlight(positionOfSelectedChar, appliedHighlightColor);
                        return HttpStatus.ACCEPTED;
                } catch (Exception e) {
                        e.printStackTrace();
                        return HttpStatus.BAD_REQUEST;
                }
        }

        //-----------------------

        @GetMapping("/getCharacterInFocus/mcai={mainCharArrayIndex}")
        public static ResponseEntity<String> getCharacterInFocus(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getCharacterInFocus().toString(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getLeftward_ilili/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getLeftward_ilili(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getLeftward_ilili(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getRightward_ilili/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getRightward_ilili(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getRightward_ilili(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getLineInex/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getLineIndex(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>((int)(BackendApplication.mainCharArray.get(mainCharArrayIndex).getLineIndex()), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getCharWidthPx/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getCharWidthPxDefault(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>((int)(BackendApplication.mainCharArray.get(mainCharArrayIndex).getCharWidthPxDefault()), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        //-----------------------

        @GetMapping("/getAppliedBolding/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getAppliedBolding(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>((int)(BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedBolding()), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getAppliedItalic/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getAppliedItalic(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>((int)(BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedItalic()), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getAppliedUnderline/mcai={mainCharArrayIndex}")
        public static ResponseEntity<Integer> getAppliedUnderline(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>((int) (BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedUnderline()), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getAppliedTypeface/mcai={mainCharArrayIndex}")
        public static ResponseEntity<String> getAppliedTypeface(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedTypeface(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getAppliedTextColor/mcai={mainCharArrayIndex}")
        public static ResponseEntity<String> getAppliedTextColor(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedTextColor(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }

        @GetMapping("/getAppliedHighlightColor/mcai={mainCharArrayIndex}")
        public static ResponseEntity<String> getAppliedHighlightColor(
                @PathVariable("mainCharArrayIndex") Integer mainCharArrayIndex)
        {
                try {
                        return new ResponseEntity<>(BackendApplication.mainCharArray.get(mainCharArrayIndex).getAppliedHighlightColor(), HttpStatus.OK);
                } catch (Exception e) {
                        e.printStackTrace();
                        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
        }
}