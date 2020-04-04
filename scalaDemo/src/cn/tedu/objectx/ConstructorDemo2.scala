package cn.tedu.objectx

object ConstructorDemo2 {

  def main(args: Array[String]): Unit = {

    var r = new Rectangle(3.5, 6.8)
    println(r.getArea)
    r.setX(5)

    // var r2 = new Rectangle

  }

}

// 提供了一个含参的主构造器，主构造器本质上就是一个函数
// 主构造器中的参数默认成当前类中的属性
// 函数中参数默认是常量，不能修改
// 需要只对外提供含参构造，而且还得允许属性值可以改变
class Rectangle private() {

  private var x: Double = _
  private var y: Double = _

  def this(x: Double, y: Double) = {
    this()
    this.x = x
    this.y = y
  }

  def getGirth = (x + y) * 2

  def getArea = x * y

  def setX(x: Double) = this.x = x

}
