package base;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
	    System.out.println("POO");

	    ArrayList<University> universities = new ArrayList<>();

	    University UTM = new University(1964, "Technical University of Moldova");
	    University ASEM = new University(1991, "Academia de Stiinte Economice Moldovei");
	    University ULIM = new University(1991, "Universitatea Libera Internationala Moldovei");

	    universities.add(UTM);
        universities.add(ASEM);
        universities.add(ULIM);

        Student Basso = new Student(20, 10, "Nicolae", "Basso");
        UTM.addStudent(Basso);

        // add some randomly generated students
        // to universities (check University.java)
        UTM.addXStudents(3);
        ULIM.addXStudents(5);
        ASEM.addXStudents(11);

        UTM.printStudents();
        UTM.printAverage();

        ULIM.printStudents();
        ULIM.printAverage();

        ASEM.printStudents();
        ASEM.printAverage();

        double totalUniversitiesSum = 0;
        int totalStudents = 0;
        for(University university: universities){
            for(Student student: university.getStudentList())
                totalUniversitiesSum += student.getAverageMark();

            totalStudents += university.getStudentList().size();
        }

        System.out.println("\nTotal university average is: " + totalUniversitiesSum / totalStudents);
    }
}
