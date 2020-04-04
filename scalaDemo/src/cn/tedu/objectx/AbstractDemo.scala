package cn.tedu.objectx

object AbstractDemo {

  def main(args: Array[String]): Unit = {

    var a = new Animal {
      override def eat(): String = "eating"

      override def sleep: Unit = println("sleeping")
    }

    a.eat
  }

}

abstract class Animal {

  // 可以abstract，只要不写函数体
  // 抽象函数
  def eat(): String

  // 如果不指定，那么返回值类型就是Unit
  def sleep

  // 实体函数
  def drink = println("drinking")

}

class Dog extends Animal {

  override def eat(): String = "eating bone"

  override def sleep: Unit = println("sleeping")

}