/*
Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */

def compress[A] (ls: List[A]): List[A] = ls match {
  case Nil => Nil
  case a::Nil => List(a)
  case a::b::tail =>
    if(a==b)
      compress(b::tail) // drop the first repeated character
    else
      a::compress(b::tail)
}

// Use list.dropWhile built-in function.
def compress2[A] (ls: List[A]): List[A] = ls match{
  case Nil => Nil
  case h::tail => h:: compress2(tail.dropWhile(_==h))
}

// Use foldRight
def compress3[A] (ls: List[A]): List[A] ={
  ls.foldRight(List[A]()) {
    (h,r) =>
      if(r.isEmpty || r.head != h)
        h::r
      else
        r
  }
}

compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
compress2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
compress3(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
