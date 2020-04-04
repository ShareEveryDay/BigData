package cn.tedu.functionDemo

object FunctionDemo3 {
  //打印m行n列的星星
  def printStar(m: Int,n: Int): Unit={
    for (i<-1 to m)
      println("*" * n)
  }
  //打印由星星组成的三角形
  //在Scala中 如果一个函数的返回值的类型是Unit 可以省略返回值类型 以及=号
  //没有返回值的时候 默认就是Unit
  //定义在参数列表中的参数是常量 都不能进行该表
  //在Scala中 函数作为一等公民 函数可以定义在任意位置 也可以在函数中进行定义
  def printStar1(i: Int) {
    for(m <- 1 to i)
      println("*" * m)
  }

  def main(args: Array[String]): Unit = {
    printStar1(4)
  }
}
