package com.backend_wordProcessor1Java.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static List<MainCharArray> mainCharArray = new ArrayList<>(); // dumpster fire of characters
	static final int positionOfHead = 0; // head of DoublyLinkedList; reference to mainArray
	static final int positionOfTail = 1; // tail of DoublyLinkedList
	public static List<MainUserArray> mainUserArray = new ArrayList<>(); // dumpster fire of users

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		createNewElement_mainUserArray(1); // a userbase of 1 to start with

		// Setup: DoublyLinkedList head & tail
		createNewElement_mainCharArray(2);
		mainCharArray.get(positionOfHead).setRightward_ilili(positionOfTail);
		mainCharArray.get(positionOfTail).setLeftward_ilili(positionOfHead);
	}


	// insert/delete/style/color
	public static void insertChar(byte userIndex, char insertedChar, int positionOfInsertion) {
		print("inserting a character to the LEFT of the position-of-insertion.", true);

		createNewElement_mainCharArray(1);
		int positionOfInsertedChar = mainCharArray.size() - 1;
		mainCharArray.get(positionOfInsertedChar).setCharacterInFocus(insertedChar);

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
		modificationTrackingClearance(userIndex);
		modificationTrackingContribution(userIndex, positionOfInsertedChar, "insert");
		print("insertion successful.", true);
	}
	public static void deleteChar(byte userIndex, int positionOfDeletedElement) {
		print("deleting a character AT the position-of-deletion.", true);
		if (positionOfDeletedElement != positionOfHead) {
			if (mainCharArray.get(positionOfDeletedElement).getLeftward_ilili() == positionOfHead) {
				pairPointers(positionOfHead, mainCharArray.get(positionOfDeletedElement).getRightward_ilili());
			} else {
				pairPointers(mainCharArray.get(positionOfDeletedElement).getLeftward_ilili(), mainCharArray.get(positionOfDeletedElement).getRightward_ilili());
			}
			modificationTrackingClearance(userIndex);
			modificationTrackingContribution(userIndex, positionOfDeletedElement, "delete");
		}
		print("deletion successful.", true);
	}
	public static void reStyleSelectedChar_bold(int positionOfSelectedChar, byte appliedBolding) {
		print("updating the bolding style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedBolding(appliedBolding);
		print("bold-style-update successful.", true);
	}
	public static void reStyleSelectedChar_italic(int positionOfSelectedChar, byte appliedItalic) {
		print("updating the italic style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedItalic(appliedItalic);
		print("italic-style-update successful.", true);
	}
	public static void reStyleSelectedChar_underline(int positionOfSelectedChar, byte appliedUnderline) {
		print("updating the underline style at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedUnderline(appliedUnderline);
		print("underline-style-update successful.", true);
	}
	public static void reStyleSelectedChar_typeface(int positionOfSelectedChar, String appliedTypeface) {
		print("updating the typeface at the position-of-selected.", true);
		mainCharArray.get(positionOfSelectedChar).setAppliedTypeface(appliedTypeface);
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
	public static void copySelectedChars(byte userIndex, int[] positionsOfCopiedChars) {
		print("copying all the selected characters to the clipboard for user #" + userIndex + ".", true);
		mainUserArray.get(userIndex).clearCopiedChars();
		for (int i = 0; i < positionsOfCopiedChars.length; i++) {
			mainUserArray.get(userIndex).addCopiedChar(mainCharArray.get(positionsOfCopiedChars[i]).getCharacterInFocus());
		}
		print("copying successful for user #" + userIndex + ".", true);
	}
	public static void pasteCopiedChars(byte userIndex, int positionOfInsertion) {
		print("pasting all the copied characters from the clipboard for user #" + userIndex + ".", true);
		for (int i = 0; i < mainUserArray.get(userIndex).getCopiedCharsList().size(); i++) {
			insertChar(userIndex, mainUserArray.get(userIndex).getCopiedChar(i), positionOfInsertion);
		}
		print("pasting successful for user #" + userIndex + ".", true);
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
				int positionOfUndoneModification = mainUserArray.get(userIndex).getModificationPosition_ofStack(positionOf_latestModification - undoCount);
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
			int positionOfUndoneModification = mainUserArray.get(userIndex).getModificationPosition_ofStack(positionOf_latestModification - undoCount);
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
			mainCharArray.add(new MainCharArray(null, null, null,null, null, null, null, null, null));
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
	public static void modificationTrackingContribution(byte userIndex, int positionOfTargetedElement, String typeOf_latestModification) {
		print("making a new entry into the modification-tracking.", true);
		mainUserArray.get(userIndex).getModificationPositionStack().add(positionOfTargetedElement);
		mainUserArray.get(userIndex).getModificationTypeStack().add(typeOf_latestModification);
		print("modification-tracking successful.", true);
	}
	public static void pairPointers(int leftPart, int rightPart) {
		print("pairing pointers of two elements.", true);
		mainCharArray.get(leftPart).setRightward_ilili(rightPart);
		mainCharArray.get(rightPart).setLeftward_ilili(leftPart);
		print("pointer-pairing successful.", true);
	}
	public static char[] convertStringToChar_array(String[] stringArray) {
		char[] charArray = new char[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			charArray[i] = stringArray[i].charAt(0);
		}
		return charArray;
	}
}
