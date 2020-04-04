package cn.tedu.demo

import scala.io.StdIn

object MatchCaseDemo {

  def main(args: Array[String]): Unit = {

    // 输入两个数字以及一个符号，完成四则运算
    var x = StdIn.readDouble()
    var y = StdIn.readDouble()
    var s = StdIn.readChar()

    // 在Scala中，一般推荐结果使用val
    val r = s match {
      case '+' => x + y
      case '-' => x - y
      case '*' => x * y
      case '/' => x / y
    }

    println(r)

  }

}
