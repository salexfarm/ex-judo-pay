import scala.annotation.tailrec

// Given a string s, find the length of the longest substring without repeating characters.
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


// import Main.Solution.lengthOfLongestSubstring

// object Main {
//   val test1: String = "abcabcbb"
//   val test2: String = "bbbbb"
//   val test3: String = "pwwkew"

//   def main(args: Array[String]): Unit = {
//     println("Hello world!")
//     println(lengthOfLongestSubstring(test1))
//     println(lengthOfLongestSubstring(test2))
//     println(lengthOfLongestSubstring(test3))

//   }

//   object Solution {
//     def lengthOfLongestSubstring(s: String): Int = {
//       var subCount: Int = 0;
//       var start: Int = 0
//       var end: Int = 1
//       var mem: String = ""

//       println(mem)
//       while(end != s.length - 1) {
//         println("...")
//         while(s.charAt(start) != s.charAt(end)) {
//           mem = s.
//           println(s.charAt(start) + " -- " + s.charAt(end))
//           println("Substring:: " + s.substring(start, end + 1))
//           subCount = s.substring(start, end + 1).length
//           println("Substring length:: " + subCount)
//           println("Start = " + start + " " + "End = " + end)
//           end += 1
//         }
//         start += 1
//       }
//       if (s.isEmpty) 0
//       else if (s.length == 1) 1
//       else subCount
//     }
//   }
// }

// ignore file
// count the values
// constraints match?
// add test cases
// add other examples
// push to GitHub
// Time Complexity?
// feedback from previous scala exercise (mettle?)

