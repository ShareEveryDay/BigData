package cn.tedu.demo

import scala.io.StdIn

object IfElseDemo {

  def main(args: Array[String]): Unit = {

    // 输入一个数字，判断这个数字的奇偶性
    // val num = StdIn.readInt()
    // 如果if成立，返回"奇数"，结果类型是String
    // 如果if不成立，返回"偶数"，结果类型是String
    // var r: String = if (num % 2 == 1) "奇数" else "偶数"
    // println(num + "是一个" + r)

    // 输入三个数字，获取较大的值
    var i = StdIn.readInt()
    var j = StdIn.readInt()
    var k = StdIn.readInt()

    var max = if (i > j) i else j
    max = if (max > k) max else k
    println(max)


  }

}
