var container = document.getElementById("container");

var firstDiv = document.createElement("div");

var firstText = document.createElement("h2");
firstText.innerHTML = "Üdvözöllek a sorsoláskészítő felületen!" + "<br />" +
    "Kérlek add hozzá a versenyzőket a listához" + "<br />";


var listOfPlayers = [];
console.log(listOfPlayers);

//----------Button----------------------
var Button = function(text, id) {
    var button = document.createElement("button");
    button.className = "select-button";
    button.id = id;
    button.innerHTML = text;
    return button;
};
//--------------------------------------------
var showList = function () {


}
//----------Input fields----------------------
var formDiv = function () {

    var div = document.createElement("div");
    var text  = document.createElement("p");
    text.innerHTML = "Kérjük adja meg a résztvevők nevét az alábbi mezőbe egyesével";

    var inputelement = document.createElement('input'); // Create input field for name
    inputelement.className = "name-input";
    inputelement.id = "userInput";
    inputelement.type = "text";
    inputelement.placeholder = "Név...";
    div.appendChild(inputelement);

    var submitButton = new Button("Hozzáadás", "submitButton");

    div.appendChild(submitButton);


    return div;
};

//--------------------------------------------


//------Round robin div----------------------------
var roundRobinDiv = document.createElement("div");
var robinText = document.createElement("h1");
robinText.innerHTML = "Körverseny";
roundRobinDiv.appendChild(robinText);
var backButton = new Button("Vissza", "backButton");
roundRobinDiv.appendChild(backButton);

//----------------------------------------------
//-----------Direct knockout div-----------------
var directKnockoutDiv = document.createElement("div");
var directText = document.createElement("h1");
directText.innerHTML = "Egyenes Kiesés";
directKnockoutDiv.appendChild(directText);
var backButton = new Button("Vissza", "backButton");
directKnockoutDiv.appendChild(backButton);
//-------------------------------------------------
var listDiv = document.createElement("div");
listDiv.id = "listDiv";
var texxxt = document.createElement("p");
texxxt.innerHTML = "lofasz";
listDiv.appendChild(texxxt);

container.appendChild(firstDiv);

function nextPage()
{
    if(event.target.id == "roundRobin"){
        container.innerHTML = "";
        container.appendChild(roundRobinDiv);
    }
    if(event.target.id == "directKnockout"){
        container.innerHTML = "";
        container.appendChild(directKnockoutDiv);
    }
    if(event.target.id == "backButton"){
        container.innerHTML = "";
        container.appendChild(firstDiv);
    }
    if(event.target.id == "submitButton"){
        var userInput = document.getElementById("userInput").value;
        listOfPlayers.push(userInput);
        var showList = new showList();

    }
}


//-------------------------------------------------


firstDiv.appendChild(listDiv);
firstDiv.appendChild(firstText);
var input = new formDiv();
firstDiv.appendChild(input);
var text = document.createElement("h2");
text.innerHTML = "Miután hozzáadtál minden versenyzőt," + "<br />" + "Válassz az alábbi lehetőségek közül";
firstDiv.appendChild(text);
var roundButton = new Button("Körverseny", "roundRobin");
var knockoutButton = new Button("Egyenes kiesés", "directKnockout");
firstDiv.appendChild(roundButton);
firstDiv.appendChild(knockoutButton);
document.body.addEventListener("click", nextPage);
