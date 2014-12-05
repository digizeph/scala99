// P01 (*) Find the last element of a list.
//     Example:
//     scala> last(List(1, 1, 2, 3, 5, 8))
//     res0: Int = 8

def lastBuiltin[A](ls: List[A]): A = ls.last

// The standard functional approach is to recurse down the list until we hit
// the end.  Scala's pattern matching makes this easy.
def lastRecursive[A](ls: List[A]): A = ls match {
  case h :: Nil  => h
  case _ :: tail => lastRecursive(tail)
  case _         => throw new NoSuchElementException
}

def lastRecursive2[B](ls: List[B]) = ls match {
  case h :: Nil  => h
  case _ :: tail => lastRecursive(tail)
  case _         => throw new NoSuchElementException
}

lastRecursive2(List(1, 1, 2, 3, 5, 8))


