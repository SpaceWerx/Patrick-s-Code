console.log("===================================(DOM Selection/Manipulation)")
//I would like all of you divs, with the class name domClass to be selected
let divElements = document.getElementsByClassName("domClass");

console.log(divElements); //This prints the array of our div elements with the class name of "domClass"

let firstDiv = divElements[0];
console.log(firstDiv);

//Lets mess with the attributes of our html page. This is what is called DOM Manipulation
firstDiv.setAttribute("style","background-color:purple;");

console.log("===================================(Events)")

//Lets grab our button
let myButton = document.getElementById("b1");

myButton.onclick = clickFunc;

//I want to mess with that header element
document.getElementById("h1").addEventListener("mouseover", hoverFunc); //When the mouse goes over our header, something will happen
document.getElementById("h1").addEventListener("mouseleave", leaveFunc); //When the mouse is no longer on our header, something else will happen

let x = 0;
//Lets make our functions
function clickFunc() {
    console.log("clickFunc is running!");
    document.getElementById("b1").textContent = "You have clicked me";
    document.getElementById("p3").textContent = "I saw you click the button ;)";
    x++;
    if (x>=10){
        document.getElementById("b1").textContent = "That's enough clicking";
        document.getElementById("p3").textContent = "Stop it, you are hurting them!";
    }
    if (x>=20){
        document.getElementById("b1").textContent = "Okay, I like it again";
        document.getElementById("p3").textContent = "The button is very weird";
    }
}
function hoverFunc(){
    console.log("hoverFunc is running! SO YOU BETTER GO CATCH IT");//This is a joke
    document.getElementById("h1").textContent = "DON'T TOUCH ME MORTAL!";
}
function leaveFunc(){
    console.log("leaveFunc is running!")
    document.getElementById("h1").textContent = "BYEEEEEEEEEEEEEEEEEEE";
}