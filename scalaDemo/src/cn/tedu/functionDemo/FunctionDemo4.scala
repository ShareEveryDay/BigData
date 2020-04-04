package cn.tedu.functionDemo

object FunctionDemo4 {
  def main(args: Array[String]): Unit = {
    //可以给定函数参数的默认值 在调用不给参数的时候可以进行使用默认值来替补
    def offPrice(price: Double,off: Double= 1 ): Double = price * off
    println(offPrice(35,0.78))
    println(offPrice(89))

    //给定函数参数的默认值如果是在第一位 那么在调用的时候需要将参数的对应关系自己指定
    def offPrice1(off: Double = 1,price: Double) : Double=off * price
    println(offPrice1(0.86,89))
    //自行指定对应的关系 也是可以的
    println(offPrice1(price = 96))
  }

}
