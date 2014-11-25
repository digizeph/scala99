/*
Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */

def length[A] (ls: List[A]): Int = ls match {
  case h :: Nil => 1
  case h :: tail => 1 + length(tail)
}

// tail recursive version.
def lengthTailRecursive[A](ls: List[A]): Int = {
  def lengthR(result: Int, curList: List[A]): Int = curList match {
    case Nil       => result
    case _ :: tail => lengthR(result + 1, tail)
  }
  lengthR(0, ls)
}

length(List(1, 1, 2, 3, 5, 8))