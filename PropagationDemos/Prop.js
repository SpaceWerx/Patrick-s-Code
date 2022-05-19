//This should have with visualizing how propagation works in JS



console.log("============================================(Capturing)");
//This three, should demonstrate the effect of Capturing in the Console log
document.getElementById("inner").addEventListener("click", (event) => {console.log("INNER - captureing")}, true);
document.getElementById("middle").addEventListener("click", (event) => {console.log("MIDDLE - captureing")}, true);
document.getElementById("outer").addEventListener("click", (event) => {console.log("OUTER - captureing")}, true);



console.log("============================================(Bubbling)");
//We are now going to bubble!
// document.getElementById("inner").addEventListener("click", (event) => {console.log("INNER - captureing")}, false);
// document.getElementById("middle").addEventListener("click", (event) => {console.log("MIDDLE - captureing")}, false);
// document.getElementById("outer").addEventListener("click", (event) => {console.log("OUTER - captureing")}, false);

