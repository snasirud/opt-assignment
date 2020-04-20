# opt-assignment

To run this project execute the below commands to counter-apis available;

1 ./gradlew build

2 java -jar build/libs/counter-api-0.0.1-SNAPSHOT.jar

3 Run the below command to extract the jwt token to be used for Authorization header while making calls to the web api
    curl testjwtclientid:XY7kmzoNzl100@localhost:8090/oauth/token -d grant_type=password -d username=john.dave -d password=jwtpass

4 Calling search texts counter-api;
  curl -X POST \
    http://localhost:8090/counter-api/search \
    -H 'Authorization: Bearer <jwt-token>' \
    -H 'Content-Type: application/json' \
    -d '{"searchText" : ["Cras", "Sed", "Donec", "Augue", "Pellentesque", "123", "abcd"]}'

5 Calling top count counter-api;
  curl -X GET \
    http://localhost:8090/counter-api/top/<count> \
    -H 'Authorization: Bearer <jwt-token>' \
    -H 'Content-Type: text/csv'