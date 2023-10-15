set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReports\aspectjweaver-1.9.20.1.jar" -classpath "%ProjectPath%bin;%ProjectPath%libSeleniumJava\*;%ProjectPath%libWebDriverManager\*;%ProjectPath%libLog4j\*;%ProjectPath%libReportNG\*;%ProjectPath%libExtentReports\*;%ProjectPath%libAllureReports\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceTest.xml"
allure serve .\allure-results\
pause
