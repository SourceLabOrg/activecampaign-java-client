# Active Campaign Java API Client

## What is it? 

This library intends to be a fluent style API client for Active Campaign's API (version 3).

**Note** It currently is not fully featured/fully implemented. If there is a feature/end point that you
need that is not yet implemented, please read the **[How to Contribute](#how-to-contribute)** section, or **[Create an issue](https://github.com/SourceLabOrg/activecampaign-java-client/issues)** 
requesting it. 
 
## How to use this library

This client library is released on Maven Central.  Add a new dependency to your project's POM file:

```xml
<dependency>
    <groupId>org.sourcelab.activecampaign</groupId>
    <artifactId>ApiClient</artifactId>
    <version>(Not Yet Released)</version>
</dependency>
```

Example Code:
```java
/*
 * Create a new configuration object with your Active Campaign credentials.
 *
 * This configuration also allows you to define some optional details on your connection,
 * such as using an outbound proxy (authenticated or not).
 */
final ApiConfig apiConfig = new ApiConfig("YourBaseUrl", "YourApiToken");

/*
 * Create an instance of ActiveCampaignClient, passing your configuration.
 */
final ActiveCampaignClient apiClient = new ActiveCampaignClient(apiConfig);

/*
 * The client will automatically authenticate when you make your first request, no need to
 * explicitly login.
 *
 * Lets create a simple Account request, and execute it.
 */
final AccountListResponse response = apiClient.accountList();
for (final Account account : response.getAccounts()) {
    System.out.println("Found Account: " + account.getName());    
}

/*
 * Or lets create an account.
 */
final Account accountToCreate = Account.newBuilder()
    .withName("My Account Name")
    .withAccountUrl("https://www.test.com/blah")
    .build();

// Make api request to create the account
final AccountResponse resp = apiClient.accountCreate(accountToCreate);

/*
 * And when you're done, call close on apiClient.
 */
client.close();
```

Or Using the Try-With-Resources Pattern:
```java
/*
 * Since ActiveCampaignClient implements Autoclosable, you can also use the try-with-resources pattern.
 */
final ApiConfig apiConfig = new ApiConfig("YourBaseUrl", "YourApiToken");
try (final ActiveCampaignClient apiClient = new ActiveCampaignClient(apiConfig)) {
    // Use apiClient instance as needed
    
    // apiClient.close() is automatically called at the end of the try {} block.
}
```

## What Features are implemented?

### Authentication
Official Documentation: [Authentication](https://developers.activecampaign.com/reference#authentication)

Authenticating with ActiveCampaign's API using your Api Token.  

### Accounts
Official Documentation: [Accounts](https://developers.activecampaign.com/reference#accounts)

- Create
- Retrieve
- Update
- Delete
- List

## How to Contribute 

Want to help implement the missing API end points?  Fork the repository, write some code, and 
submit a PR to the project!

## Changelog

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

[View Changelog](CHANGELOG.md)
