package com.backend_wordProcessor1Java.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static List<MainCharArray> mainCharArray = new ArrayList<>(); // dumpster fire of characters
	static final Integer positionOfHead = 0; // head of DoublyLinkedList; reference to mainArray
	static final Integer positionOfTail = 1; // tail of DoublyLinkedList
	public static List<Short> lineWidthPx = new ArrayList<>();
	static short lineWidthPxMax = 512; // 2^9


	public static List<MainUserArray> mainUserArray = new ArrayList<>(); // dumpster fire of users

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		createNewElement_mainUserArray(1); // a starting userbase of 1

		// Setup: DoublyLinkedList head & tail
		createNewElement_mainCharArray(2);
		mainCharArray.get(positionOfHead).setRightward_ilili(positionOfTail);
		mainCharArray.get(positionOfTail).setLeftward_ilili(positionOfHead);
		lineWidthPx.add((short) 0);
	}


	// insert/delete/style/color
	public static void insertChar(byte userIndex, Character insertedChar, Integer positionOfInsertion, Byte charWidthPx, Byte charHeightPx) {
		print("inserting a character to the LEFT of the position-of-insertion.", true);

		createNewElement_mainCharArray(1);
		Integer positionOfInsertedChar = mainCharArray.size() - 1;
		mainCharArray.get(positionOfInsertedChar).setCharacterInFocus(insertedChar);
		mainCharArray.get(positionOfInsertedChar).setCharWidthPxDefault(charWidthPx);
		mainCharArray.get(positionOfInsertedChar).setCharHeightPx(charHeightPx);

		if (mainCharArray.get(positionOfInsertion).getLeftward_ilili() == positionOfHead) {
			pairPointers(positionOfHead, positionOfInsertedChar);
			if (positionOfInsertion != positionOfTail) {
				pairPointers(positionOfInsertedChar, positionOfInsertion);
			}
		}
		if (positionOfInsertion == positionOfTail) {
			pairPointers(mainCharArray.get(positionOfInsertion).getLeftward_ilili(), positionOfInsertedChar);
			pairPointers(positionOfInsertedChar, positionOfTail);
		} else {
			if (mainCharArray.get(positionOfInsertion).getLeftward_ilili() != positionOfHead) {
				pairPointers(positionOfInsertedChar, positionOfInsertion);
			}
		}

		for (int positionOf_charInFocus = positionOfInsertedChar; positionOf_charInFocus != 1; positionOf_charInFocus = mainCharArray.get(positionOf_charInFocus).getRightward_ilili()) {
			insertCharGraphically(positionOf_charInFocus);
		}
		modificationTrackingClearance(userIndex);
		modificationTrackingContribution(userIndex, positionOfInsertedChar, "insert");
		print("insertion successful.", true);
	}
	public static void deleteChar(byte userIndex, Integer positionOfDeletedChar) {
		print("deleting a character AT the position-of-deletion.", true);
		if (positionOfDeletedChar != positionOfHead) {
			if (mainCharArray.get(positionOfDeletedChar).getLeftward_ilili() == positionOfHead) {
				pairPointers(positionOfHead, mainCharArray.get(positionOfDeletedChar).getRightward_ilili());
			} else {
				pairPointers(mainCharArray.get(positionOfDeletedChar).getLeftward_ilili(), mainCharArray.get(positionOfDeletedChar).getRightward_ilili());
			}

			for (int positionOf_charInFocus = mainCharArray.get(positionOfDeletedChar).getLeftward_ilili(); positionOf_charInFocus != 1; positionOf_charInFocus = mainCharArray.get(positionOf_charInFocus).getRightward_ilili()) {
				insertCharGraphically(positionOf_charInFocus);
			}
			modificationTrackingClearance(userIndex);
			modificationTrackingContribution(userIndex, positionOfDeletedChar, "delete");
		}
		print("deletion successful.", true);
	}
	public static void insertCharGraphically(int positionOf_charInFocus) {
		byte charWidthPx = mainCharArray.get(positionOf_charInFocus).getCharWidthPxDefault();
		byte charHeightPx = mainCharArray.get(positionOf_charInFocus).getCharHeightPx();
		short appliedCharWidthPx = (short) (charWidthPx * charHeightPx);

		if (mainCharArray.get(mainCharArray.get(positionOf_charInFocus).getLeftward_ilili()).getCharacterInFocus() == '\n') {
			mainCharArray.get(positionOf_charInFocus).setLineIndex((short) (mainCharArray.get(mainCharArray.get(positionOf_charInFocus).getLeftward_ilili()).getLineIndex() - 1));
			return;
		}
		while (mainCharArray.get(positionOf_charInFocus).getCharacterInFocus() == ' ') {
			positionOf_charInFocus = mainCharArray.get(positionOf_charInFocus).getRightward_ilili();
		}
		if (mainCharArray.get(positionOf_charInFocus).getLineIndex() == (short) (mainCharArray.get(mainCharArray.get(positionOf_charInFocus).getLeftward_ilili()).getLineIndex() - 1)) {
			return;
		}
		if (lineWidthPx.get(lineWidthPx.get((short)(mainCharArray.get(positionOf_charInFocus).getLineIndex() + 1))) != null) {
			lineWidthPx.add((short) 0);
		}
		if (lineWidthPx.get(mainCharArray.get(positionOf_charInFocus).getLineIndex()) + appliedCharWidthPx > lineWidthPxMax) {
			mainCharArray.get(positionOf_charInFocus).setLineIndex((short)(mainCharArray.get(positionOf_charInFocus).getLineIndex() + 1));
			lineWidthPx.set(mainCharArray.get(positionOf_charInFocus).getLineIndex(), (short)(lineWidthPx.get((short)(mainCharArray.get(positionOf_charInFocus).getLineIndex() + 1)) + appliedCharWidthPx));
		} else {
			mainCharArray.get(positionOf_charInFocus).setLineIndex((mainCharArray.get(positionOf_charInFocus).getLineIndex()));
			lineWidthPx.set(mainCharArray.get(positionOf_charInFocus).getLineIndex(), (short)(lineWidthPx.get(mainCharArray.get(positionOf_charInFocus).getLineIndex()) + appliedCharWidthPx));
		}
	}
	public static void reStyleSelectedChar_bold(int positionOfSelectedChar, Byte appliedBolding) {
		print("updating the bolding style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedBolding(appliedBolding);
		print("bold-style-update successful.", true);
	}
	public static void reStyleSelectedChar_italic(int positionOfSelectedChar, Byte appliedItalic) {
		print("updating the italic style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedItalic(appliedItalic);
		print("italic-style-update successful.", true);
	}
	public static void reStyleSelectedChar_underline(int positionOfSelectedChar, Byte appliedUnderline) {
		print("updating the underline style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedUnderline(appliedUnderline);
		print("underline-style-update successful.", true);
	}
	public static void reStyleSelectedChar_typeface(int positionOfSelectedChar, String appliedTypeface, Byte charWidthPxDefault) {
		print("updating the typeface at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedTypeface(appliedTypeface);
		mainCharArray.get(positionOfSelectedChar).setCharWidthPxDefault(charWidthPxDefault);
		print("typeface-update successful.", true);
	}
	public static void reStyleSelectedChar_heightInPx(int positionOfSelectedChar, Byte appliedCharHeightPx) {
		print("updating the typeface at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setCharHeightPx(appliedCharHeightPx);
		print("typeface-update successful.", true);
	}
	public static void reColorSelectedChar_text(int positionOfSelectedChar, String appliedTextColor) {
		print("updating the text-color at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedTextColor(appliedTextColor);
		print("text-color-update successful.", true);
	}
	public static void reColorSelectedChar_highlight(int positionOfSelectedChar, String appliedHighlightColor) {
		print("updating the highlight-color at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedHighlightColor(appliedHighlightColor);
		print("highlight-color-update successful.", true);
	}


	// copy/paste/undo/redo
	public static void clearCopiedCharStack(byte userIndex) {
		print("clearing the clipboard for user #" + userIndex + ".", true);
		mainUserArray.get(userIndex).clearCopiedChars();
		print("clipboard clearance successful for user #" + userIndex + ".", true);
	}
	public static void addToCopiedCharStack(byte userIndex, int positionOfCopiedChar) {
		print("adding a selected characters to the clipboard for user #" + userIndex + ".", true);
		mainUserArray.get(userIndex).addCopiedChar(mainCharArray.get(positionOfCopiedChar).getCharacterInFocus());
		print("copying successful for user #" + userIndex + ".", true);
	}
	public static void undo_aModification(byte userIndex) {
		print("undoing a modification.", true);
		if (!mainUserArray.get(userIndex).getModificationTypeStack().isEmpty() && (mainUserArray.get(userIndex).getModificationTypeStack().size() - mainUserArray.get(userIndex).getUndoCount()) > 0 && mainCharArray.size() > 2) {
			if (mainUserArray.get(userIndex).getUndoCount() < mainUserArray.get(userIndex).getUndoCount_ceiling()) {
				print("undo-count (before undo): " + mainUserArray.get(userIndex).getUndoCount(), true);
				print("modification-type stack size: " + mainUserArray.get(userIndex).getModificationTypeStack().size(), true);

				int positionOf_latestModification = mainUserArray.get(userIndex).getModificationTypeStack().size() - 1;
				short undoCount = mainUserArray.get(userIndex).getUndoCount();

				String typeOfUndoneModification = mainUserArray.get(userIndex).getModificationType_ofStack(positionOf_latestModification - undoCount);
				Integer positionOfUndoneModification = mainUserArray.get(userIndex).getModificationPosition_ofStack(positionOf_latestModification - undoCount);
				if (typeOfUndoneModification.equalsIgnoreCase("insert")) {
					if (mainCharArray.get(positionOfUndoneModification).getLeftward_ilili() == positionOfHead) {
						pairPointers(positionOfHead, mainCharArray.get(positionOfUndoneModification).getRightward_ilili());
					} else {
						pairPointers(mainCharArray.get(positionOfUndoneModification).getLeftward_ilili(), mainCharArray.get(positionOfUndoneModification).getRightward_ilili());
					}
				} else if (typeOfUndoneModification.equalsIgnoreCase("delete")) {
					mainCharArray.get(
							mainCharArray.get(positionOfUndoneModification).getRightward_ilili()
					).setLeftward_ilili(positionOfUndoneModification);

					mainCharArray.get(
							mainCharArray.get(positionOfUndoneModification).getLeftward_ilili()
					).setRightward_ilili(positionOfUndoneModification);
				}
				undoCount++;
				for (int positionOf_charInFocus = mainCharArray.get(positionOfUndoneModification).getLeftward_ilili(); positionOf_charInFocus != 1; positionOf_charInFocus = mainCharArray.get(positionOf_charInFocus).getRightward_ilili()) {
					insertCharGraphically(positionOf_charInFocus);
				}
				print("undo-count (after undo): " + undoCount, true);
			} else {
				print("reached the maximum undo-count.", true);
			}
		} else {
			print("nothing to undo.", true);
		}
		print("undo successful.", true);
	}
	public static void redo_anUndoneModification(byte userIndex) {
		print("redoing an undone modification.", true);
		short undoCount = mainUserArray.get(userIndex).getUndoCount();
		if (mainUserArray.get(userIndex).getUndoCount() > 0) {
			mainUserArray.get(userIndex).setUndoCount((short) (undoCount - 1));
			print("undo-count (after redo): " + undoCount, true);
			print("modification-type stack size: " + mainUserArray.get(userIndex).getModificationTypeStack().size(), true);

			int positionOf_latestModification = mainUserArray.get(userIndex).getModificationTypeStack().size() - 1;
			String typeOfUndoneModification = mainUserArray.get(userIndex).getModificationType_ofStack(positionOf_latestModification - undoCount);
			Integer positionOfUndoneModification = mainUserArray.get(userIndex).getModificationPosition_ofStack(positionOf_latestModification - undoCount);
			if (typeOfUndoneModification.equalsIgnoreCase("insert")) {
				mainCharArray.get(
						mainCharArray.get(positionOfUndoneModification).getRightward_ilili()
				).setLeftward_ilili(positionOfUndoneModification);

				mainCharArray.get(
						mainCharArray.get(positionOfUndoneModification).getLeftward_ilili()
				).setRightward_ilili(positionOfUndoneModification);
			} else if (typeOfUndoneModification.equalsIgnoreCase("delete")) {
				if (mainCharArray.get(positionOfUndoneModification).getLeftward_ilili() == positionOfHead) {
					pairPointers(
							positionOfHead,
							mainCharArray.get(positionOfUndoneModification).getRightward_ilili()
					);
				} else {
					pairPointers(
							mainCharArray.get(positionOfUndoneModification).getLeftward_ilili(),
							mainCharArray.get(positionOfUndoneModification).getRightward_ilili()
					);
				}
				for (int positionOf_charInFocus = mainCharArray.get(positionOfUndoneModification).getLeftward_ilili(); positionOf_charInFocus != 1; positionOf_charInFocus = mainCharArray.get(positionOf_charInFocus).getRightward_ilili()) {
					insertCharGraphically(positionOf_charInFocus);
				}
			}
		} else {
			print("nothing to redo.", true);
		}
		print("redo successful.", true);
	}


	// miscellaneous support functions
	public static void print(Object objectToPrint, boolean addNewLineAfter) {
		// function that abbreviates System.out.print
		if (addNewLineAfter) {
			System.out.println(objectToPrint);
		} else {
			System.out.print(objectToPrint);
		}
	}
	public static void createNewElement_mainCharArray(int count) {
		// creating with all values null
		for (int i = 0; i < count; i++) {
			mainCharArray.add(new MainCharArray(null, null, null, null, null,null, null, null, null, null, null, null));
		}
	}
	public static void createNewElement_mainUserArray(int count) {
		// creating with all values null
		for (int i = 0; i < count; i++) {
			mainUserArray.add(new MainUserArray(null, null));
		}
	}
	public static void modificationTrackingClearance(byte userIndex) {
		short undoCount = mainUserArray.get(userIndex).getUndoCount();
		if (undoCount > 0 && !mainUserArray.get(userIndex).getModificationPositionStack().isEmpty()) {
			print("clearing the modification-tracking.", true);
			print("undo-count: " + undoCount, true);
			print("modification-position stack size: " + mainUserArray.get(userIndex).getModificationPositionStack().size(), true);
			print("modification-type stack size: " + mainUserArray.get(userIndex).getModificationTypeStack().size(), true);

			int positionOf_latestModification = mainUserArray.get(userIndex).getModificationPositionStack().size() - 1;
			while (mainUserArray.get(userIndex).getModificationPositionStack().size() - undoCount >= 0) {
				mainUserArray.get(userIndex).getModificationPositionStack().remove(positionOf_latestModification);
				mainUserArray.get(userIndex).getModificationTypeStack().remove(positionOf_latestModification);
			}
			undoCount = 0;
			print("clearance successful.", true);
		}
	}
	public static void modificationTrackingContribution(byte userIndex, Integer positionOfTargetedElement, String typeOf_latestModification) {
		print("making a new entry into the modification-tracking.", true);
		mainUserArray.get(userIndex).getModificationPositionStack().add(positionOfTargetedElement);
		mainUserArray.get(userIndex).getModificationTypeStack().add(typeOf_latestModification);
		print("modification-tracking successful.", true);
	}
	public static void pairPointers(Integer leftPart, Integer rightPart) {
		print("pairing pointers of two elements.", true);
		mainCharArray.get(leftPart).setRightward_ilili(rightPart);
		mainCharArray.get(rightPart).setLeftward_ilili(leftPart);
		print("pointer-pairing successful.", true);
	}
	/*
	public static char[] convertStringToChar_array(String[] stringArray) {
		char[] charArray = new char[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			charArray[i] = stringArray[i].charAt(0);
		}
		return charArray;
	}
	public static int positionOfTargetValue_byBinarySearch(int inputValue, List<Integer> targetList, byte precision) {
		int max = targetList.size() - 1;
		int min = 0;
		while (true) {
			if (targetList.get((max - min) / 2) > inputValue) {
				int tempMax = ((max - min) / 2) + ((max - min) / 4);
				if (tempMax == max && precision == 1) {
					return max;
				}
				max = tempMax;
			} else if (targetList.get((max - min) / 2) < inputValue) {
				int tempMin = (max - min) / 4;
				if (tempMin == min && precision == - 1) {
					return min;
				}
				min = tempMin;
			} else if (targetList.get((max - min) / 2) == inputValue && precision == 0) {
				return targetList.get(inputValue);
			} else {
				print("error", true);
				return -1;
			}
		}
	}
	 */
}
