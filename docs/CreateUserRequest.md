

# CreateUserRequest

Payload to create ledger account

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **String** |  | 
**passwordHash** | **String** |  | 
**email** | **String** |  | 
**phone** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  | 
**verified** | **Boolean** |  |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
ENABLED | &quot;enabled&quot;
DISABLED | &quot;disabled&quot;



