

# GetDelegateTokenRequest

payload to generate a delegate_token

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**principal** | **String** | Principal to delegate the token to. Will default to the requestor if not provided |  [optional] |
|**expiry** | **Long** | Expiry in seconds from the time of generation.  If not provided, generated token will have the expiry of the token used for requesting. If a credential is used for requesting, expiry will be 24 hours from the time of requesting.  |  [optional] |
|**policy** | **String** | Policy with which to generate the delegate token. Can be just the name of the policy if it is in the requestors organization or a complete policy resourceHrn  |  |



