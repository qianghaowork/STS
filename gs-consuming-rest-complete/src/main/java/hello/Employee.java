package hello;

/**
 * Created by qianghao on 3/2/17.
 */
public class Employee {
    public Employee(Integer id, Integer age, String gender, String fName, String lName){
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    //Please generate Getter and Setters

    @Override
    public String toString() {
        return this.id.toString()+" - "+this.age.toString() + " - " + this.firstName; //To change body of generated methods, choose Tools | Templates.
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getFirst() { return this.firstName; }
}
