package cn.tedu.functionDemo

object FunctionDemo7 {
  def main(args: Array[String]): Unit = {
    //求两个函数的最大值
    //如果一个函数中嵌套了内部函数 且外部函数没有进行任何的操作
    //内部函数执行完成之后再进行将这个函数返回
    //可以将这个函数就你行柯理化
    def max(i: Int)(j: Int)= {
      if(i > j) i else j
    }
    println(max(7)(9))
  }
}
