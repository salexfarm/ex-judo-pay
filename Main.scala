import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    println("Length of Longest Substring:: ")
    println(Solution.lengthOfLongestSubstring("abcabcbb"))
    println(Solution.lengthOfLongestSubstring("bbbbb"))
    println(Solution.lengthOfLongestSubstring("pwwkew"))
    println(Solution.lengthOfLongestSubstring(""))
    println(Solution.lengthOfLongestSubstring("a"))
  }

  object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
      @tailrec
      def substringWindow(leftIndex: Int, rightIndex: Int, set: Set[Character], maxSubString: Int): Int = {
        //        println("Left:: " + leftIndex)
        //        println("Right:: " + rightIndex)
        if (rightIndex == s.length()) maxSubString // validates empty/end of string
        else if (!set.contains(s.charAt(rightIndex))) substringWindow(leftIndex, rightIndex + 1, set + s.charAt(rightIndex), Math.max(rightIndex - leftIndex + 1, maxSubString))
        else substringWindow(leftIndex + 1, rightIndex, set - s.charAt(leftIndex), Math.max(rightIndex - leftIndex, maxSubString))
      }
      substringWindow(0, 0, Set.empty, 0)
    }
  }
}