/*
 Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

def reverse[A](ls: List[A]): List[A] =  ls match {
  case h::Nil => List(h)
  case h::tail => reverse(tail) ::: List(h)
}

def reverse2[A](ls: List[A]): List[A] ={
  def reverseR(result: List[A], curls: List[A]): List[A] = curls match {
    case Nil => result
    case h::tail => reverseR(result:::List(h), tail)
  }
  reverseR(Nil, ls)
}

reverse(List(1, 1, 2, 3, 5, 8))
reverse2(List(1, 1, 2, 3, 5, 8))
