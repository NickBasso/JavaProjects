package com.base;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("src/com/base/input");
        Scanner scan = new Scanner(file);
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.nextInt());

        PrintNewLine();
        BufferedReaderInput();
    }

    public static void BufferedReaderInput() throws Exception{
        // Java Program to illustrate reading from FileReader
        // using BufferedReader

            File file = new File("src/com/base/input");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
    }

    public static void PrintNewLine(){
        System.out.println("\n\n\n");
    }
}
