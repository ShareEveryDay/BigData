package cn.tedu.objectx

object ClassDemo2 {

  def main(args: Array[String]): Unit = {

    var s = new Student
    s.setAge(15)
    // s.study
  }

}

class Student {

  private var name: String = _
  private var age: Int = _
  // 在cn包中私有，在cn包以外不能用
  // cn.tedu.objectx.classx
  private[cn] var gender: String = _

  def setAge(age: Int) = this.age = age

  protected def study = "studying"

}