# Steps to run
1. Git clone the url
2. ``` cd docker ```
3. ``` docker compose up ```
That's it

# Apis - visit swagger page - localhost:8080/swagger-ui/index.html
I have implemented all the apis , creating the training center , getting all training center and filtering on the basis of city and state (for filtering I have also added indexing on state and city fields)
Along with that I have added validations also as specified in the assignment

# Features
1. Added swagger for api documentation
2. Added Exception handling
3. Added validation as specified
4. Used spring-data-jpa for database interaction
5. Used jpa auditing for createdOn field