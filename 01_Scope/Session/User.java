@Component
@Scope("singleton")  // Default scope
public class User {

    public User() {
        System.out.println("User initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("User object hashCode: " + this.hashCode());
    }
}
/*
 * output
 User initialization
User object hashCode: 12345678

TestController1 instance initialization
TestController1 object hashCode: 998877 User object hashCode: 12345678
fetchUser api invoked

TestController1 instance initialization
TestController1 object hashCode: 112233 User object hashCode: 12345678
fetchUser api invoked

Above both http requests belongs to same session and the User is singleton so same hash code is generated but as diffrent 
so differnt testcontroller hashcode is generated.

 */