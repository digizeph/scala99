/*
Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10,
construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

def expand[A] (pair: (Int,A)): List[A] = pair match{
  case (0,_) => Nil
  case (a,b) => b::expand((a-1,b))
}
def decode[A] (ls: List[(Int, A)]): List[A] = ls match{
  case Nil=> Nil
  case h::t => expand(h):::decode(t)
}

/*
def decode2[A] (ls: List[(Int, A)]): List[A] = {
  ls flatMap {
    e => List.make(e._1, e._2)
  }
}
*/

decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
