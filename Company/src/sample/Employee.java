package sample;

public class Employee extends Definitions{
    // fields
    private String name = undefinedString;
    private String surname = undefinedString;
    private String role = undefinedString;
    private int age = undefinedInt;
    private double salary = undefinedDouble;

    // constructor
    public Employee(String thisName, String thisSurname, String thisRole, int thisAge, double thisSalary){
        name = thisName;
        surname = thisSurname;
        role = thisRole;
        age = thisAge;
        salary = thisSalary;
    }

    // setters (set methods)
    protected void setName(String thisName){
        name = thisName;
    }

    protected void setSurname(String thisSurname){
        surname = thisSurname;
    }

    protected void setRole(String thisRole){
        role = thisRole;
    }

    protected void setAge(int thisAge){
        age = thisAge;
    }

    protected void setSalary(double thisSalary){
        salary = thisSalary;
    }

    // print methods
    protected void printSalary(){
        System.out.println(name + " " + surname + " salary is:  " + salary + " $");
    }

    protected void printName() {
        System.out.println(name);
    }

    protected void printSurname(){
        System.out.println(surname);
    }

    protected void printAge(){
        System.out.println(age);
    }

    protected void printRole(){
        System.out.println(role);
    }
}
