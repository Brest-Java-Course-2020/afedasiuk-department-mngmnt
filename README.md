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
