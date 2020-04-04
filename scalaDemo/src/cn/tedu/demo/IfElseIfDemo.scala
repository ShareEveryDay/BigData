package cn.tedu.demo

import scala.io.StdIn

object IfElseIfDemo {

  def main(args: Array[String]): Unit = {

    // 输入分数，输出分数对应的等级
    var score = StdIn.readInt()

    var level = if (score >= 90) 'A'
    else if (score >= 80) 'B'
    else if (score >= 70) 'C'
    else if (score >= 60) 'D'
    else 'E'
    println(level)

  }

}
