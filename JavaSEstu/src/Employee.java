import myInterface.Animal;

public class Employee implements Animal {
    private static int nextId;
    private int id;
    private String name;
    int year;
    public int age(){
        return year;
    }
    private double salary;
    {
        id = nextId;
        nextId++;
    }
    public Employee(){}
    public Employee(String aName, double aSalary){
        name = aName;
        salary = aSalary;
    }
    public Employee(double s){
        this("Employee #" + nextId, s);
    }
    public boolean equals(Object obj){
        //快速检测一下是否对象是同一个（完全相同的）
        if (this == obj) return true;

        if (obj == null) return false;
        if (getClass() != obj.getClass()){
            return false;
        }
        Employee other = (Employee) obj;
        return name.equals(other.name) && salary == other.salary;
    }
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

