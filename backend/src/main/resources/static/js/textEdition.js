const mainCharArrayIndex_ofGraphicalChar:number[] = [];
const pointerToFirstCharOfLine:number[] = [];
let cursorIndex_mainCharArrayIndex = 1;
let cursorIndex_firstCharOfLine = 1;

let mainCharArray_pixelPositionX:number[] = [];
let mainCharArray_pixelPositionY:number[] = [];
let firstCharOfLine_pixelPositionY:number[] = [];


function leftArrowPressed():void {
    if (cursorIndex_mainCharArrayIndex != cursorIndex_firstCharOfLine) {

    } else if (cursorIndex_mainCharArrayIndex == cursorIndex_firstCharOfLine && cursorIndex_mainCharArrayIndex != 0) {

    }
}
function rightArrowPressed():void {

}
function upArrowPressed():void {

}
function downArrowPressed():void {

}
function leftClick():void {

}

function insertChar() {

}
function deleteChar() {

}
function undo() {

}
function redo() {

}

//External-file text-loading
function loadTextFromExternalFile(filename) {
    fetch(filename).then(function (response) {
        return response;
    }).then(function (data) {
        return data.text();
    }).then(function(fileContents) {
        document.getElementById("external-text-display").innerHTML = fileContents;
    }).catch(function (error) {
        console.log('Fetch problem: ' + error.message);
    })
}
