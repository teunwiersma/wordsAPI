var input = document.getElementById('guess'); // the input box
var button = document.getElementById('button'); // the button
var guess;

// change css class
var changeClass = function(cng, old, newClass){
    cng.className = cng.className.replace(old, newClass);
}
// game loop
function gameloop(){
    // pick a random word
    var rand = quicklist[Math.floor(Math.random() * quicklist.length)].toUpperCase();
    var hasDuplicates = (/([a-zA-Z]).*?\1/).test(rand); // if multiple insances of a letter in the word
    console.log(rand)

    var pressn = 1; // turn number

    // get all indexes of a given value in an array
    var getAllIndexes = function(arr, val) {
        var indexes = [], i;
        for(i = 0; i < arr.length; i++)
            if (arr[i] === val)
                indexes.push(i);
        return indexes;
    }
    // give first letter
    document.addEventListener("DOMContentLoaded", function(event) {
        var firstletter = document.getElementById("row1")
    console.log(firstletter)
     firstletter.firstElementChild.innerHTML=rand[0];
    });

    window.onload = function(){
        console.log(document.getElementById("guess").innerHTML)
        // guess event
    document.getElementById("guess").onkeypress = function submitguess(event) {
        if (event.key === "Enter") {
            document.getElementById('smallMsg').innerHTML = "Green = correct letter, Yellow = wrong place"; // reset message
            guess = document.getElementById("guess").value.toUpperCase();

            var current = "row" + pressn;
            // current row
            var childDivs = document.getElementById(current).getElementsByTagName('div');
            var c = 0; // correct count

            // If not right number of letters
            if(guess.length !== 5){
                document.getElementById('smallMsg').innerHTML = "Guesses must be 5 letters!";
                if(pressn===5){
                    end("Sorry, you lost.", "Correct word: " + rand);
                }
                pressn++;
                document.getElementById(current).firstElementChild.innerHTML=rand[0];
                return; // move down
            }

            // check for correctness
            for(var i=0; i<childDivs.length; i++) {
                childDivs[i].innerHTML = guess[i];

                // if letter match in right place
                if(guess[i] === rand[i]){
                    changeClass(childDivs[i], 'default', 'correct');
                    c++;
                }
                // if exists but is in the wrong place

                document.getElementById("guess").value = ""; // clear input box

                if(c===5) { // if they have all the correct letters
                    end("Congrats, you won!", "Play Again?");
                } //if
                else if (pressn === 5){ // if they're out of tries
                    end("Sorry, you lost.", "Correct word: " + rand);
                } //else if
            } //for (check for correctness loop)

            // check for wrong place
            for(var i=0; i<childDivs.length; i++) {
                if(rand.indexOf(guess[i])!==-1){
                    if(hasDuplicates === false && childDivs[rand.indexOf(guess[i])].className !== "square correct"){
                        changeClass(childDivs[i], 'default', 'wrongplace');
                    }
                    // if there are duplicate letters
                    else if(hasDuplicates === true){
                        var ind = getAllIndexes(rand, guess[i]);
                        if (ind.length > 1){
                            for (var j=0; j<ind.length; j++){
                                if(childDivs[ind[j]].className !== "square correct" && childDivs[i].className !== "square wrongplace"){
                                    changeClass(childDivs[i], 'default', 'wrongplace');
                                } //if
                            } //for
                        } //if
                        else if (childDivs[rand.indexOf(guess[i])].className !== "square correct"){
                            changeClass(childDivs[i], 'default', 'wrongplace');
                        } //else if
                    } //else if(hasDuplicates === true)
                } //else if
            }

            pressn++; // inc number of guesses
        } //if (key = 'enter')
    }
    };//input
} //gameloop

// endgame
var end = function(msg, smallmsg){
    document.getElementById('msgBox').innerHTML = msg;
    document.getElementById('smallMsg').innerHTML = smallmsg;
    changeClass(document.getElementById('button').button, "invisible", "visible");
    document.getElementById('guess').readOnly = true;
}

// reset
var playagain = function(){
    location.reload();

};

// ~500 common 5-letter words

