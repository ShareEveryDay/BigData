package cn.tedu.demo

object FroDemo {
  def main(args: Array[String]): Unit = {
    var sum = 0
    for (i <-1 to 10)
      sum += i
    println(sum)

    //打印星星矩阵
    for (i <- 1 to 4)
      println("*" * 5 )
    var arr = Array[Int](3,2,2,4,5,3,2,8)
    for (i <- 0 until arr.length)
      println(arr(i))
  }
}
