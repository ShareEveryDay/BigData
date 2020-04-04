package cn.tedu.demo

object ForDemo2 {

  def main(args: Array[String]): Unit = {

    // 默认自增1
    // to是一个函数，在Scala中，如果一个函数只有一个参数，那么可以省略.和()不写
    // for (i <- 0.to(50))
    // for (i <- 0 to 50)
    //  println(i)
    // 打印50以内，7的倍数
    // 在Java中，等价于for(int i = 0; i <= 50; i += 7)
    // for (i <- 0.to(50, 7))
    //   println(i)
    // 在Java中，等价于for(int i = 0; i < 30; i += 5)
    // for (i <- 0.until(30, 5))
    //   println(i)

    // 打印5,4,3,2,1
    // for (i <- 5.to(1, -1))
    //   println(i)
    // 等价于：
    for (i <- 1 to 5 reverse)
      println(i)
  }

}
