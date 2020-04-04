package cn.tedu.objectx.Constructores

object ConstructorDemo {

  def main(args: Array[String]): Unit = {

    var s = new Student("Amy", 15)

  }

}

// 构造器
// 在构造器中定义的参数默认就是当前类中的属性
class Student(name: String, age: Int) {

  // 在类中的代码，除了属性和函数以外，其他的在编译的时候会自动编译到构造器中
  if (age < 0)
    throw new IllegalArgumentException

  private var gender: String = _

  // 辅构造器
  // 在辅构造器中，先调用主构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }

  def study = "studying"

}
