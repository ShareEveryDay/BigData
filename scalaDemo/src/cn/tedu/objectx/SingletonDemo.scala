package cn.tedu.objectx.Singles

object SingletonDemo {

  def main(args: Array[String]): Unit = {

    var a1 = A.getInstance
    var a2 = A.getInstance
    var a3 = A.getInstance
    var a4 = A.getInstance
  }

}

class A private()

object A {

  private var a = new A

  def getInstance = a

}