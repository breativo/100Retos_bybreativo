/*
*Escribe un programa que imprima los 50 primeros números de la sucesión
*de Fibonacci empezando en 0.
    * - La serie Fibonacci se compone por una sucesión de números en
    * la que el siguiente siempre es la suma de los dos anteriores.
    * 0, 1, 1, 2, 3, 5, 8, 13...
*/

const numero=50;
let a =0;
let b =1;

console.log(a);
console.log(b);

for (let index = 2; index < numero; index++){
    let next =a+b;
    console.log(next);
    a=b;
    b=next;
}