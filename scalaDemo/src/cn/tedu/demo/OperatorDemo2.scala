package cn.tedu.demo

object OperatorDemo2 {

  def main(args: Array[String]): Unit = {

    // 赋值运算符
    var i = 5
    var j = 7
    // 此时i=j是一个赋值运算，没有计算结果
    // k的值是无值
    var k: Unit = i = j
    println(k)
    // 所有的赋值运算的计算结果都是无值
    // i += i -= 5
    // Scala中不支持连等运算

    println(3 > 4)
    println(3.>(4))

  }

}
