var input = document.getElementById('guess'); // the input box
var button = document.getElementById('button'); // the button
var guess;

// change css class
var changeClass = function(cng, old, newClass){
    cng.className = cng.className.replace(old, newClass);
}
// game loop
function gameloop(){
    var rand = quicklist[Math.floor(Math.random() * quicklist.length)].toUpperCase();
    var hasDuplicates = (/([a-zA-Z]).*?\1/).test(rand);
    console.log(rand)

    var pressn = 1;


    var getAllIndexes = function(arr, val) {
        var indexes = [], i;
        for(i = 0; i < arr.length; i++)
            if (arr[i] === val)
                indexes.push(i);
        return indexes;
    }

    document.addEventListener("DOMContentLoaded", function(event) {
        var firstletter = document.getElementById("row1")
    console.log(firstletter)
     firstletter.firstElementChild.innerHTML=rand[0];
    });

    window.onload = function(){
        console.log(document.getElementById("guess").innerHTML)

    document.getElementById("guess").onkeypress = function submitguess(event) {
        if (event.key === "Enter") {
            document.getElementById('smallMsg').innerHTML = "Green = correct letter, Yellow = wrong place"; // reset message
            guess = document.getElementById("guess").value.toUpperCase();

            var current = "row" + pressn;

            var childDivs = document.getElementById(current).getElementsByTagName('div');
            var c = 0;


            if(guess.length !== 5){
                document.getElementById('smallMsg').innerHTML = "Guesses must be 5 letters!";
                if(pressn===5){
                    end("Sorry, you lost.", "Correct word: " + rand);
                }
                pressn++;
                document.getElementById(current).firstElementChild.innerHTML=rand[0];
                return;
            }

            for(var i=0; i<childDivs.length; i++) {
                childDivs[i].innerHTML = guess[i];

                if(guess[i] === rand[i]){
                    changeClass(childDivs[i], 'default', 'correct');
                    c++;
                }

                document.getElementById("guess").value = ""; // clear input box

                if(c===5) {
                    end("Congrats, you won!", "Play Again?");
                }
                else if (pressn === 5){ // if they're out of tries
                    end("Sorry, you lost.", "Correct word: " + rand);
                }
            }


            for(var i=0; i<childDivs.length; i++) {
                if(rand.indexOf(guess[i])!==-1){
                    if(hasDuplicates === false && childDivs[rand.indexOf(guess[i])].className !== "square correct"){
                        changeClass(childDivs[i], 'default', 'wrongplace');
                    }

                    else if(hasDuplicates === true){
                        var ind = getAllIndexes(rand, guess[i]);
                        if (ind.length > 1){
                            for (var j=0; j<ind.length; j++){
                                if(childDivs[ind[j]].className !== "square correct" && childDivs[i].className !== "square wrongplace"){
                                    changeClass(childDivs[i], 'default', 'wrongplace');
                                }
                            }
                        }
                        else if (childDivs[rand.indexOf(guess[i])].className !== "square correct"){
                            changeClass(childDivs[i], 'default', 'wrongplace');
                        }
                    }
                }
            }

            pressn++;
        }
    }
    };
}

var end = function(msg, smallmsg){
    document.getElementById('msgBox').innerHTML = msg;
    document.getElementById('smallMsg').innerHTML = smallmsg;
    changeClass(document.getElementById('button').button, "invisible", "visible");
    document.getElementById('guess').readOnly = true;
}

var playagain = function(){
    location.reload();
};

const userAction = async () => {
    const response = await fetch('https://nameless-stream-41681.herokuapp.com/WordAPI/words');
    const myJson = await response.json();
    console.log(myJson)

}


gameloop();
