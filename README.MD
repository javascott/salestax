Welcome to the Sales Tax Calculator

Overview:
* I created a maven package (jar) for running this sample program.  I have prebuilt the jar, but you can always rebuild using the command: "mvn clean package"
* I wrote the controller so other web interfaces could call this (after discussion scope and storage lifecycle)
* I was thinking about creating a DB for the SKU library, but it would depend on exact name matching or SQL 'like' commands, so that could be an enhancement

Running the project
* to run use the command "java -jar target/salestax-1.0-SNAPSHOT.jar"
* It will use command line prompts for the inputs: item name, quantity, and price
* It will prompt you to type "done" when you are finished.

Problems/Questions
* My excel/hand math for 2 of the items was different then your sample.  So, I'd like to discuss when we do the code review.
* I wrote some unit tests which outline the issue.  They are just commented out so the build runs.  

