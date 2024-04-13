# support-system
Simple support system

## Quick Start
1. Download and install Git.
2. Download and setup latest [Maven](https://maven.apache.org/download.cgi).
3. Download and setup Java 17.
4. Download Postman to test endpoints.
5. Clone project and move to project directory.
```bash
clone https://github.com/mamadaliev/support-system.git
cd support-system
```
6. Clean and install project.
```bash
mvn clean package
```
7. Run spring boot via Maven:
```bash
mvn spring-boot:run
```
8. Open postman and import [postman.json file](https://github.com/mamadaliev/support-system/blob/master/postman.json).
9. Test endpoints via Postman.

## Demo
### Sign Up
Request:
```
http://localhost:8080/api/v1/auth/sign-up
```

Request Body:
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "username": "john.doe@company.com",
    "password": "password"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZTJAY29tcGFueS5jb20iLCJpYXQiOjE3MTMwNDA1OTgsImV4cCI6MTcxMzA0MjAzOH0.e9_mKgn-v489CSxfn-Az7QwHO-gD_a837SjxE1CkBmk"
}
```

### Sign In
Request:
```
http://localhost:8080/api/v1/auth/sign-in
```

Request Body:
```json
{
    "username": "john.doe@company.com",
    "password": "password"
}
```
Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huLmRvZUBjb21wYW55LmNvbSIsImlhdCI6MTcxMzA0MDU0NiwiZXhwIjoxNzEzMDQxOTg2fQ.G-4w5q73qD_JBezsaLozIDy7PaSLPk5z06L37obyvPw"
}
```

### Current User
Request:
```
http://localhost:8080/api/v1/users/me
```

Response:
```json
{
  "id": "f233b44a-bc51-4483-bf22-3a8edb668f69",
  "firstName": "John",
  "lastName": "Doe",
  "username": "john.doe@company.com",
  "role": "USER"
}
```
