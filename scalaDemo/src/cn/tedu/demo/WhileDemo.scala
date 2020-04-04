package cn.tedu.demo

object WhileDemo {

  def main(args: Array[String]): Unit = {

    var sum = 0
    var i = 1
    val r = while (i <= 10) {
      sum += i
      i += 1
    }
    println(sum)
    println(r)

    var j = 1;
    val r2 = do {
      println(j)
      j += 1
    } while (j <= 10)
    println(r2)

  }

}
