/*
Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */

def gethead[A] (ls: List[A]) = ls match{
  case h :: tail => h
}

def gettail[A] (ls: List[A]) = ls match{
  case h :: tail => tail
}

def nth[A] (n:Int, ls: List[A]): A = n match {
  case 0 => gethead(ls)
  case _ => nth(n-1, gettail(ls))
}

// the one inspired from the answer.
def nth2[A] (n:Int, ls: List[A]): A = (n, ls) match {
  case (0, h:: _) => h
  case (n, h:: tail) => nth2(n-1, tail)
}

nth(4, List(1, 1, 2, 3, 5, 8) )
nth2(4, List(1, 1, 2, 3, 5, 8) )
