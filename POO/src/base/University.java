package base;

import java.io.IOException;
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

    public void addXStudents(int amount) throws IOException {
        FormattedStringArrayList names = new FormattedStringArrayList("src/data/names.txt");
        FormattedStringArrayList surnames = new FormattedStringArrayList("src/data/surnames.txt");

        for(int i = 0; i < amount; i++){
            int nameIndex = (int)(Math.random() * names.getSize() - 1);
            int surnameIndex = (int)(Math.random() * surnames.getSize() - 1);
            float mark = (float)(Math.random() * 9 + 1);
            int age = (int)(Math.random() * 100);

            this.addStudent(new Student(age, mark, names.getStringByIndex(nameIndex), surnames.getStringByIndex(surnameIndex)));
        }
    }

    public ArrayList<Student> getStudentList(){
        return this.students;
    }

    public void printAverage(){
        System.out.println(this.getUniversityAverage());
    }

    public double getUniversityAverage() {
        double sum = 0;
        for(Student student: this.students)
            sum += student.getAverageMark();

        return sum / this.students.size();
    }

    public void printStudents(){
        students.stream().forEach(student -> {
            System.out.println(student);
        });
    }


}
