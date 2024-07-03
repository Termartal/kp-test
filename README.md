Automation tests are available in folder **kp-demo**. Project builds and runs using Maven. I added Maven wrapper, so you'll only need Java 17+ to run the project.
Here are commands to execute in the terminal while in kp-demo folder:
```
./mvnw clean install -DskipTests
./mvnw test
```
