package cn.tedu.demo

import scala.util.control.Breaks

object BreakDemo {

  def main(args: Array[String]): Unit = {

    Breaks.breakable(
      for (i <- 1 to 10) {
        if (i % 4 == 0)
        // break方法是通过抛出异常的方式来中止循环
        Breaks.break()
        println(i)
      }
    )
    println("finish")
  }

}
