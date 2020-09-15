package base;

public class Student {
    private int age;
    private float averageMark;
    private String name;
    private String surname;

    public Student(int age, float averageMark, String name, String surname){
        this.age = age;
        this.averageMark = averageMark;
        this.name = name;
        this.surname = surname;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setaverageMark(float averageMark){
        this.averageMark = averageMark;
    }

    // getters
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public int getAge(){
        return this.age;
    }
    public float getAverageMark(){
        return this.averageMark;
    }

    @Override
    public String toString(){
        return this.surname + " " + this.name + " " + this.age + " - averageMark: " + this.averageMark;
    }
}
