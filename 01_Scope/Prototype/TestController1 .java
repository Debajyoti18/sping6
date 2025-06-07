@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping(value = "/api1")
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
            " \n  User object hashCode: " + user.hashCode() +
            " \n  Student object hashCode: " + student.hashCode());
    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("fetchUser api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
/*
 * OUTPUT:-
 * User initialization
User object hashCode: 44444444

TestController1 instance initialization
TestController1 object hashCode: 55555555
  User object hashCode: 44444444
  Student object hashCode: 22222222

fetchUser api invoked

 */