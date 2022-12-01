(* CSC 345-01 Assignment #4

   On my honor, Steve Purr, this assignment is my own work.  
   I, Steve Purr, will follow the instructor's rules and processes 
   related to academic integrity as directed in the course syllabus.
 
   *** You are NOT allowed to use OCaml's pattern matching for this assignment. ***

   *** DO NOT CHANGE ANYTHING IN THIS FILE EXCEPT THE PLACEHOLDERS. ***

   *** You are only allowed to replace (* FILL IN HERE *) with your OCaml code.  ***
*) 



(* 1. Write a function harmonic that uses recursion to compute n-th harmonic number.  Read:  https://en.wikipedia.org/wiki/Harmonic_number
      For example, harmonic 2;; returns 1.5 *)
let rec harmonic : int -> float = fun n ->
  if (n = 1) then 1.0
  else (1.0 /. float_of_int n) +. harmonic (n - 1);;



(* 2. Write a function howManyAboveAverage that returns how many of three integer inputs are above its average value.  
      For example, howManyAboveAverage 1 3 3;; returns 2 *)
let howManyAboveAverage : int -> int -> int -> int = fun x y z ->
  let avg = (x + y + z) / 3 in 
    if (x > avg && y > avg) then 2
    else if (x > avg && z > avg) then 2
    else if (y > avg && z > avg) then 2
    else if (x > avg || y > avg || z > avg) then 1
    else 0;;



(* 3. Write a function howManyWithinThreshold that returns how many of the first three arguments are within the threshold (the fourth argument) of the average of the first three arguments. 
       For example, howManyWithinThreshold 10 1 2 3.5;; returns 2 *)
let howManyWithinThreshold : int -> int -> int -> float -> int = fun x y z t -> (* FILL IN HERE *);;



(* 4. Write a function mandn that uses recursion to compute m + (m+1) + (m+2) + ... + (m + (n-1)) + (m + n).  
      For example, mandn 1 2;; returns 6 *)	  
let rec mandn : int -> int -> int = fun m n -> (* FILL IN HERE *);;



(* 5. Write a function sum that uses recursion to compute the sum of all numbers from 1 to n, where n is greater than or equal to 1.
      For example, sum 3;; returns 6 *)
let rec sum : int -> int = fun n -> (* FILL IN HERE *);;



(* 6. Write a function getBinary that uses recursion to convert an integer n (where n is greater than or equal to 0) to its binary representation.
      For example, getBinary 12;; returns 1100 
                   getBinary 7;;  returns 111
                   getBinary 42;; returns 101010 
      Hint:    if n's binary representation is 10010101011
            (n / 2)'s binary representation is 1001010101
            (N % 2)'s binary representation is           1 *)	  
let rec getBinary : int -> int = fun n -> (* FILL IN HERE *);;



(* 7. Write a function howManyDigits that uses recursion to count the digits of an integer n (where n is greater than or equal to 1).
      For example, howManyDigits 978;; returns 3 *)
let rec howManyDigits : int -> int = fun n -> (* FILL IN HERE *);;



(* 8. Write a function orderTriple that takes a triple, and returns a version in increasing order.
      For example, orderTriple (2, 1, 3);; returns (1, 2, 3) *)
let orderTriple : int * int * int -> int * int * int = fun (x, y, z) -> (* FILL IN HERE *);;