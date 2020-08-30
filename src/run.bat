@ECHO OFF
set CLASSPATH=%CLASSPATH%;mysql-connector-java-8.0.18.jar  
javac application.java
java application
pause