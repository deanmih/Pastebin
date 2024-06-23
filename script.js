document.getElementById("inputbox").addEventListener("keydown", addText);
var nr = 0;
var btnName = "";
var newLine = document.createElement("button");
var btnContainer = document.getElementById("btnContainer");
var inputBox = document.getElementById("inputbox");

function addText(e) {
    if (e.key === 'Enter') {
        var text = document.getElementById("inputbox").value;
        if (text.length > 0) {
            playGoodSound();
            newLine.className = "btnNew";
            newLine.innerHTML = text;
            newLine.id = "btn" + nr.toString();
            if (text.length > 10) {
                newLine.innerHTML = text.substr(0, 10) + "...";
            }
            btnContainer.appendChild(newLine);
            newLine.addEventListener("click", function() {
                axios.post('/sentKey', {key: newLine.id});
                newPage();
            });
            axios.post('/txt', {key: newLine.id, val: text});
            document.getElementById("inputbox").value = "";
            ++nr;
        } else {
            playErrorSound();
        }
    }
}

function playGoodSound() {
    var audio = new Audio('/audio/good.mp3');
    audio.play();
}

function playErrorSound() {
    var audio = new Audio('/audio/error.mp3');
    audio.play();
}

function newPage() {
    window.open('/new');
}
