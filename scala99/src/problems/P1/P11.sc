/*
Modified run-length encoding.
Modify the result of problem P10 in such a way that
if an element has no duplicates it is simply copied into the result list.
Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
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

def encodeModified[A] (ls: List[A]): List[Either[A,(Int,A)]] = {
  val lists =  pack(ls)
//  def count (l: List[A]): Either[A,(Int,A)]={
  def count (l: List[A]): Either[A,(Int,A)]={
    if(l.length==1)
      Left(l.head)
    else
      Right((l.length,l.head))
  }
  lists.map(count(_))
}

encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
