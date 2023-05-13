public class Manager extends Employee {
    private double bonus;
    public Manager(){}
    public Manager(String name,double salary){
        super(name,salary);
        this.bonus = 0;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public void setSalary(double salary){
        super.setSalary(salary);
    }
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }


}
