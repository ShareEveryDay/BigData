package cn.tedu.objectx.Statices

object StaticDemo2 {

  def main(args: Array[String]): Unit = {

    var s = new Student
    Student.study("Chinese")

  }

}

// 伴生类
class Student {

  private var name: String = _

  def setName(name: String) = this.name = name

  def getName = this.name

}

// 伴生对象
object Student {

  def study(subject: String) = println(s"studying ${subject}")

}
