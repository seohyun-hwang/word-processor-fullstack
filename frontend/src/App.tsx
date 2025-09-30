import { useState } from 'react'
import Header from './outline/Header.tsx';
import './App.css'
import OverallTextManager from "./components/1OverallTextManager.tsx";


let latestMainCharArrayIndex:number = 2; // 0 for head; 1 for tail

let positionsOfSelectedChars:number[][]; // [user][singleton-globalCharIndex][singleton-mainCharArrayIndex]

let pointersTo_variousChars:number[][][][][]; // [page][local-lineIndex][local-wordIndex][local-charIndex][singleton-globalCharIndex][singleton-mainCharArrayIndex]
let positionOfCursor_globalCharIndex:number[][]; // [user][singleton-globalCharIndex][singleton-mainCharArrayIndex]



function App() {

  return (
      <>
        <Header/>
        <OverallTextManager/>
      </>
  )
}

function deleteSelectedChars(positionsOfDeletedChars:number[]):void {
    // update a specific word + destroy a character element
    // if deleted is a whitespace, append the characters after to the previous word
    // after the update is fully complete, completely re-display all the proceeding characters
}
function insertChars(insertedChars:string[], positionOfInsertion:number, positionsOfDeletedChars:number[]): void {
    // update a specific word + create a character element
    // if inserted is a whitespace, treat the characters after as a new word
    // after the update is fully complete, completely re-display all the proceeding characters
}
function undo_aModification():void {
    // update a specific word
    // after the update is fully complete, completely re-display all the proceeding characters of the frontmost character
}
function redo_anUndoneModification():void {
    // update a specific word
    // after the update is fully complete, completely re-display all the proceeding characters of the frontmost character
}


function copySelectedChars(userIndex:number, positionsOfCopiedChars:number[], positionsOfDeletedChars:number[]):void {
    if (positionsOfCopiedChars !== null) {
        // update a specific word
        // after the update is fully complete, completely re-display all the proceeding characters of the frontmost character
    }

}
function pasteCopiedChars(userIndex:number, positionOfInsertion:number, positionsOfDeletedChars:number[]):void {
    // update a specific word
    // after the update is fully complete, completely re-display all the proceeding characters of the frontmost character
}

function reStyleSelectedChar_bold(positionOfSelectedChar:number, appliedBolding:number):void {
    // update specific characters
}
function reStyleSelectedChar_italic(positionOfSelectedChar:number, appliedItalic:number):void {
    // update specific characters
}
function reStyleSelectedChar_underline(positionOfSelectedChar:number, appliedUnderline:number):void {
    // update specific characters
}
function reStyleSelectedChar_typeface(positionOfSelectedChar:number, appliedTypeface:string):void {
    // update specific characters
}
function reColorSelectedChar_text(positionOfSelectedChar:number, appliedTextColor:string):void {
    // update specific characters
}
function reColorSelectedChar_highlight(positionOfSelectedChar:number, appliedHighlightColor:string):void {
    // update specific characters
}


function getCharacterInFocus(mainArrayIndex:number):string {
    let characterInFocus:string;

    return characterInFocus;
}
function getLeftward_ilili(mainArrayIndex:number):number {
    let leftward_ilili:number;

    return leftward_ilili;
}
function getRightward_ilili(mainArrayIndex:number):number {
    let rightward_ilili:number;

    return rightward_ilili;
}

function getAppliedBolding(mainArrayIndex:number):number {
    let appliedBolding:number;

    return appliedBolding;
}
function getAppliedItalic(mainArrayIndex:number):number {
    let appliedItalic:number;

    return appliedItalic;
}
function getAppliedUnderline(mainArrayIndex:number):number {
    let appliedUnderline:number;

    return appliedUnderline;
}
function getAppliedTypeface(mainArrayIndex:number):string {
    let appliedTypeface:number;

    return appliedTypeface;
}
function getAppliedTextColor(mainArrayIndex:number):string {
    let appliedTextColor:number;

    return appliedTextColor;
}
function getAppliedHighlightColor(mainArrayIndex:number):string {
    let appliedHighlightColor:number;

    return appliedHighlightColor;
}


export default App
