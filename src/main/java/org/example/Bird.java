package org.example;

public abstract class Bird {

    private int age;

    public Bird(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void Fly();
}
