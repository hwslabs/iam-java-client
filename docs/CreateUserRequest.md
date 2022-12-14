

# CreateUserRequest

Payload to create ledger account

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**preferredUsername** | **String** |  |  [optional] |
|**name** | **String** |  |  |
|**password** | **String** |  |  [optional] |
|**email** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) |  |  |
|**verified** | **Boolean** |  |  [optional] |
|**loginAccess** | **Boolean** |  |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ENABLED | &quot;enabled&quot; |
| DISABLED | &quot;disabled&quot; |



