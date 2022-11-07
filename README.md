# REST API service that receives data from "Sensor".

Every time it takes a measurement, it sends HTTP request with data in JSON format on server. 
That is, our computer runs a server with Spring REST API application and we will send requests with Postman.

### POST http://localhost:8080//sensors/registration
			{
			    "name": "RT_2"
			}

Registering new sensor in the table of sensors in DB. The sensor has just one field = "name". 
The field "name" is needing to validate ( the sensor with such a name is not yet in DB - Spring Validator). 
If the sensor with such a name is in the DB - return error message for client. 
If the name of the sensor is empty or contains less than 3 or more than 30 characters - return error message for client.


### POST http://localhost:8080/measurements/add
                  {
                    "value": 22.4,
                    "raining": true,
                    "sensor":{
                        "name": "aaa"
                        }
                  }

Add new measurement (float "value"- temperature, boolean "raining" - registered rain or not). 
Fields value and raining should be stored in a table in the database.  
In addition, in this request is passed the sensor object itself, which received and sends these "measurements".  
Also, in each line of this table should contain the name of the sensor that sent these measurements.  
That is the entity "Measure" has a relationship with the entity "Sensor". All fields in Measure should be validated. 
The "value" not be empty and be in the range from -100 to 100. The "raining" should not be empty. The value "sensor" should not be empty. 
The name of the sensor must  be validated in the database. 
Sensor with such name should be registered in the system (in DB). 
On the server, we need to register the current  time when was send measurements and to save these in the database.

### GET http://localhost:8080/measurements 
 returns all measurements from DB
 
              {
                    "id": 19,
                    "value": 22.4,
                    "raining": false,
                    "sensor": {
                        "id": 11,
                        "name": "RD_32"
                    },
                    "createAt": "2022-11-06T14:26:46.812956"
                }

### GET http://localhost:8080/measurements/rainyDaysCount 
 returns the number of rainy days from DB

                26


# Steps to Setup
**1. Clone the application**

git clone https://github.com/Miller1995/SensorRestAPI.git

**2. Create Postgres database**

create database "sensor_db"

**3. Change Postgres username and password**

 open  `src/main/resources/application.properties`
 change  `spring.datasource.username`  and  `spring.datasource.password` 
 
**4. Run the app using maven**

mvn spring-boot:run
