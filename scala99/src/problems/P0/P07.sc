/*
Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

def flatten (ls: List[Any]): List[Any] = ls flatMap {
  case ms: List[_] => flatten(ms) // if it is a list
  case e => List(e) // if it is an item
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))