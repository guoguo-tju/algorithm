package com.guoguo.datastructureandalgorithm.algorithm.Audition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: 手写线程池
 *
 * @author guozh
 * @create 2020-07-14 20:34
 */
public class ThreadPoolTest {


    private int coreSize;

    private int maxSize;

    private BlockingQueue<Runnable> queue;

    private AtomicInteger runThreadNum = new AtomicInteger(0);

    private List<WorkThread> workThreads;


    public ThreadPoolTest(int coreSize , int maxSize , BlockingQueue<Runnable> queue ){
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.queue = queue;
        this.workThreads = new ArrayList<WorkThread>();
    }

    public void execute(Runnable runnable){

        if (runThreadNum.get() < coreSize){
            // 正在运行的线程数小于核心线程数 , 新建核心线程
            if (!addWorkThread(runnable)){
                reject();
            }
        }else {
            System.out.println("当前队列大小："+queue.size());
            // 正在运行的线程数大于等于核心线程数 , 放入等待队列中
            // 队列容量已满的情况下 , add会抛出异常 , offer只会返回false
            if (!queue.offer(runnable)){
                System.out.println("offer 失败,当前线程数："+ runThreadNum.get());
                // 队列已满会先创建线程 , 如果达到最大线程数, 才会拒绝
                if (!addWorkThread(runnable)){
                    reject();
                }
            }
        }
    }


    public void shutDown(){
        for (WorkThread workThread : this.workThreads) {
            workThread.cancel();
        }
        queue.clear();
    }



    /**
     * 拒绝策略
     */
    private void reject() {
        throw new RuntimeException("当前线程数超过最大线程数");
    }

    /**
     * 增加工作线程
     * @param runnable
     */
    private boolean addWorkThread(Runnable runnable) {

        // 如果当前线程数大于等于最大线程数,新增失败
        if (runThreadNum.get() >= maxSize){
            System.out.println("当前线程数大于等于最大线程数 , runThreadNum = " + runThreadNum.get());
            return false;
        }

        WorkThread workThread = new WorkThread(runnable);
        workThread.start();
        workThreads.add(workThread);
        return true;
    }



    private class WorkThread extends Thread{

        private Runnable runnable;

        private Boolean on = true;

        public WorkThread(Runnable runnable){
            this.runnable = runnable;
            // 增加当前运行线程数
            System.out.println("创建线程:当前线程数:"+runThreadNum.incrementAndGet());
        }

        @Override
        public void run(){
            try {
                while (on){
                    synchronized (queue){
                        runnable.run();
                        System.out.println("运行结束,当前线程数："+runThreadNum.get());
                        // 如果当前线程数量大于核心线程数量 , 并且队列不是满的, 退出线程
                        if (runThreadNum.get() >= coreSize && queue.remainingCapacity() > 0){
                            break;
                        }else {
                            // 反之从队列中取任务
                            System.out.println("000000：队列大小："+queue.size());
                            Runnable take = queue.take();
                            runnable = take;
                            System.out.println("11111111：队列大小："+queue.size());
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                runThreadNum.decrementAndGet();
                System.out.println("结束线程，当前线程数："+runThreadNum.get());
            }

        }

        public void cancel(){
            this.on = false;
        }

    }


    public static void main(String[] args) {

        ThreadPoolTest threadPoolTest = new ThreadPoolTest(2, 3, new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 100 ; i ++ ){
            final int j = i;
            threadPoolTest.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡0.1秒 完成:"+j);
            });
        }
    }



}