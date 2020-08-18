# WeatherComparator


Project Name : WeatherComparator

Project Objective : 
1) To extract temperature details of a City using the website https://www.ndtv.com/.
2) To extract the temperature details of the same City using the public weather API by https://openweathermap.org/
3) To compare the temperatures collected from the above sources and check if the difference between the both falls under a given variance

Project Management and Build Automation Tool : Maven
Dependencies management : ./pom.xml

Framework Used : TestNG

UI Testing :
Project Design : Page Object Model 
Automation Suite : Selenium 
Language : Java

API Testing :
Library : Rest Assured 
Language : Java

Components present in the project:

Environment variables Information : ./env.properties
Input City Information : ./test-data\\CityData.xlsx
Input Variance Information : ./Variance.txt
Test configuration file : ./testng.xml

Steps to execute the project : 
1) testng.xml is configured with only one class selected - com.testvagrant.WeathreComparator.Compare.CompareWeatherInfo
2) run the testng.xml file as TestNG Suite
3) The Temperature details fetched from the UI will be displayed first
3) The Temperature details fetched from the API will be displayed next
5) The set up configuration is for City = Bengaluru and Variance = 2
6) Output based on the above configuration will be displayed
7) To alter the City Name : Use the excel file './test-data\\CityData.xlsx' and change the city name
8) If the City name is not available in the Map or in the API, exceptions will be thrown for the user
9) To alter the Variance : Use the text file './Variance.txt' and change the variance value
10) If the variance is not a whole number, exception will be thrown for the user

Limitation : 
The Project is configured for one city, so User is expected to pass only one city as input in the Excel file
