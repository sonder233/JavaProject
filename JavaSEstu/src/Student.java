public class Student extends Person{
    private String major;

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
