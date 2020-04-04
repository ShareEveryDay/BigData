package cn.tedu.objectx

object TraitDemo {

  def main(args: Array[String]): Unit = {

    // 对象的特质混入
    var r = new SqlLiteDao with UserDao {
      override def addName(name: String): Unit = println("")

      override def addAge(age: Int): Unit = println("")
    }

  }

}

// trait中可以定义实体函数
trait UserDao {

  var url: String = _

  def addName(name: String)

  def addAge(age: Int)

  def deleteName(name: String) = println("删除了" + name)

}

trait JDBCUtil

// 如果这个类本身没有继承的父类，那么可以使用extends关键字来继承特质
class MysqlUserDao extends UserDao with JDBCUtil {
  override def addName(name: String): Unit = println("向Mysql中添加了" + name)

  override def addAge(age: Int): Unit = println("向Mysql中添加了" + age)

}

// 如果这个类本身有父类，那么这个类需要with关键字来混入特质
class OracleDao extends AnyRef with UserDao with JDBCUtil {
  override def addName(name: String): Unit = println("向Oracle中添加了" + name)

  override def addAge(age: Int): Unit = println("向Oracle中添加了" + age)
}

class SqlLiteDao