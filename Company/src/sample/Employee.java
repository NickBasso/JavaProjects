package sample;

public class Employee extends Definitions{
    String name = undefinedString;
    String surname = undefinedString;
    String role = undefinedString;
    int age = undefinedInt;
    double salary = undefinedDouble;

    public Employee(String thisName, String thisSurname, String thisRole, int thisAge, double thisSalary){
        name = thisName;
        surname = thisSurname;
        role = thisRole;
        age = thisAge;
        salary = thisSalary;
    }

    public void setRole(String thisRole){
        role = thisRole;
    }

    public void setAge(int thisAge){
        age = thisAge;
    }

    public void setSalary(double thisSalary){
        salary = thisSalary;
    }

    public void printSalary(){
        System.out.println(name + " " + surname + " salary is:  " + salary + " $");
    }

    public void printName(){
        System.out.println(name);
    }

    public void printSurname(){
        System.out.println(surname);
    }

    public void printAge(){
        System.out.println(age);
    }

    public void printRole(){
        System.out.println(role);
    }
}
