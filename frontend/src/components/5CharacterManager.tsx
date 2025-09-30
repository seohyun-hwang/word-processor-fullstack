
let cursor_position:number;

function CharacterManager() {

    const char:string;
    let char_position:number;

    return(
        <li className="text-char">
            <button onClick={()=>{cursor_position = char_position}}>{char}</button>
        </li>
    );
}

export default CharacterManager;
export cursor_position;