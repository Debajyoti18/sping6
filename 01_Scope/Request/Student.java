@Component
@Scope("prototype")
public class Student {
    public Student() {
        System.out.println("Student initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("Student object hashCode: " + this.hashCode());
    }
}
