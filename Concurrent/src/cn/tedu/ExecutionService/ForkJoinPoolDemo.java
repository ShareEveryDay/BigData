package cn.tedu.ExecutionService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> submit = pool.submit(new Sum(1, 100000000L));
        System.out.println(submit.get());
        pool.shutdown();
    }
}
class Sum extends RecursiveTask<Long>{
    private long start;
    private long end;

    public Sum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end-start<500000){
            long sum=0;
            for(long i=start;i<end;i++){
                sum+=i;
            }
            return sum;
        }else {
            Long mid=(end+start)/2;
            //范围比较大 需要将两个继续拆分 拆封成两组
            Sum left=new Sum(start,mid);
            Sum right=new Sum(mid+1,end);
            //需要将两份再分成两份线程来计算
            left.fork();
            right.fork();
            //需要将拆分的两份记过来进行汇总
            return left.join()+ right.join();
        }
    }
}
