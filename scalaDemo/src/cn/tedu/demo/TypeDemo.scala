package cn.tedu.demo

object TypeDemo {

  def main(args: Array[String]): Unit = {

    // 数据类型类型
    // 隐式转换/自动转换
    // 方式一：默认类型转换
    var i = 5
    // 如果这样声明，没有指定类型，那么根据类型推导，此时d和i的类型是一致
    // var d = i
    var d: Double = i
    var dog = new Dog()
    var a: Animal = dog

    // 方式二：自定义转换规则
    // 在Scala中，如果需要自定义转换规则，那么就需要通过隐式函数来实现
    implicit def strToInt(str: String): Int = {
      return Integer.parseInt(str)
    }

    var str = "123"
    // 如果定义了隐式函数，那么在类型匹配的情况下，自动调用隐式函数
    // 此时从形式上看就是自动类型转换
    var j: Int = str

    // 显式转换
    // 方式一：AnyVal的转换
    var d2 = 3.58
    var i2: Int = d2.toInt
    var c: Char = d2.toChar
    // 方式二：父类向子类转化：对象.asInstanceOf[要转换的类型]
    var animal: Animal = new Dog
    var dog2: Dog = animal.asInstanceOf[Dog]

  }

}
