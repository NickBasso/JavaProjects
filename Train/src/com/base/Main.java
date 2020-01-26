package com.base;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/com/base/input");
        Scanner scan = new Scanner(file);
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.nextInt());
    }
}
