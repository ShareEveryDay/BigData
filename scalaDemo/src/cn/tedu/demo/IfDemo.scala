package cn.tedu.demo

import scala.io.StdIn

object IfDemo {

  def main(args: Array[String]): Unit = {

    // 输入一个数字，如果是偶数，那么就输出这个数字
    val i = StdIn.readInt()
    // 在Scala中，任何一个结构在运算完成之后都会有计算结果
    // if成立，那么执行println，执行完成没有返回值，那么结果类型就是Unit
    // if不成立，那么没有执行{}的内容，那么也是没有结果，结果类型就是Unit
    var r = if (i % 2 == 0) {
      println(i + "是一个偶数~~~")
    }
    println(r)

    // {}的最后一行默认是这个{}的计算结果
    // if成立，那么返回i，结果是Int类型
    // if不成立，那么没有结果，结果就是Unit类型
    // Int和Unit的父类是AnyVal
    var r2: AnyVal = if (i % 2 == 1) {
      println(i + "是一个奇数~~~")
      i
    }

  }
}
