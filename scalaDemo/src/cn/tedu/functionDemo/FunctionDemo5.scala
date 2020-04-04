package cn.tedu.functionDemo

object FunctionDemo5 {
  def main(args: Array[String]): Unit = {
    //高阶函数
    //输入三个整数 打印较大的两个整数值 并且可以选择是否打印小的值
    def sum(x: Int, y:Int, z: Int)= {
      //获取三个参数中的最小值
      def min()={
        var min = if(x > y) y else x
        min =if(min > z) z else min
        min
      }
      println(x + y + z -min)
      //这个时候不是表示调用min 函数
      //而是把整个min函数作为返回值进行返回
      min _
    }

    var r = sum(5,7,8)
    println(r())
  }

}
