/*
Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */

def penultimate[A](ls: List[A]): A = ls match {
  case h :: _ :: Nil => h
  case _ :: tail => penultimate(tail)
}

penultimate(List(4, 1, 2, 3, 5, 8))
