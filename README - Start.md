README - Start.md

# ** TODO **

1* Modify src/resources/application.properties (or cf tips)

# ** TIPS **

## ** application.properties **
Modify application.properties whith you own mysql unsername / password
(For more security : 

You can externalize properties data 
1* puting it into a folder named "config/config/application.properties" at the root of the projet ; 
2* generate .jar, command :' > mvn clean package -DskipTests=true ', retrieve dataLayer.jar generated and put if into config folder (config/dataLayer.jar)
3* command : java -jar dataLayer.jar to run 

