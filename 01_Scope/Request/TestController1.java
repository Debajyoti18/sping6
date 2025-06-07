@RestController
@Scope("request")
public class TestController1 {
    @Autowired
    User user;

    @Autowired
    Student student;

    public TestController1() {
        System.out.println("TestController1 instance initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestController1 object hashCode: " + this.hashCode() +
            "\n  User object hashCode: " + user.hashCode() +
            "\n  Student object hashCode: " + student.hashCode());
    }
}
