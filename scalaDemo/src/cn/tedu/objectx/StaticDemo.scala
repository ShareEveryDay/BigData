package cn.tedu.objectx

object StaticDemo {

  def main(args: Array[String]): Unit = {
    println(Calculator.sum(3, 7))
    var c = new Calc
    c.sum(3, 6)
  }

}

object Calculator {

  def sum(i: Int, j: Int) = i + j

  def minus(i: Int, j: Int) = i - j

}

class Calc {

  def sum(i: Int, j: Int) = i + j

}