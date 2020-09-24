# NETS SSO Projects

## Contoh URL tanpa tab_id, untuk redirect langsung
```
http://localhost:8080/auth/realms/identity-provider-realm/protocol/openid-connect/registrations?client_id=account&response_type=code&scope=openid
redirect_uri=http://localhost:8080/auth/realms/identity-provider-realm/account
```

## Contoh penambahan module Keycloak
```bash
module add --name=com.mysql --resources=../modules/system/layers/keycloak/com/mysql/main/mysql-connector-java-8.0.21.jar --dependencies=javax.api,javax.transaction.api
module add --name=com.squareup.okhttp3 --resources=../modules/system/layers/keycloak/com/squareup/okhttp3/okhttp/main/okhttp-4.8.1.jar
module add --name=com.squareup.okio --resources=../modules/system/layers/keycloak/com/squareup/okio/okio/main/okio-2.7.0.jar
module add --name=com.fasterxml --resources=../modules/system/layers/keycloak/com/fasterxml/jackson/core/jackson-databind/main/jackson-databind-2.9.6.jar
module add --name=com.thoughtworks --resources=../modules/system/layers/keycloak/com/thoughtworks/xstream/main/xstream-1.4.10.redhat-1.jar
```


