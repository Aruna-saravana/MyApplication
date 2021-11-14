# My Application
This application consists of source code for Person Application

### Person Details
This application supports following operations :

1. Add Person (id, firstName, lastName)
2. Edit Person (firstName, lastName)
3. Delete Person (id)
4. Add Address to person [multiple required] (id, street, city, state, postalCode)
5. Edit Address (street, city, state, postalCode)
6. Delete Address (id)
7. Count Number of Persons
8. List Persons

The Application allows the addition/modification as well the deletion of the details of the person.


### Build
The following commands should be run in the parent project to build all the modules 

`mvn clean install`

### Deploy
The following command should be executed to run any service locally

`java -jar person-0.0.1-SNAPSHOT.jar`

### Swagger URI

http://localhost:8080/myapplication/swagger-ui/index.html#/

### Health

http://localhost:8080/myapplication/actuator/health

### API Details

#### Person API

#### Add Person

Method : PUT

```
/myapplication/person
```

#### Request

```
{
  "firstName": "test",
  "id": "1",
  "lastName": "added"
}

```

#### Response

200 Ok

```
{
  "message": "Person added",
  "id": "1"
}
```

#### Post Person

Method : POST

```
/myapplication/person/{id}
```

#### Request

Param : id - id of person to be updated

```
{
  "firstName": "test",
  "lastName": "updated"
}
```

#### Response 

200 Ok

```
{
  "message": "Person details updated",
  "id": "1"
}
```

#### Delete Person 

```
/myapplication/person/{id}
```

Param : id - id of person to be updated

```
{
  "message": "Person id deleted",
  "id": "1"
}
```

#### Get Person Count 

```
/myapplication/person/count
```

#### Response 
```
{
  "message": "Total count of persons 1",
}
```

#### Add Address

Method : PUT

```
/myapplication/person/address
```

#### Request

```
{
  "city": "limerick",
  "id": "1",
  "personId": "1",
  "postalCode": "75009",
  "state": "ire",
  "street": "st"
}
```
#### Response

200 Ok
```

{
  "message": "Address added successfully",
  "personId": "1",
  "id": "1"
}
```

#### Update Address

Method : POST

```
/myapplication/person/address
```

#### Request
Param : 
id - id of address to be updated
personId - id of person to be updated
```
{
  "city": "limerick added",
  "id": "1",
  "personId": "1",
  "postalCode": "75009",
  "state": "ire",
  "street": "st"
}
```
#### Response

200 Ok
```

{
  "message": "Address updated successfully",
  "personId": "1",
  "id": "1"
}
```

#### Delete Address

Method : DELETE

```
/myapplication/person/address/{personId}/{id}
```

#### Request
Param : 
id - id of address to be updated
personId - id of person to be updated

#### Response

200 Ok
```

{
  "message": "Address deleted successfully",
  "personId": "1",
  "id": "1"
}
```

#### GET all persons

Method : GET

```
/myapplication/persons
```

#### Response

200 Ok
```
{
  "persons": [
    {
      "id": "1",
      "firstName": "test",
      "lastName": "added",
      "address": [
        {
          "id": "1",
          "personId": "1",
          "street": null,
          "city": "limerick",
          "state": "75009",
          "postalCode": "75009"
        }
      ]
    }
  ]
}
```

#### changes are explained more in Java docs, Please access the doc from path :

/person/person/doc/index.html