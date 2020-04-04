package cn.tedu.objectx

object Resvert {
  //对当前得数组的值进行重置 倒叙排列

  def main(args: Array[String]): Unit = {
    var a =Array(1,2,3,4,5,6,7)
    res(a)
    a.foreach(println)
    }
  def res(arr: Array[Int]) = {
    for (i <- 0 until (arr.length-1)/2) {
      var t=arr(i)
      arr(i)=arr(arr.length-1-i)
      arr(arr.length-1-i)=t
    }
  }
  /*def main(args: Array[String]) {
    val a = Array(1, 2, 3, 4,5,6);
    revert(a);
    a.foreach(println);
  }

  def revert(arr : Array[Int]) = {
    //--Array(1,2,3,4,5,6)  length=6个
    //--0 until 5  by 2 ->0  2  4//--①i=0  arr(0)<->arr(1)
    //--②i=2  arr(2)<->arr(3)
    //--③i=4  arr(4)<->arr(5)
    for (i <- 0 until (arr.length-1, 2)){
    val t = arr(i);
    arr(i) = arr(i + 1);
    arr(i + 1) = t;
  }
}*/

}
