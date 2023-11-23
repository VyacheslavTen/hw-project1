package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.


        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

        Bird bird = new Bulfinch(3);
        System.out.println(bird.getAge());
        bird.setAge(5);
        System.out.println(bird.getAge());
        Bird bird2 = new Bulfinch(4);
        System.out.println(bird.getAge());

    }
}