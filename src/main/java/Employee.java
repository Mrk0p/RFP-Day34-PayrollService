import java.sql.Date;

public class Employee {

    int  Id;
    String Name;
    double Salary   ;
    Date startDate;
    String Gender;
    public Employee(int id, String name, double salary, Date startDate, String Gender) {
        super();
        this.Id = id;
        this.Name = name;
        this.Salary = salary;
        this.startDate = startDate;
        this.Gender = Gender;
    }
}
