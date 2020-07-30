package programm;

public class Configs {
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = System. getenv("SQL_PASSWORD");
    protected String dbName = "localdatabase";
}
