package com.zsf.create2;

import java.util.Random;
import java.util.concurrent.*;

public class RandomCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(6000);
        return new Random().nextInt(10);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建一个线程对象
        Callable<Integer> callable = new RandomCallable();
        FutureTask<Integer> task = new FutureTask(callable);
        Thread thread1 = new Thread(task);
        //2.启动线程
        thread1.start();
        //3.返回值
        System.out.println(task.isDone());
        int result = 0;
        try {
            result = task.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(task.isDone());
        System.out.println(result);

    }
}
