# 3-parkmech-notes-api
Flyway migration with environment configs files, local, dev, prod.

.\gradlew -D flyway.configFiles=src\main\resources\flyway\config\local_flyway.conf -i flywayMigrate

Or set environment variable for gradle task FLYWAY_CONFIG_FILES=src\main\resources\flyway\config\local_flyway.conf