package cn.tedu.demo

// _表示通配符
// 表示导入Breaks类中的所有方法
import scala.util.control.Breaks._

object BreakDemo2 {

  def main(args: Array[String]): Unit = {

    breakable(
      for (i <- 1 to 10) {
        if (i % 4 == 0)
          // 在Scala中，如果一个函数没有参数，那么可以省略()不写
          break
        println(i)
      }
    )
    println("finish")

  }

}
