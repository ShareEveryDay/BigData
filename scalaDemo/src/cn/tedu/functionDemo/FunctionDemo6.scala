package cn.tedu.functionDemo

object FunctionDemo6 {
  def main(args: Array[String]): Unit = {
    //输入两个数字 求最大值
    //这两个数字不是同时输入的 而是第一个人先输入一个数字
    //换一个人输入的第二个数字
    def max(i: Int)={
      def m(j: Int)= if(i > j) i else j
      m _
    }
    //scala中的内存划分和java中的内存划分是一样的
    //Scala中是基于jvm来运行的 也就意味着Scala中的方法是在栈内存中进行的
    //栈内存的特点就是用完之后会立即进行销毁
    //当将一个函数作为返回值进行返回的时候 并且利用这个函数延长了变量的生命周期 这种方式就称之为闭包
    //闭包的特点就是能够延长外部函函数变量的生命周期
    var r =max(5)
    var r1 =r(2)
    var r2 =r(4)
    println(r2)
    print(max(7)(8))

  }

}
