package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InputFile {
    public void DriveFileInput() throws Exception{
        System.out.println("Input using Scanner");
        ScannerInput();
        PrintNewLine();

        System.out.println("Input using Scanner with loops");
        ScannerLoopInput();
        PrintNewLine();

        System.out.println("Input using BufferedReader");
        BufferedReaderInput();
        PrintNewLine();

        System.out.println("Input using FileReader");
        FileReaderInput();
        PrintNewLine();

        System.out.println("Input using iterations in List");
        ListInput();
        PrintNewLine();

        System.out.println("Input using a stored data in a single String");
        StringInput();
        PrintNewLine();
    }

    public void FileReaderInput() throws Exception{
        FileReader fr = new FileReader("src/com/base/input");

        int i;
        while((i = fr.read()) != -1)
            System.out.print((char) i);
    }

    public void ScannerInput() throws Exception{
        File file = new File("src/com/base/input");
        Scanner scan = new Scanner(file);
        //scan.useDelimiter("\n");

        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
        System.out.println(scan.next());
    }

    public void ScannerLoopInput() throws Exception{
        File file = new File("src/com/base/input");
        Scanner scan = new Scanner(file);
        //scan.useDelimiter("\n");

        while(scan.hasNextLine())
            System.out.println(scan.nextLine());
    }

    public void BufferedReaderInput() throws Exception{
        // Java Program to illustrate reading from FileReader
        // using BufferedReader

        File file = new File("src/com/base/input");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

    // Java program to illustrate reading data from file
// using nio.File
    public void ListInput() throws Exception {
        String fileName = "src/com/base/input";
        List<String> lines = Collections.emptyList();
        try {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {

            // do something
            e.printStackTrace();
        }

        List l = lines;

        Iterator<String> itr = l.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }

    public void StringInput() throws Exception{
        String fileName = "src/com/base/input";
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.println(data);
    }

    public void PrintNewLine(){
        System.out.println("\n\n\n");
    }
}
