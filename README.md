![Java CI](https://github.com/Brest-Java-Course-2020/afedasiuk-department-mngmnt/workflows/Java%20CI/badge.svg)

# afedasiuk-department-mngmnt  
Department Management demo application


## How build
Setup java 8 and Maven, see [enviroment_setup.md](enviroment_setup.md) 
  
    
## Build project 
Goto Project folder and execute  
    
    mvn clean install

## Rest server

### Start Rest using Maven Jetty plugin 
    
To start Rest using Maven Jetty plugin use:

```
cd department-management-rest-app
mvn jetty:run
```

## Available REST endpoints    

### version

```
curl --request GET 'http://localhost:8088/version'
```

### department_dtos

```
curl --request GET 'http://localhost:8088/department_dtos'
```

Pretty print json:

```
curl --request GET 'http://localhost:8088/department_dtos' | json_pp
```

### departments

#### findAll

```
curl --request GET 'http://localhost:8088/departments' | json_pp
```

#### findById

```
curl --request GET 'http://localhost:8088/departments/1' | json_pp
```

### create

```
curl --request POST 'http://localhost:8088/departments' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
	"departmentName": "JAVA"
}'
```

## update

```
curl --request PUT 'http://localhost:8088/departments' \
--header 'Content-Type: application/json' \
--data-raw '{
   "departmentId": 4,
   "departmentName": "Java"
}'
```

## delete

```
curl --request DELETE 'http://localhost:8088/departments/3'
```

### employees

#### findAll

```
curl --request GET 'http://localhost:8088/employees' | json_pp
```

### findById

```
curl --request GET 'http://localhost:8088/employees/1' | json_pp
```

### findByDepartmentId

```
curl --request GET 'http://localhost:8088/employees?departmentId=1' | json_pp
```

### create

```
curl --request POST 'http://localhost:8088/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstname": "FUSER20",
    "lastname": "LUSER20",
    "email": "email20@mail.com",
    "salary": 100,
    "departmentId": 1
}'
```

### update

```
curl --request PUT 'http://localhost:8088/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "employeeId": 1,
    "firstname": "FUSER10",
    "lastname": "LUSER10 updated",
    "email": "email10@mail.com",
    "salary": 100.0,
    "departmentId": 1
}'
```

### delete

```
curl --request DELETE 'http://localhost:8088/employees/6'
```