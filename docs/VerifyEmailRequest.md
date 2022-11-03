

# VerifyEmailRequest

Payload to send verification link to email

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | **String** |  |  |
|**organizationId** | **String** |  |  [optional] |
|**purpose** | [**PurposeEnum**](#PurposeEnum) |  |  |
|**metadata** | **Map&lt;String, Object&gt;** | Additional metadata to be sent along with the request. Every purpose requires different metadata. - signup :     if user provides admin user and org details in metadata, they don&#39;t need to be provided in the request body during CreateOrganization request.     Supported metadata keys:     1. name : string (required): name of the organization     2. description : string (optional) - description of the organization     3. rootUserPassword : string (required) - password of the root user     4. rootUserName : string (optional) - name of the root user     5. rootUserPreferredUsername : string (optional) - preferred username of the root user     6. rootUserPhone : string (optional) - phone number of the root user  |  [optional] |



## Enum: PurposeEnum

| Name | Value |
|---- | -----|
| RESET | &quot;reset&quot; |
| SIGNUP | &quot;signup&quot; |



