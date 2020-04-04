package cn.tedu.demo

object OperatorDemo {

  def main(args: Array[String]): Unit = {

    // 算术运算符
    // + - * / %
    var i = 3
    var j = 5
    // Scala将所有的运算符都封装成了函数
    // 等价于:var sum = i.+(j)
    var sum = i + j
    // var mul = i.*(j)
    var mul = i * j
    println(sum)

    println(5 + 3 * 7)
    // 如果出现.，需要先执行.运算
    println(5.+(3) * 7)
    // 如果全部都有.，那么顺次计算
    println(5.+(3).*(7))

    // 在Scala中，String也可以参与+和*运算
    var str1 = "abc"
    var str2 = "def"
    var str = str1 + str2
    println(str)

    // 当字符串*数字的时候，表示这个字符串要出现几次
    var str3 = "*" * 5
    println(str3)

    // 在Scala中对于字符串的打印提供了不同的方式
    var name = "Amy"
    var age = 15
    var gender = "female"
    println("name=" + name + ", age=" + age + ", gender=" + gender)
    println(s"name=${name}, age=${age}, gender=${gender}")
  }

}
