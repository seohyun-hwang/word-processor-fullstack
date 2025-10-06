package com.backend_wordProcessor1Java.backend;

import java.util.ArrayList;
import java.util.List;

public class MainUserArray {

        private final short undoCount_ceiling = 256; // 2^8
        private short undoCount = 0;

        private List<Integer> modificationPositionStack;
        private List<String> modificationTypeStack;
        private List<Character> copiedCharStack = new ArrayList<>();

        public MainUserArray(
                ArrayList<Integer> modificationPositionStack,
                ArrayList<String> modificationTypeStack)
        {
                this.modificationPositionStack = modificationPositionStack;
                this.modificationTypeStack = modificationTypeStack;
        }

        // Getters/Setters
        public Short getUndoCount_ceiling() {
                return undoCount_ceiling;
        }

        public Short getUndoCount() {
                return undoCount;
        }
        public void setUndoCount(short undoCount) {
                this.undoCount = undoCount;
        }

        public List<Integer> getModificationPositionStack() {
                return modificationPositionStack;
        }
        public Integer getModificationPosition_ofStack(int positionWithinStack) {
                return modificationPositionStack.get(positionWithinStack);
        }
        public void setModificationPosition_ofStack(int positionWithinStack, int modificationPosition) {
                modificationPositionStack.set(positionWithinStack, modificationPosition);
        }

        public List<String> getModificationTypeStack() {
                return modificationTypeStack;
        }
        public String getModificationType_ofStack(int positionWithinStack) {
                return modificationTypeStack.get(positionWithinStack);
        }
        public void setModificationType_ofStack(int positionWithinStack, String modificationType) {
                modificationTypeStack.set(positionWithinStack, modificationType);
        }

        public List<Character> getCopiedCharsList() {
                return copiedCharStack;
        }
        public Character getCopiedChar(int positionWithinList) {
                return copiedCharStack.get(positionWithinList);
        }
        public void addCopiedChar(char copiedChar) {
                copiedCharStack.add(copiedChar);
        }
        public void clearCopiedChars() {
                copiedCharStack.clear();
        }
}
