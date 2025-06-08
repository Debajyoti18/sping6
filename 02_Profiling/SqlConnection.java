/*
We have diffrent envirnments like dev,qa and production and want to set different configuration for all diffrent environment by choosing 
profiles .default is in app.properties
*/


@Component
public Class SqlConnection{
    @Value(${username}) - (springboot will add this value by seaching from application.properties file)
    String name;

    @Value(${password})
    int password;

    @PostConstruct
    public void init(){
        System.out.println(username + "  "+ password);
    }
}

/**
 * output: username password 
 * after qa active 
 * output:qausername qapassword
 * Tells us that which profile u working on
 * 
 * By Dynamically i.e at RunTime we can also provide the configuration to run the applicaion by-
 * mvn spring-boot:run -Dspring-boot.run.profiles=qa (more priority than app.proerty) or by implementing in pom.xml file and run
 * command: mvn spring-boot:run -Pqa
 */
@Component
@profile("dev")
public Class SqlConnection{
    @Value(${username}) - (springboot will add this value by seaching from application.properties file)
    String name;

    @Value(${password})
    int password;

    @PostConstruct
    public void init(){
        System.out.println(username + "  "+ password);
    }
}

@Component
@profile("qa")
public Class MySqlConnection{
    @Value(${username}) - (springboot will add this value by seaching from application.properties file)
    String name;

    @Value(${password})
    int password;

    @PostConstruct
    public void init(){
        System.out.println(username + "  "+ password);
    }
}
@Component
@profile("prod")
public Class NoSqlConnection{
    @Value(${username}) - (springboot will add this value by seaching from application.properties file)
    String name;

    @Value(${password})
    int password;

    @PostConstruct
    public void init(){
        System.out.println(username + "  "+ password);
    }
}
//By @profile - springboot matches the profile content with active content in application.properties file 
//or which given at runtime , if it matches then it run that otherwise not.
/**
 * lets say active is =qa  but at run time prod is given then  prod will be executed
 * 
 */
