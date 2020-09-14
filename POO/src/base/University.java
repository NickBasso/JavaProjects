package base;

import java.util.ArrayList;

public class University {
    private int founded;
    private String name;
    private ArrayList<Student> students;

    public University(int founded, String name){
        this.founded = founded;
        this.name = name;
        this.students = new ArrayList<>();
    }

    // setters
    public void setFounded(int founded){
        this.founded = founded;
    }

    public void setName(String name){
        this.name = name;
    }

    // getters
    public int getFounded(){
        return this.founded;
    }

    public String getName(){
        return this.name;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void printStudents(){
        students.stream().forEach(student -> {
            System.out.println(student);
        });
    }
}
