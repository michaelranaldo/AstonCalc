# Simple MVC Calc

So the aim of this project is to:

a) Demonstrate what not to do (I can do the wrong thing just fine thank you very much)

b) Demonstrate what one could do to do it correctly (eh, doing the absolutely right thing is impossible anyway)

## Building

To build this maven project, you will need to download Apache Maven. While this may seem like an application of the good old adage "There's no kill like overkill", it's a lot nicer to work with and adds relatively little cruft as NetBeans manages everything for you. Like, literally everything. You can probably write a full Maven RESTful web-app with only the arrow keys and Alt-Insert and Alt-Enter. 

To build, run the command `mvn clean install` from the top level directory. This will automatically find the pom.xml file which contains the instructions on how to assemble the program. 
You can then run the created .jar file via `java -jar <jarnamehere>.jar`.

## Using

Within this project you will find two applications (currently one, but let's be optimistic). Calc-Basic-MVC uses MVC alone in a crude implementation. This is the deliberately flawed implementation. Calc-Observer-MVC uses MVC but with View-Model updates facilitated by the Observer pattern. This is the "more correct" implementation, as it isn't as wrong.

As a simple method for people with limited time/curiosity/patience-for-bullshit:

Build and run the application

1. `mvn clean install`
1. `java -jar <yourjarnamehere>.jar`
1. Select Basic-MVC
1. Enter the number 2 in view 1
1. Select multiply.
1. Observe that the number is now 2 in 1 and 1 in 2.
1. Select Observer-MVC
1. Enter the number 2 in view 1
1. Select multiply.
1. Observer that the number is now 2 in 1 and 2 in 2.
1. Close the program, happy with a job well done.
