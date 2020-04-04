package cn.tedu.objectx

object ClassDemo {

  def main(args: Array[String]): Unit = {

    var p = new Person
    // 一个对象在调用函数的时候，如果这个函数只有一个参数，那么可以省略.和()不写
    // p.setName("Alex")
    // p.setAge(15)
    // 等价于：
    p setName "Alex"
    p setAge 15
    println(p.getName)

  }

}

// Animal类中没有属性和函数，那么可以省略{}
// class Animal

class Person {

  // 给定_的时候，在创建对象的时候，会自动给这个属性默认值
  private var name: String = _
  private var age: Int = _

  def setName(name: String) = this.name = name

  def getName = this.name

  def setAge(age: Int) = this.age = age

  def getAge = this.age

}