package com.guoguo.datastructureandalgorithm.algorithm.Audition;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author guozh
 * @create 2020-07-15 21:21
 */
public class MQTest {


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

        new Thread(()->{
            for (int i = 0 ; i < 100 ; i ++ ){
                Produce produce = new Produce(box);
                produce.put(i);
            }
        }).start();


        new Thread(()->{
            for (int i = 0 ; i < 100 ; i ++ ){
                Customer customer = new Customer(box);
                customer.get();
            }
        }).start();
    }


}