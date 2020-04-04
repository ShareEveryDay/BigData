package cn.tedu.demo

object ForDemo3 {

  def main(args: Array[String]): Unit = {

    // 打印100以7的倍数，但是不是3的倍数的数字
    // for (i <- 0.until(100, 7))
    //   if (i % 3 != 0)
    //     println(i)
    // for循环中直接嵌套了一个if判断，除了if判断以外，没有任何其他操作
    // 循环判断式/循环守护式/循环守卫式
    // 等价于：
    // for (i <- 0.until(100, 7) if i % 3 != 0)
    //   println(i)

    // 循环嵌套
    for (i <- 1 to 3) {
      for (j <- 1 to 4) {
        println("第" + i + "排第" + j + "列")
      }
    }
    // for循环中直接嵌套了一个for循环而没有其他额外操作
    // 等价于：
    for (i <- 1 to 3; j <- 1 to 4) {
      println("第" + i + "排第" + j + "列")
    }
    // 在Scala中，不建议写;
    // 等价于：
    // 写在上边的嵌套下边的
    for {
      i <- 1 to 3
      j <- 1 to 4
    } {
      println("第" + i + "排第" + j + "列")
    }

  }

}
