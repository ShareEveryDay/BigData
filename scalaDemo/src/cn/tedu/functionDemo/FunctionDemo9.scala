package cn.tedu.functionDemo

object FunctionDemo9 {
  def sum(i: Double,j: Double): Double ={
    println("---求两个数的和---")
    println("---sum函数的内容---")
    i + j
  }

  def main(args: Array[String]): Unit = {
    lazy val r =sum(5.4,9.8)
    println("----测试懒加载函数----")
    println("---main函数中的内容---")
    println(r)
  }
}
