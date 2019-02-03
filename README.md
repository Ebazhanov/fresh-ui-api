## Fresh

### Set up

You will need the following technologies available to try it out:
* Git
* Maven 3+
* JDK 8
* IDE of your choice 
* Web browser Chrome

### Ho w to run

- [x] run tests in parallel mode;

```mvn clean test```

- [x] ability to run tests for different browsers/os by configuring;
- [x] ability to run tests for different environments(urls) by configuring/by command-line.

```mvn clean test -Denv=prod -Dbrowser=firefox``` 

### Generate Allure report 

```mvn allure:report```

### Open Allure report in browser

```mvn allure:serve```

### Video how does it looks like

- [parallel run/diff browser(firefox) + env(prod)](https://monosnap.com/file/veYCgJGsbi9ov3s94j0eROYsPHmro2)

