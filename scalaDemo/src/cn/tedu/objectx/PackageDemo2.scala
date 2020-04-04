package cn.tedu.objectx

// 在Scala中，导包的时候允许给包起别名
import java.sql.{Date => SqlDate}
import java.util.{Date => UtilDate}

object PackageDemo2 {

  def main(args: Array[String]): Unit = {
    // fun.test
    // 如果一个函数调用的时候没有参数，可以省略()不写的
    var date = new UtilDate
    var date2 = new SqlDate(788)
  }

}

// 在Scala中，支持函数式编程和面向对象 -> 函数在Scala中是一等公民
// 函数可以定义在任何位置
// 包对象
package object fun {
  def test = println("testing~~~")
}

