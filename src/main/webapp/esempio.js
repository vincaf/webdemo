"use strict";

// javascript (+ correttamente ECMASCRIPT) ha una sintassi c like

let x = 100; // int x = 100
console.log(x, typeof x);

x = "Hello WOrld";

console.log(x, typeof x); // equivalente di System.out.println(x)

let k = 100;
var t = 700;

// usare sempre let perchè definisce una variabile con il funzionamento delle variabili in Java

if (k > t) {
  console.log("console.log(k > t)");
  let tt = 98;
} else {
  console.log("console.log(k <= t)");
}


for (let lx = 0; lx < 100; lx++) {
  console.log(lx);
}

let lx = 0;
for (; lx < 100; ) { // continue e break
  console.log(lx);
  lx++;
}

lx = 0;
while (lx < 100) {
  console.log(lx);
  lx++;
}

switch(lx) {
    case 0:
        console.log("lx è zero");
        break;
    // ..
    default:
    console.log("valore inatteso in lx");
}

let myArray = [0,1,,,4,5];
console.log(myArray, myArray.length);
let i = 0;
for(i=0; i<myArray.length; i++) {
    console.log(myArray[i]);
}
myArray.push("Hello");
myArray.push("World");
myArray.push(150);
console.log(myArray, myArray.length);
i = 0;
for(i=0; i<myArray.length; i++) {
    console.log(myArray[i]);
}

myArray.pop();
console.log(myArray, myArray.length);

myArray.unshift("valore 1;")
myArray.unshift("valore 2;")
console.log(myArray, myArray.length);


console.log(somma(10, 5));
console.log(somma("xxx", "hhh"));


function somma(x, y) {
    return x+y;
}

console.log("esercizio");

let arr = [1, 7, -3, -5, 8, 98, 0, -1];
console.log(arr);

// stampare la somma di tutti gli elementi
let sum = 0;

for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
}
console.log("Somma di tutti gli elementi dell'array: " + sum);

// stampare la somma degli elementi pari
let sumOfEven = 0;

for (let i = 0; i < arr.length; i++) {
    if(arr[i] % 2 == 0){
        sumOfEven += arr[i];
    }
}
console.log("Somma elementi pari dell'array: " + sumOfEven);

// stampare la somma degli elementi dispari partendo dal fondo
let sumOfOdd = 0;

for (let i = arr.length-1; i >= 0; i--) {
    if(arr[i] % 2 !== 0){
        sumOfOdd += arr[i];
    }
}
console.log("Somma elementi dispari dell'array: " + sumOfOdd);

const sommaDiritta = array.reduce((accumulator, currentValue) => accumulator + currentValue);
const sommaDirittaPari = array.filter(x => x%2===0).reduce((accumulator, currentValue) => accumulator + currentValue);
const sommaDirittaIndicePari = array.filter ( (x, index) => index%2===0).reduce((accumulator, currentValue) => accumulator + currentValue);
const resultInversaDispari = array.reverse().filter().filter(x => x%2!==0).reduce((accumulator, currentValue) => accumulator + currentValue);
console.log("***", sommaDiritta, sommaDirittaPari, sommaDirittaIndicePari, resultInversaDispari);
