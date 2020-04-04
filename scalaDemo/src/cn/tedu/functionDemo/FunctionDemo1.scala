package cn.tedu.functionDemo

object FunctionDemo1 {
  //标准的函数的类型 求两个数的和
  def sum(i: Int,j: Int): Int = {
    return i+j
  }

  //在scala中 函数的最后一行 默认作为这个函数的返回值进行返回
  //所以最后的一行可以省略return不写
  def sum(i: Double, j: Double): Double = {
    println("求两个参数的和")
    i + j
  }

  //求两个数的差
  //如果函数体整体只有一句话 那么这个花括号可以省略不写
  def minus(i: Int,j: Int): Int= i - j

  //求两个数的积
  //返回值的类型也可以省略不写
  //如果省略了返回值的类型 函数体中就不能写return
  // 就必须交给scala进行自动推到返回值的类型
  def multipy(i: Int,j: Int)= i * j

  def main(args: Array[String]): Unit = {
    var r = sum(3.46,5.28)
    println(r)
  }
}
