# A basic Clients and Cities CRUD with Java 8, Spring Boot and MongoDB
#### - To run this project is mandatory to have MongoDB installed and with a local DB (possibly in C:/data/db folder) (https://docs.mongodb.com/manual/installation/)
#### - This project runs in Spring Boot 2.4.2 with MongoDB v4.4.4


Clients operations
- [x] Register client
    - POST in localhost:8080/clients

  `{ "name": "Client name", "gender": ("FEMALE", "MALE" or "OTHER"), "birth": "yyyy-mm-dd", "age": 40, "city": { "name": "Registered city name", "state": "Registered city state" } }`

  (note that a city must be registered before for the correct city reference)
- [x] Get all clients
    - GET in localhost:8080/clients
- [x] Search client by name
    - GET in localhost:8080/clients/name/{name}
- [x] Search client by id
    - GET in localhost:8080/clients/{id}
- [x] Delete client
    - DELETE in localhost:8080/clients/{id}
- [x] Updates client name
    - PUT in localhost:8080/clients/{id}

  `{ "name": "Client new name" }`


Cities operations
- [x] Register city
    - POST in localhost:8080/cities

  `{ "name": "City name", "state: "City state" }`
- [x] Get all cities
    - GET in localhost:8080/cities
- [x] Search city by id
    - GET in localhost:8080/cities/{id}
- [x] Search city by name
    - GET in localhost:8080/cities/name/{name}
- [x] Search city by state
    - GET in localhost:8080/cities/state/{state}


Note that this CRUD is not 100% finished, so it's possible to create objects with null values and some exceptions were not treated.


How to run in <b>IntelliJ IDEA</b>:
<ul>
  <li>Firstly activates MongoDB in terminal, using `mongod` (you should create a database in mongo shell with `mongo >> use clients_cities_crud_bd` before)</li>
  <li>In IDEA, press "Play" `▶️`</li>
  <li>Watchs for which port the API will work on, `8080` by default</li>
</ul>
