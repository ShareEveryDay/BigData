package cn.tedu.functionDemo

object FunctionDemo8 {
  def main(args: Array[String]): Unit = {
    //定义一个参数 传入两个整数 并且将打印这两个参数的计算的结果
    //计算过程是未知的 那么需要将计算的过程作为参数传入函数中
    def printResult(i: Int,j: Int,f:(Int,Int) => Int)={
      println(f(i,j))
    }
    def sum(x: Int,y: Int) = x + y
    printResult(3,5,sum)
    //匿名函数的体现---不需要指定函数的名称
    printResult(3,5,(x: Int,y: Int) => x + y)
    //等价于---由于在高阶函数中已经指定了函数的参数的类型 此时可以办参数省略
    printResult(3,5,(x, y ) => x + y)
    //等价于
    //由于参数只是使用了一次 那么可以将这两个参数使用占位符的形式进行占位来使用
    //如果参数使用可多次 那么就是不能够使用占位符的形式来简化函数
    printResult(3,5,_ + _)
  }
}
