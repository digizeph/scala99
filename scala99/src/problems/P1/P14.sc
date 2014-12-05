/*
Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */

def duplicate[A] (ls:List[A]): List[A] = ls match {
  case Nil => Nil
  case h::tail => h::h::duplicate(tail)
}


duplicate(List('a, 'b, 'c, 'c, 'd))
