package cn.tedu.demo

object VarDemo {

  def main(args: Array[String]): Unit = {

    // Scala中定义变量通过var关键字
    // 等价于Java中:int i = 5;
    var i: Int = 5
    // var _: Int = 7
    // Java中:String +- = "a"
    var +- : String = "a"
    var `class` = "abc"

    println(i)
    println(+-)
    println(`class`)
    // println(_)


  }

}
