/*
Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */

// I gave up, using the built-in function is so easy.
def isPalindrome[A](ls: List[A]): Boolean = {
  ls == ls.reverse
}

isPalindrome(List(1, 2, 3, 2, 1))


