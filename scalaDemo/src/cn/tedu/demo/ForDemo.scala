package cn.tedu.demo

import scala.io.StdIn

object ForDemo {

  def main(args: Array[String]): Unit = {

    // 求1-10的和
    /*
      int sum = 0;
      for(int i = 1; i <= 10; i++)
        sum += i;
     */
    // var sum = 0
    // for (i <- 1 to 10)
    //   sum += i
    // println(sum)

    /*
      *****
      *****
      *****
      *****
     */
    // for (i <- 1 to 4)
    //   println("*" * 5)

    // for (i <- 1 to 5)
    //   println(i)

    // 遍历数组
    // 在Java中，等价于int[] arr = {3, 5, 6, 8, 1, 5};
    // var arr = Array[Int](3, 5, 6, 8, 1, 5)
    // 在Java中，遍历数组：for(int i = 0; i < arr.length; i++)
    // to arr.length ---> <= arr.length
    // for(i <- 0 to arr.length - 1)
    //   println(arr(i))
    // 等价于：
    // until arr.length ---> < arr.length
    // for (i <- 0 until arr.length)
    //   println(arr(i))

    // 输入一个数字，构建一个集合：
    // 例如输入数字5， 构建{1, 4, 9, 16, 25}
    val n = StdIn.readInt()
    // 等价于int[] arr = new int[n];
    // val arr = new Array[Int](n)
    // for (i <- 1 to n)
    //   arr(i) = i * i
    // yield会将后边表达式的计算结果放到一个集合中返回
    val r = for (i <- 1 to n) yield i * i
    println(r)

  }

}
