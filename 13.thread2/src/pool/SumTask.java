package pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long>{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.使用循环求和
        //Cpu有四个核,一个核完成任务，其他核看戏
        int n = 100;
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("for loop:" +sum);
        //2.使用ForkJoin求和
        //2.1创建一个ForkJoin线程池
        ForkJoinPool pool = new ForkJoinPool();

        //2.2给出一个求和的任务
        RecursiveTask task = null;
        //2.3将任务交给线程池(线程池会分解任务并合并结果)
        Future<Long> future = pool.submit(task);
        //2.4获取结果，并输出
        long result = future.get();
        System.out.println("forkjoin:"+result);
        //2.5关闭线程池
        pool.shutdown();

    }

    @Override
    protected Long compute() {
        return null;
    }
}
