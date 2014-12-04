/*
Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

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

def encode[A] (ls: List[A]): List[(Int,A)] = {
  val lists =  pack(ls)
  def count (l: List[A]): (Int,A)={
    (l.length,l.head)
  }
  lists.map(count(_))
}

encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))