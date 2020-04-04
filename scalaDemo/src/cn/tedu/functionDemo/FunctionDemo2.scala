package cn.tedu.functionDemo

object FunctionDemo2 {
  //获取一到十之间的随机整数
  //def rand()=(Math.random()*10+1).toInt

  //如果在定义函数的时候 函数体没有参数 那么函数体的参数的小括号可以省略不写
  def rand =(Math.random()*10+1).toInt
  def main(args: Array[String]): Unit = {
    //如果原函数有小括号 那么在调用的时候可以省略括号也可以不用省略
    //但是如果省略吊括号 调用的时候就必须吧括号省略掉
    //println(rand())
    println(rand)
  }

}
