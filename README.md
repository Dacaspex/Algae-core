# Algae-core
The image generator of Algae

## Installation instructions
This project uses Maven. See the ui [installations instructions](https://github.com/Dacaspex/Algae-ui/blob/master/README.md) on how to setup the project. 

Clone this repository into the Algae project folder
```
git clone https://github.com/Dacaspex/Algae-core.git
```
When the project is build, the `algae-core.jar` is placed into the algae-ui folder so that the ui can access it. To build the jar

#### Using the command line
Simply run
```
mvn clean install
```
#### Using IntelliJ
Edit configuration -> Create new configuration (green plus) -> Maven.  
Set "Command line" to `clean install`.  
Press the "run" button to build the project.
