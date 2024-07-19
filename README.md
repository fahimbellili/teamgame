## This is the API for Team and player management

# Project versions 
* JDK 17
* Spring boot 3
* Maven 3

# Project architecture
The project has on parent module with two child modules : 
* teamgame-api : is the API that exposes endpoints to interact with Team and Player objects.
* teamgame-core : is the common module containing business layers of Team and Player. 

This architecture choice is useful for having the business shared for new modules. For example, if we want to create an API related 
to game management, it will use teamgame-core for getting information related to Team and Player. We can also update teamgame-core 
with new business layers related to the game.

# Install dependencies

* mvn clean install 
* mvn clean install -DskipTests (for skipping tests)

# Run the API :
* I am using an H2 database so no need for DB configurations.
* You will find in application.yml username and password; it's not a practice, it just for this test.
* I create on application-env.yml for local env. Each en (dev, qal, prod) could have on application-env.yml.
* To run the API use: mvn spring-boot:run
* Or easier use the IDE tools xD
* the application will start with default profile "local" at HTTP port 8090.

# API's endpoints 
* Save a team: http://localhost:8090/api/v1/teams POST method
* Get one team: http://localhost:8090/api/v1/teams/{teamId} GET method
* Get all teams with filter: http://localhost:8090/api/v1/teams GET method with request parameters: name or acronym or budget.
* for example: to filter by name: http://localhost:8090/api/v1/teams?name=team1 will retrieve all teams with name having team1 (sql like function, we can improve this to get exactly the name)
* About this last endpoint, we can also use a POST method with a DTO class containing the properties (name, acronym and budget). I prefer this solution but I haven't enough time.

* the folder : bruno-connection contains the Bruno collection, all you need is to import it to Bruno API client.

* I didn't do unit test. not enough time, sorry.

* Thank you for reading.