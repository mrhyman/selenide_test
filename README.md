### To access DB add db.yml file to test/resources folder. It should have the following structure:

```
db:
    url: jdbc:sqlserver://IP:Port;
    user: USER
    password: PASSWORD
names:
    serverN1: databaseName=DB_NAME1
    serverN2: databaseName=DB_NAME2
```
```
To compile project to executable jar use

mvn clean install -DskipTests=true 

comand, which will skip all tests and create new jar containing test classes 
in project root directory

add -P flag to compile jar with special settings, they can be added to 
profiles folder in .properties files

mvn clean install -DskipTests=true -P 64server
```
