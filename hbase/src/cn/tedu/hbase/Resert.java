package cn.tedu.hbase;

public class Resert {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6};
        resert(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static  void resert(int[] a){
        for(int i=0;i<a.length/2;i++){
            int m=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=m;
        }
    }
}
