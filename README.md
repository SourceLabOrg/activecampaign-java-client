# Active Campaign Java API Client

## What is it? 

This library intends to be a fluent style API client for Active Campaign's API Version 3 and Active Campaign's Reseller API.

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

### Active Campaign Version 3 API

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

### Active Campaign Reseller Api

Example Code:
```java
/*
 * Create a new configuration object with your Active Campaign Reseller Api key..
 *
 * This configuration also allows you to define some optional details on your connection,
 * such as using an outbound proxy (authenticated or not).
 */
final ResellerApiConfig apiConfig = new ResellerApiConfig("YourResellerApiKey");

/*
 * Create an instance of ActiveCampaignClient, passing your configuration.
 */
final ActiveCampaignResellerClient apiClient = new ActiveCampaignResellerClient(apiConfig);

/*
 * The client will automatically authenticate when you make your first request, no need to
 * explicitly login.
 *
 * Lets show all of the accounts in your Reseller Account.
 */
final AccountListResponse response = apiClient.accountList();
for (final Account account : response.getAccounts()) {
    System.out.println("Found Account: " + account.toString());    
}

/*
 * Or lets create an account.
 */
final AccountAddRequest request = new AccountAddRequest()
    .withAccount("MyAccountName")
    .withCname("mycname")
    .withPlan(123)
    .withNotification("test@example.com")
    .withLanguage(Language.ENGLISH)
    .withTimezone("America/Chicago");

// Make api request to create the account
final AccountAddResponse result = apiClient.accountAdd(request);
System.out.println("Created Account: " + result.toString());

/*
 * And when you're done, call close on apiClient.
 */
client.close();
```

Or Using the Try-With-Resources Pattern:
```java
/*
 * Since ActiveCampaignResellerClient implements Autoclosable, you can also use the try-with-resources pattern.
 */
final ResellerApiConfig apiConfig = new ResellerApiConfig("YourResellerApiKey");
try (final ActiveCampaignResellerClient apiClient = new ActiveCampaignResellerClient(apiConfig)) {
    // Use apiClient instance as needed
    
    // apiClient.close() is automatically called at the end of the try {} block.
}
```

## What ActiveCampaign Api Version 3 Features are implemented?

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

## What ActiveCampaign Reseller Api Features are implemented?

### account_add 
Add a new account, just like you would on the Manage Accounts page of the reseller panel.

### account_cancel 
Allows you to cancel an active account.

### account_conversations 
Turn Conversations on or off and update purchased seats count.

### account_credits_apply
Add reseller's email sending credits to an account.

### account_edit
Edit existing account settings and plan, just like you would on the Manage Accounts page of the reseller panel.

### account_emailtest_credits_apply
Add reseller's email testing credits to an account.

### account_list
View multiple accounts under your reseller profile including all information associated with each.

### account_name_check 
Allows you to check remotely if the account name is already taken.

### account_plans
Allows you to retrieve a list of currently available plans for an account.

### account_scoring
Turn lead and contact scoring on or off for an non-enterprise account.

### account_status
Allows you to check the account status. Possible results are active, disabled, creating, cancelled.

### account_status_set
Allows you to set a custom status for an account. Possible options are "active" and "inactive" (with a custom message).  

## How to Contribute 

Want to help implement the missing API end points?  Fork the repository, write some code, and 
submit a PR to the project!

## Changelog

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

[View Changelog](CHANGELOG.md)
