To access DB add db.yml file to test/resources folder. It should have the following structure:

db:
    url: jdbc:sqlserver://<IP:Port>;
    user: <USER>
    password: <PASSWORD>
names:
    serverN1: databaseName=<DB_NAME1>
    serverN@: databaseName=<DB_NAME2>