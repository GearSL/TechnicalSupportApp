# Technical Support APP
[![Maintainability](https://api.codeclimate.com/v1/badges/1152cc2a8df1c4d6b23f/maintainability)](https://codeclimate.com/github/GearSL/TechnicalSupportApp/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/1152cc2a8df1c4d6b23f/test_coverage)](https://codeclimate.com/github/GearSL/TechnicalSupportApp/test_coverage)

## About
Technical Support APP is a web application that allows:
   - users to receive telegram group notifications on created tickets in the technical support helpdesk;
   - create tasks in the helpdesk for the found problems of the project (payments with errors, accrual errors, etc.)
The application is built using Java + Spring boot.

## Setup
```sh
### For start project:
start # start app with dev profile.

start-prod # start app with prod profile.

start-dist # Installs the project as a distribution as-is. Depends on clean and install.

### Another tasks you can see in "Makefile"
```

## Deploy
### Create database
For application need a database that will be used for storage projects, settings and etc.

### Prepare environment variables:
```dotenv
APP_ENV # application profile "dev" or "prod"
DATABASE_HOST
DATABASE_PORT
DATABASE_NAME
JDBC_DATABASE_USERNAME
JDBC_DATABASE_PASSWORD
```

### Start application
Start application using Dockerfile in project root.