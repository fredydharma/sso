# NETS SSO Projects

## Useful Links
- [KeyCloak: Configure and Test Email settings for Realm?](https://codehumsafar.wordpress.com/2018/09/23/keycloak-configure-and-test-email-settings-for-realm/)

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
module add --name=org.keycloak.keycloak-admin-client --resources=../modules/system/layers/keycloak/org/keycloak/keycloak-admin-client/main/keycloak-admin-client-9.0.3.jar
module add --name=org.keycloak.keycloak-admin-client --resources=../modules/system/layers/keycloak/org/jboss/resteasy-client/resteasy-client-4.5.8.Final.jar
```


C:/Users/Ferdinand/Documents/Izeno-Project/SG - NETS/rh-sso-7.3.0/modules/system/layers/keycloak/org/jboss/resteasy-client/resteasy-client-4.5.8.Final.jar