package com.demo.config;

/**
* Configuration singleton class that demonstrates the Singleton pattern.
*/
public class ConfigurationManager {
  private static ConfigurationManager instance;
  private String databaseUrl;
  private String apiKey;

  private ConfigurationManager() {
      // Private constructor to prevent instantiation
      this.databaseUrl = "jdbc:mysql://localhost:3306/demo";
      this.apiKey = "demo-api-key";
  }

  /**
   * Gets the singleton instance of ConfigurationManager.
   * @return The ConfigurationManager instance
   */
  public static ConfigurationManager getInstance() {
      if (instance == null) {
          synchronized (ConfigurationManager.class) {
              if (instance == null) {
                  instance = new ConfigurationManager();
              }
          }
      }
      return instance;
  }

  public String getDatabaseUrl() { return databaseUrl; }
  public String getApiKey() { return apiKey; }
}
