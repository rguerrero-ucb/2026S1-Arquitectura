package singleton;
public class Config {
    private String databaseUrl;
    private String apiKey;

    public Config(String databaseUrl, String apiKey) {
        this.databaseUrl = databaseUrl;
        this.apiKey = apiKey;
    }


    private static Config $instance;
    public static  Config getInstance() {
        if ($instance == null) {
            $instance = new Config("jdbc:mysql://localhost:3306/mydb", "12345-ABCDE");
        }
        return $instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
    public String getApiKey() {
        return apiKey;
    }
}
