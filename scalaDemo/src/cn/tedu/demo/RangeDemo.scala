package cn.tedu.demo

object RangeDemo {
  def main(args: Array[String]): Unit = {
    //to 关键字是包含100的
    var range : Range= 1 to 100
    for (i <-range) {
      println(i)
    }
    //until是不包含100
    var des = 1 until 100
    for (j <-des) {
      println(j)
    }
  }
}
