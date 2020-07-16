package com.guoguo.datastructureandalgorithm.algorithm.Audition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-15 21:21
 */


/**
 *  用synchronized不足:
 *     使用synchronized(this)、this.wait()、this.notifyAll()，这些同步机制都和当前对象this有关。
 *     因为synchronized (obj)可以使用任意对象对应的对象锁，而Object.wati()和Object.notifyAll()方法又都是public方法。
 *     也就是说不止在阻塞队列类内部可以使用这个阻塞队列对象的对象锁及其对应的条件变量。
 *     如果在外部代码中获取了阻塞队列对象上的对象锁和对应的条件变量，那么就有可能发生外部代码滥用阻塞队列对象上的对象锁导致阻塞队列性能下降甚至发生死锁的情况
 *
 *  一个更加安全的锁方案 , 用 ReentrantLock 和 Condition . 详见BoxWithReentrantLock
 *  Condition可以分组唤醒需要唤醒的线程.
 *
 */
public class MQTest {



    static class BoxWithReentrantLock{

        private List<Integer> container = new ArrayList<>();

        private Integer capacity = 10;

        private Lock reentrantLock = new ReentrantLock();

        private Condition putCondition = reentrantLock.newCondition();

        private Condition getCondition = reentrantLock.newCondition();

        public void put(Integer integer){

            reentrantLock.lock();
            try {
                while (container.size() >= capacity){
                    System.out.println("队列已满, now container size : " + container.size());
                    putCondition.await();
                }

                container.add(integer);
                getCondition.signalAll();
                System.out.println("put finish , now contanier size : " + container.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }


        }


        public Integer get(){
            Integer remove = null;
            reentrantLock.lock();
            try {
                while (container.size() <= 0){
                    System.out.println("队列已空");
                    getCondition.wait();
                }
                remove = container.remove(container.size() - 1);
                getCondition.signalAll();
                System.out.println("get finish , now container size :" + container.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
            return remove;
        }

    }


    static class Box{

        private List<Integer> container = new ArrayList<>();

        private Integer capacity = 10;


        public void put(Integer integer){

           synchronized (this){

               while (container.size() >= capacity){
                   try {
                       System.out.println("队列已满, now container size : " + container.size());
                       wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

               container.add(integer);
               notifyAll();
               System.out.println("put finish , now contanier size : " + container.size());
           }

        }


        public Integer get(){
            Integer remove = null;
            synchronized (this){

                while (container.size() <= 0){
                    try {
                        System.out.println("队列已空");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                remove = container.remove(container.size() - 1);
                notifyAll();
                System.out.println("get finish , now container size :" + container.size());
            }
            return remove;
        }

    }


    static class Produce{

        private Box box;

        Produce(Box box){
            this.box = box;
        }

        public void put(Integer integer){
            this.box.put(integer);
        }
    }


    static class Customer{

        private Box box;

        Customer(Box box){
            this.box = box;
        }

        public Integer get(){
           return this.box.get();
        }

    }


    public static void main(String[] args) {

        Box box = new Box();
//
//        new Thread(()->{
//            for (int i = 0 ; i < 100 ; i ++ ){
//                Produce produce = new Produce(box);
//                produce.put(i);
//            }
//        }).start();
//
//
//        new Thread(()->{
//            for (int i = 0 ; i < 100 ; i ++ ){
//                Customer customer = new Customer(box);
//                customer.get();
//            }
//        }).start();

        for (int i = 0 ; i < 100 ; i ++ ){
            final int j = i;
            new Thread(()->{
                Produce produce = new Produce(box);
                produce.put(j);
            }).start();

        }

        for (int i = 0 ; i < 100 ; i ++ ){
            final int j = i;
            new Thread(()->{
                Customer customer = new Customer(box);
                customer.get();
            }).start();

        }


    }


}