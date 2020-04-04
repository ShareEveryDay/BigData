package cn.tedu.objectx.extendes

object ExtendsDemo {

  def main(args: Array[String]): Unit = {

    var c = new Cat
    c.eat

    var a: Animal = new Cat
    a.eat

  }

}

class Animal(age: Int) {

  protected var name: String = _

  def eat = println("eating")

}

// public Cat(int age){
//  super(age);
// }
// class Cat(age: Int) extends Animal(age) {
// public Cat(){
//  super(0);
// }
class Cat extends Animal(0) {

  // override var name: String = _

  // 重写的时候，要求必须添加这个关键字
  override def eat = println("eating fish")

}
