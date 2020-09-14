package base;

public class Student {
    private int age;
    private int mark;
    private String name;
    private String surname;

    public Student(int age, int mark, String name, String surname){
        this.age = age;
        this.mark = mark;
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
    public void setMark(int mark){
        this.mark = mark;
    }

    // getters
    public String getName(String name){
        return this.name;
    }
    public String getSurname(String surname){
        return this.surname;
    }
    public int getAge(int age){
        return this.age;
    }
    public int getMark(int mark){
        return this.mark;
    }

    @Override
    public String toString(){
        return this.surname + " " + this.name + " " + this.age + " - mark: " + this.mark;
    }
}
