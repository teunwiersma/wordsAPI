var gok;
const wordList = [];

var changeClass = function(c, oud, nieuw){
    c.className = c.className.replace(oud, nieuw);
}

async function getWords(){
    const response = await fetch('https://nameless-stream-41681.herokuapp.com/WordAPI/words');
    const myJson = await response.json();
    console.log(myJson);
    JSON.stringify(myJson);
    console.log(myJson);
    myJson.forEach(word =>{
        wordList.push(word.word);
    })
}

function gameloop(){
    console.log(wordList)
    const word = wordList[Math.floor(Math.random() * wordList.length)].toUpperCase();
    const hasDuplicates = (/([a-zA-Z]).*?\1/).test(word);
    console.log(word)

    var beurtNummer = 1;


    var getAllIndexes = function(arr, val) {
        var indexes = [], i;
        for(i = 0; i < arr.length; i++)
            if (arr[i] === val)
                indexes.push(i);
        return indexes;
    }

    document.addEventListener("DOMContentLoaded", function(event) {
        var firstletter = document.getElementById("row1")
        firstletter.firstElementChild.innerHTML=word[0];
    });


    document.getElementById("gok").onkeypress = function submitGok(event) {
        if (event.key === "Enter") {
            document.getElementById('tip').innerHTML = "Groen: Letter op de goede plaats, Geel: Letter op de verkeerde plek"; // reset message
            gok = document.getElementById("gok").value.toUpperCase();

            var current = "row" + beurtNummer;

            var childDivs = document.getElementById(current).getElementsByTagName('div');
            var c = 0;

            if( word.length !== 5){
                document.getElementById("row1-6").style.visibility = "hidden";
                document.getElementById("row1-7").style.visibility = "hidden";
                document.getElementById("row2-6").style.visibility = "hidden";
                document.getElementById("row2-7").style.visibility = "hidden";
                document.getElementById("row3-6").style.visibility = "hidden";
                document.getElementById("row3-7").style.visibility = "hidden";
                document.getElementById("row4-6").style.visibility = "hidden";
                document.getElementById("row4-7").style.visibility = "hidden";
                document.getElementById("row5-6").style.visibility = "hidden";
                document.getElementById("row5-7").style.visibility = "hidden";
            }

            if(word.length === 6){
                document.getElementById(current).firstElementChild.innerHTML=word[0];
                document.getElementById("row1-7").style.visibility = "hidden";
                document.getElementById("row2-7").style.visibility = "hidden";
                document.getElementById("row3-7").style.visibility = "hidden";
                document.getElementById("row4-7").style.visibility = "hidden";
                document.getElementById("row5-7").style.visibility = "hidden";

            }

            if(word.length === 5 && gok.length !== 5 ){
                document.getElementById('tip').innerHTML = "Het wordt moet 5 letters hebben!";
                if(beurtNummer===5){
                    end("Verloren!.", "Correcte word: " + word);
                }
                beurtNummer++;
                document.getElementById(current).firstElementChild.innerHTML=word[0];
                return;

            }

            if(word.length === 7 && gok.length !== 7){
                    document.getElementById('tip').innerHTML = "Het wordt moet 5 letters hebben!";
                    if(beurtNummer===5){
                        end("Verloren!.", "Correcte word: " + word);
                    }
                    beurtNummer++;
                    document.getElementById(current).firstElementChild.innerHTML=word[0];
                    return;

            }

            if(word.length === 6 && gok.length !== 6){
                document.getElementById('tip').innerHTML = "Het wordt moet 5 letters hebben!";
                if(beurtNummer===5){
                    end("Verloren!.", "Correcte word: " + word);
                }
                beurtNummer++;

                return;
            }

            for(var x=0; x<childDivs.length; x++) {
                childDivs[x].innerHTML = gok[x];

                if(gok[x] === word[x]){
                    changeClass(childDivs[x], 'default', 'correct');
                    c++;
                }

                document.getElementById("gok").value = "";

                if(c===5) {
                    end("Gewonnen!!", "Play Again?");
                }
                else if (beurtNummer === 5){
                    end("Verloren!", "Correcte word: " + word);
                }
            }


            for(var x=0; x<childDivs.length; x++) {
                if(word.indexOf(gok[x])!==-1){
                    if(hasDuplicates === false && childDivs[word.indexOf(gok[x])].className !== "square correct"){
                        changeClass(childDivs[x], 'default', 'fout');
                    }

                    else if(hasDuplicates === true){
                        var ind = getAllIndexes(word, gok[x]);
                        if (ind.length > 1){
                            for (var y=0; y<ind.length; y++){
                                if(childDivs[ind[y]].className !== "square correct" && childDivs[y].className !== "square fout"){
                                    changeClass(childDivs[x], 'default', 'fout');
                                }
                            }
                        }
                        else if (childDivs[word.indexOf(gok[x])].className !== "square correct"){
                            changeClass(childDivs[x], 'default', 'fout');
                        }
                    }
                }
            }

            beurtNummer++;
        }
    }
}

var end = function(msg, tip){
    document.getElementById('titel').innerHTML = titel;
    document.getElementById('tip').innerHTML = tip;
    changeClass(document.getElementById('button').button, "invisible", "visible");
    document.getElementById('gok').readOnly = true;
}

var playagain = function(){
    location.reload();
};


async function startGameLoop(){
    const r = await getWords();
    gameloop();
}

startGameLoop();