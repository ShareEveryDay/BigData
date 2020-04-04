package cn.tedu.objectx

import java.io.{File, FileNotFoundException}

object ExceptionDemo {

  def main(args: Array[String]): Unit = {

    var a = new A
    try {
      a.readFile("D:\\a.txt")
    } catch {
      case e: FileNotFoundException => println(e.getMessage)
      case e: IndexOutOfBoundsException => e.printStackTrace
    }
  }

}

class A {

  // 这个注解仅作提示作用，不强制要求处理
  @throws[FileNotFoundException]
  def readFile(path: String) = {

    if (!new File(path).exists())
      throw new FileNotFoundException
  }

}
