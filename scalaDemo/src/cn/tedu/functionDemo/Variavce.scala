package cn.tedu.functionDemo

object Variavce {
  def main(args: Array[String]): Unit = {
   val l1=List(1,2,3,4,5)
    println(variance(l1))
  }
  //计算一个参数的方差
  def variance(list: List[Int])={
    var sum=0;
    for(i <-0 until list.size){
      sum=sum+list(i)
    }
    val average=sum/list.size
    //求一个数组的方差 --每一个元素减去平均值的平方和加起来再去除以size
    var difference=0
    for(i <-0 until list.size){
      difference+=(list(i)-average)*(list(i)-average)
    }
    difference/list.size
  }
}
