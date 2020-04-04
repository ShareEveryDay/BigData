package cn.tedu.demo

object VarDemo2 {

  def main(args: Array[String]): Unit = {

    // var定义变量
    // val定义常量
    // 定义格式一: var 变量名 : 数据类型 = 变量值
    // int i = 5;
    var i: Int = 5
    // double j = 7.2;
    var j: Double = 7.2
    // final char k = 'a';
    val k: Char = 'a'

    // 定义格式二：var 变量名 = 变量值
    // 这种格式下，在编译的时候会根据赋值自动推导数据类型
    var x = 3
    var y = 5.28

    // 如果是向上造型，那么必须手动指定类型
    // d会认为是Dog类型
    var d = new Dog()
    // 如果需要使用向上造型，那么需要手动指定Animal类型
    var a: Animal = new Dog()

    /*
      Java中:
        int m;
        m = 5;
     */
    // var m:Int;
    // m = 5
  }

}

// 如果一个类中没有属性没有方法，可以省略{}
class Animal

class Dog extends Animal
