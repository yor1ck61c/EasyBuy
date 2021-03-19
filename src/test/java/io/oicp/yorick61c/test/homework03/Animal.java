package io.oicp.yorick61c.test.homework03;

public class Animal {
    int height;
    int weight;

    public Animal () {

    }//构造方法 用于创建对象

    public Animal (int height, int weight) {

    }//构造方法  用于赋值

    public void walk() {
        System.out.println("Im walking...");
    }

    public static void main(String[] args) {

        Animal Cat = new Animal();
        Cat.height = 20;
        Cat.weight = 20;

        Animal Dog = new Animal(20,20);
    }
}


