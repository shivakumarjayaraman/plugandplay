This Java example, built for educational purposes, is a simple webserver that illustrates Java's plug-and-play (dynamic loading) capabilities. 

The server utilizes a 'data' directory (the directory can be specified as a command line argument, see below for usage). If you drop a simple java class, which implements a Function interface (java.util.function.Functional), that takes in a String and returns another into this data directory, the server should be able to load it and execute the class. Let me illustrate via an example.. 


Let's say you run the server (see below for how to compile it into an executable jar) using the below command

java -jar target/plugandplay*jar /tmp

and hit a URL that looks like http://localhost:8090/MyAction?data=helloworld

The server will look for MyAction.class in the data directory (/tmp in the example), instantiate it and execute its action method. MyAction.java is illustrated below (it implements the Funtion<String, String> functional interface). 


```
import java.util.function.*;

public class MyAction implements Function<String, String> {
    public String apply(String data) {
        return data.toUpperCase();
    }
}
```

This code can be compiled on the command line using javac 

The goal is to complete the code in plugandplay to achieve this 'plug and play' functionality. If you change the MyAction code, recompile it, the new version should get executed without requiring a restart of the server. 


HOW TO BUILD THIS CODE : mvn clean compile assembly:single
HOW TO RUN THIS CODE : java -jar target/plugandplay-1.0-SNAPSHOT-jar-with-dependencies.jar


The Maven command used to generate this project initially

mvn archetype:generate -DgroupId=com.netgear.simplews -DartifactId=simplews -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false

