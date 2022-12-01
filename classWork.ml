(** 1. Write a function that computes the sum of the first two elements.  Assume that the list of of length at least 2. *)
let addfirsttwo l =
  List.hd l + List.hd (List.tl l);;

(** 2. Write a function that checks if a list is empty. *)
let isEmpty l = l = [];;

(** 3. Write a recursive function that finds the length of a list. *)
let rec len l =
  if (isEmpty l) then 0
  else len (List.tl l) + 1;;

(** 4. Write a function that computes the sum of the lengths of the first two elements.  Assume that the list is of length at least 2. *)
let addfirsttwolengths l =
  len (List.hd l) + len (List.hd (List.tl l));;

(** 5. Write a recursive function that fins the sum of an int list's elements. *)
let rec sum l =
  if ((len l) = 1) then List.hd l
  else (List.hd l) + sum(List.tl l);;

(** 6. Write a recursive function that return a list of integer numbers in the range of n to m (n <= m). *)
let rec range n m =
  if (n = m) then [m]
  else n::(range (n+1) m);;

(** 7. Write a recursive function that returns whether or not all the ints in a list are positive. *)
let rec allpos l =
  if (l = []) then true
  else if (List.hd l < 0) then false
  else allpos (List.tl l);;

(** 8. Write a recursive function that concatenates lists in a list. *)
let rec concat l =
  if (l = []) then []
  else (List.hd l) @ concat(List.tl l);;

(** 9. Write a recursive function that reverses the elements in a list. *)
let rec reverse l =
  if (l = []) then []
  else reverse (List.tl l)@[(List.hd l)];;

(** 10. Write a recursive function that removes the first matching element of a list. *)
let rec remove_first a l =
  if (l = []) then []
  else if ((List.hd l) = a) then List.tl l
  else (List.hd l)::(remove_first a (List.tl l));;

(** 11. Write a recursive function that finds n-th element from a list. *)
let rec nth l n =
  if (l = []) then -1
  else if (n = 0) then List.hd l
  else nth (List.tl l) (n - 1);;


(** 12. Write a recursive function that inserts an element to a sorted list. *)
let rec insert a l =
  if (l = []) then [a]
  else if ((List.hd l) >= a) then a::l
  else (List.hd l)::(insert a (List.tl l));;

(** 13. Write a recursive function that drops the first n elements from a list. *)
let rec drop l n =
  if (n = 0) then l
  else drop (List.tl l) (n - 1);;

(** 14. Write a recursive function that adds 1 to every element in a list. *)
let rec inc_all l =
  if (l = []) then []
  else ((List.hd l) + 1)::inc_all(List.tl l);;

(** 15. Write a recursive function that filters out even numbers from a list. *)
let rec even l =
  if (l = []) then []
  else if (List.hd l mod 2 = 0) then even(List.tl l)
  else (List.hd l)::even(List.tl l);;
