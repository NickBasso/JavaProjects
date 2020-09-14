package base;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main {

    public static void main(String[] args) throws IOException {
	    System.out.println("POO");
        Scanner scan = new Scanner(System.in);

        /*InputStream is = null;
        try {
            is = new FileInputStream("src/base/names.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = null;
        ArrayList<String> names = new ArrayList<String>();

        try {
            line = buf.readLine();
            System.out.println(line);

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < line.length() - 1; i++){

                if(line.charAt(i) == '"' && line.charAt(i + 1) == ','){
                    names.add(sb.toString());
                    sb.delete(0, sb.length());
                } else if(isLetter(line.charAt(i))){
                    sb.append(line.charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        //////////
        is = null;
        try {
            is = new FileInputStream("src/base/surnames.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        buf = new BufferedReader(new InputStreamReader(is));
        line = null;
        ArrayList<String> surnames = new ArrayList<String>();

        try {
            line = buf.readLine();
            System.out.println(line);

            sb = new StringBuilder();

            for(int i = 0; i < line.length() - 1; i++){

                if(line.charAt(i) == '"' && line.charAt(i + 1) == ','){
                    surnames.add(sb.toString());
                    sb.delete(0, sb.length());
                } else if(isLetter(line.charAt(i))){
                    sb.append(line.charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb = new StringBuilder();

        names.stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println("/v///////////////////////////////////////////v");
        surnames.stream().forEach(e -> {
            System.out.println(e);
        });*/

        /*
        Student Basso = new Student(20, 10, "Alexandr Boico");
	    Student Boico = new Student(20, 9.7, "Alexandr Boico");
        Student Britski = new Student(20, 6, "Alexandr Boico");
        Student Tcacenco = new Student(20, 6, "Alexandr Boico");
        Student Cambur = new Student(20, , "Alexandr Boico");
        Student Gavirlita = new Student(20, 10, "Alexandr Boico");
        Student Turcanu = new Student(20, 10, "Alexandr Boico");
        Student Petranis = new Student(20, 10, "Alexandr Boico");
        */





	    University UTM = new University(1964, "Technical University of Moldova");
        Student Basso = new Student(20, 10, "Nicolae", "Basso");
        UTM.addStudent(Basso);

        FormattedStringArrayList names = new FormattedStringArrayList("src/base/names.txt");
        FormattedStringArrayList surnames = new FormattedStringArrayList("src/base/surnames.txt");

        for(int i = 0; i < Math.min(names.getSize(), surnames.getSize()); i++){
            int nameIndex = (int)(Math.random() * names.getSize() - 1);
            int surnameIndex = (int)(Math.random() * surnames.getSize() - 1);
            int mark = (int)(Math.random() * 10 + 1);
            int age = (int)(Math.random() * 100);


            UTM.addStudent(new Student(age, mark, names.getStringByIndex(nameIndex), surnames.getStringByIndex(surnameIndex)));
        }

        UTM.printStudents();
    }
}
