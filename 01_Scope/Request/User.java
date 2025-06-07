@Component
@Scope("request")
public class User {
    @Autowired
    Student student;

    public User() {
        System.out.println("User initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("User object hashCode: " + this.hashCode() +
            "\n  Student inside User object hashCode: " + student.hashCode());
    }
}
/*
 * Output:
 TestController1 instance initialization
User initialization
User object hashCode: 39793904(same)
Student instance initialization
Student object hashCode: 275139209
TestController1 object hashCode: 89867761 User object hashCode: 39793904(same bcz one per request) Student object hashCode: 275139209
fetchUser api invoked

for second request -
TestController1 instance initialization
User initialization
User object hashCode: 11223344(s)
Student instance initialization
Student object hashCode: 55667788
TestController1 object hashCode: 77889900 User object hashCode: 11223344 (S) Student object hashCode: 55667788
fetchUser api invoked


 */