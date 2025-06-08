// DbConnection.java
@Component
public class DbConnection {
    @Autowired(required = false)
    SqlConnection sql;
    
    @Autowired(required = false)
    NoSqlConnection nosql;
    
    @PostConstruct
    public void init() {
        System.out.println("DbConnection is initializing");
        System.out.println("is Sql object is null: " + Objects.isNull(sql));
        System.out.println("is Nosql object is null: " + Objects.isNull(nosql));
    }
}

// SqlConnection.java
@Component
@ConditionalOnProperty(prefix = "sqlconnection", value = "enabled", havingValue = "true", matchIfMissing = false)
public class SqlConnection {
    public SqlConnection() {
        System.out.println("SqlConnection is initializing");
    }
}

// NoSqlConnection.java
@Component
@ConditionalOnProperty(prefix = "nosqlconnection", value = "enabled", havingValue = "true", matchIfMissing = false)
public class NoSqlConnection {
    public NoSqlConnection() {
        System.out.println("NoSqlConnection is initializing");
    }
}

// application.properties
sqlconnection.enabled=true
# nosqlconnection.enabled=true (commented out, so NoSqlConnection won't be created)
/*
*Output:
DbConnection is initializing
SqlConnection is initializing
is Sql object is null: false
is Nosql object is null: true
How ???
Since sqlconnection.enabled=true, the SqlConnection bean will be created
Since nosqlconnection.enabled is not set (and matchIfMissing=false), the NoSqlConnection bean won't be created
The @Autowired(required = false) ensures no exception is thrown when NoSqlConnection is null
The @PostConstruct method runs after dependency injection, showing which connections are available

*/
