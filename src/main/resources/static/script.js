let btnIndex = 1;
let input = document.getElementById("inputbox");
input.addEventListener('keydown', handleKeydown);

async function initialize() {
    await axios.post('/addDB');
}

initialize();

async function handleKeydown(event) {
    if (event.key == "Enter") {
        if (input.value != "") {
            playGoodSound();
            await axios.post('/add', { id: btnIndex, string: input.value });
            createButton(input.value);
            input.value = "";
        } else {
            playErrorSound();
        }
    }
}

function createButton(btName) {
    let button = document.createElement("button");
    button.className = "button";
    button.innerHTML = btName;
    if (btName.length > 10) {
       button.innerHTML = btName.substr(0, 10) + "...";
    }
    button.id = btnIndex;
    document.body.appendChild(button);
    button.addEventListener('click', function() {
        sendID(button.id);
    });
    ++btnIndex;
}

async function sendID(id) {
    await axios.post("/receiveBtnID", {btnID: id});
    newPage();
}

function newPage() {
    window.open('index2.html');
}

function playGoodSound() {
    var audio = new Audio('/audio/good.mp3');
    audio.play();
}

function playErrorSound() {
    var audio = new Audio('/audio/error.mp3');
    audio.play();
}