
This is a Java Maven project composed in IntelliJ IDE. 
You can run these tests using one of the following wys:

-Maven

-IntelliJ

Using Maven from command line:

1. Cloning the project:
Copy the following URL:
https://github.com/psrikrishna/eurosport/

2. Create a local directory.
In a local directory, clone the project:
git clone https://github.com/psrikrishna/eurosport.git

3. Change directory into the project:
cd eurosport

4. Download the Maven dependencies using the following command:
mvn clean install -DskipTests=true

5. Run the tests using the following command:
mvn clean verify

The above command will run all the tests by default.

Using IntelliJ:

1. In the src/main/java/runners, open AllFeaturesRunner or VideosFeatureRunner.

2. Right-click in the runner file.

3. Click Run.


