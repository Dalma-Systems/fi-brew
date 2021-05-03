# Dalma FEATS Fi-BREW

- This project contains the API to integrate work orders in Modula's database.

## Table of Contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Run](#run)
- [Endpoints](#endpoints)
- [Postman Collection](#postman)


## Requirements
Install the following tools:
- [mvn](https://maven.apache.org/install.html)
- [jdk11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

## Installation
### API
- Clone this repo to your local machine using `https://gitlab.com/bright-technologies/dalma/fi-brew.git`
- Compile API

```shell
$ cd <project_cloned>
$ mvn clean install
```

## Run
- Enter in project cloned folder and execute api: `java -jar fibrew-api-web/target/dalma-fibrew-api.jar`

### Notes
- This API requires to be running Broker API.

## Endpoints
- All endpoints are exposed in Swagger at: `http://localhost:8093/swagger-ui.html`
- Critical endpoints at Notification WorkOrder Controller:
  1. `/integrate`: This is the endpoint called by Broker API when some work order finish integration in Orion. This endpoint will integrate the work order in Modula's database (Microsoft SQL Server Express).

## Postman
- The postman collection for all FEATS system is available in LATTE repository.
