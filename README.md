# Miro App Test Automation Assignment

This project provides test automation for miro application sticker creation functionality.
##Test case: Sticker creation functionality:
We have two users in Miro. Verify that the sticker which was created on a board by the
first user will appear on the board for the second user.
Steps:
1. As a “User1” I login into service and create a board with the name “Board”
2. As a “User1” I open “Board” and create there sticker(sticker widget), by using left
   toolbar
3. As a “User1” I invite “User2” to “Board” by using “Share” button in the top right
   corner
4. As a “User2” I login into service and open “Board”
5. As a “User2” I should see created sticker on “Board”

### Run the project
- Install Apache maven https://maven.apache.org/install.html
- commands in mac simply do "brew install maven"
- Download the source code from git hub repository: https://github.com/Nishadds/MiroAppAutomation
- From command line go root directory of the project, ensure pom.xml file is available in the folder.
- All the dependencies are added in pom.xml file, no need to add any jar files.
- Clean and build the project, run the command:
```aidl
mvn clean test
```
This will delete previously created all the .class and .properties file, our project will start the execution from clean state.
