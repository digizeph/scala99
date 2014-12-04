/*
Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

def pack[A] (ls: List[A]): List[List[A]] = {
  if(ls.isEmpty)
    List(Nil)
  else {
    val (head, tail) = ls.span(_==ls.head) // span is the key function.
    if(tail == Nil)
      List(head)
    else
      head :: pack(tail)
  }
}

pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))