var quicklist = ['about',
    'above',
    'abuse',
    'actor',
    'acute',
    'admit',
    'adopt',
    'adult',
    'after',
    'again',
    'agent',
    'agree',
    'ahead',
    'alarm',
    'album',
    'alert',
    'alike',
    'alive',
    'allow',
    'alone',
    'along',
    'alter',
    'among',
    'anger',
    'Angle',
    'angry',
    'apart',
    'apple',
    'apply',
    'arena',
    'argue',
    'arise',
    'array',
    'aside',
    'asset',
    'audio',
    'audit',
    'avoid',
    'award',
    'aware',
    'badly',
    'baker',
    'bases',
    'basic',
    'basis',
    'beach',
    'began',
    'begin',
    'begun',
    'being',
    'below',
    'bench',
    'billy',
    'birth',
    'black',
    'blame',
    'blind',
    'block',
    'blood',
    'board',
    'boost',
    'booth',
    'bound',
    'brain',
    'brand',
    'bread',
    'break',
    'breed',
    'brief',
    'bring',
    'broad',
    'broke',
    'brown',
    'build',
    'built',
    'buyer',
    'cable',
    'calif',
    'carry',
    'catch',
    'cause',
    'chain',
    'chair',
    'chart',
    'chase',
    'cheap',
    'check',
    'chest',
    'chief',
    'child',
    'chose',
    'civil',
    'claim',
    'class',
    'clean',
    'clear',
    'click',
    'clock',
    'close',
    'coach',
    'coast',
    'could',
    'count',
    'court',
    'cover',
    'craft',
    'crash',
    'cream',
    'crime',
    'cross',
    'crowd',
    'crown',
    'curve',
    'cycle',
    'daily',
    'dance',
    'dated',
    'dealt',
    'death',
    'debut',
    'delay',
    'depth',
    'doing',
    'doubt',
    'dozen',
    'draft',
    'drama',
    'drawn',
    'dream',
    'dress',
    'drill',
    'drink',
    'drive',
    'drove',
    'dying',
    'eager',
    'early',
    'earth',
    'eight',
    'elite',
    'empty',
    'enemy',
    'enjoy',
    'enter',
    'entry',
    'equal',
    'error',
    'event',
    'every',
    'exact',
    'exist',
    'extra',
    'faith',
    'false',
    'fault',
    'fiber',
    'field',
    'fifth',
    'fifty',
    'fight',
    'final',
    'first',
    'fixed',
    'flash',
    'fleet',
    'floor',
    'fluid',
    'focus',
    'force',
    'forth',
    'forty',
    'forum',
    'found',
    'frame',
    'frank',
    'fraud',
    'fresh',
    'front',
    'fruit',
    'fully',
    'funny',
    'giant',
    'given',
    'glass',
    'globe',
    'going',
    'grace',
    'grade',
    'grand',
    'grant',
    'grass',
    'great',
    'green',
    'gross',
    'group',
    'grown',
    'guard',
    'guess',
    'guest',
    'guide',
    'happy',
    'harry',
    'heart',
    'heavy',
    'hence',
    'henry',
    'horse',
    'hotel',
    'house',
    'human',
    'ideal',
    'image',
    'index',
    'inner',
    'input',
    'issue',
    'joint',
    'jewel',
    'judge',
    'known',
    'label',
    'large',
    'laser',
    'later',
    'laugh',
    'layer',
    'learn',
    'lease',
    'least',
    'leave',
    'legal',
    'level',
    'light',
    'limit',
    'links',
    'lives',
    'local',
    'logic',
    'loose',
    'lower',
    'lucky',
    'lunch',
    'lying',
    'magic',
    'major',
    'maker',
    'march',
    'maria',
    'match',
    'maybe',
    'mayor',
    'meant',
    'media',
    'metal',
    'might',
    'minor',
    'minus',
    'mixed',
    'model',
    'money',
    'month',
    'moral',
    'motor',
    'mount',
    'mouse',
    'mouth',
    'movie',
    'music',
    'needs',
    'never',
    'night',
    'noise',
    'north',
    'noted',
    'novel',
    'nurse',
    'occur',
    'ocean',
    'offer',
    'often',
    'order',
    'other',
    'ought',
    'paint',
    'panel',
    'paper',
    'party',
    'peace',
    'peter',
    'phase',
    'phone',
    'photo',
    'piece',
    'pilot',
    'pitch',
    'place',
    'plain',
    'plane',
    'plant',
    'plate',
    'point',
    'pound',
    'power',
    'press',
    'price',
    'pride',
    'prime',
    'print',
    'prior',
    'prize',
    'proof',
    'proud',
    'prove',
    'queen',
    'quick',
    'quest',
    'quiet',
    'quite',
    'radio',
    'raise',
    'range',
    'rapid',
    'ratio',
    'reach',
    'ready',
    'refer',
    'right',
    'rival',
    'river',
    'robin',
    'rough',
    'round',
    'route',
    'royal',
    'rural',
    'scale',
    'scene',
    'scope',
    'score',
    'sense',
    'serve',
    'seven',
    'shall',
    'shape',
    'share',
    'sharp',
    'sheet',
    'shelf',
    'shell',
    'shift',
    'shirt',
    'shock',
    'shoot',
    'short',
    'shown',
    'sight',
    'since',
    'sixth',
    'sixty',
    'sized',
    'skill',
    'sleep',
    'slide',
    'small',
    'smart',
    'smile',
    'smith',
    'smoke',
    'solid',
    'solve',
    'sorry',
    'sound',
    'south',
    'space',
    'spare',
    'speak',
    'speed',
    'spend',
    'spent',
    'split',
    'spoke',
    'sport',
    'staff',
    'stage',
    'stake',
    'stand',
    'start',
    'state',
    'steam',
    'steel',
    'stick',
    'still',
    'stock',
    'stone',
    'stood',
    'store',
    'storm',
    'story',
    'strip',
    'stuck',
    'study',
    'stuff',
    'style',
    'sugar',
    'suite',
    'super',
    'sweet',
    'table',
    'taken',
    'tarts',
    'taste',
    'taxes',
    'teach',
    'teeth',
    'terry',
    'texas',
    'thank',
    'theft',
    'their',
    'theme',
    'there',
    'these',
    'thick',
    'thing',
    'think',
    'third',
    'those',
    'three',
    'threw',
    'throw',
    'tight',
    'tipsy',
    'times',
    'tired',
    'title',
    'today',
    'topic',
    'total',
    'touch',
    'tough',
    'tower',
    'tools',
    'topaz',
    'track',
    'trade',
    'train',
    'treat',
    'trend',
    'trial',
    'tried',
    'tries',
    'truck',
    'truly',
    'trust',
    'truth',
    'twice',
    'twist',
    'under',
    'undue',
    'union',
    'unity',
    'until',
    'upper',
    'upset',
    'urban',
    'usage',
    'usual',
    'valid',
    'value',
    'video',
    'virus',
    'visit',
    'vital',
    'voice',
    'waste',
    'watch',
    'water',
    'wheel',
    'where',
    'which',
    'while',
    'white',
    'whole',
    'whose',
    'woman',
    'women',
    'world',
    'worry',
    'worse',
    'worst',
    'worth',
    'would',
    'wound',
    'write',
    'wrong',
    'wrote',
    'yield',
    'young',
    'youth'];

// start loop
gameloop();
