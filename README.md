# Freenow Assesment

Mobile Application Auotomation

## Tech stack Used
Java, Cucumber,Gradle, Espresso, Junit Report

## Approach 
Project - Gradle
Framework - Cucumber(For Test approach), Espresso(For Mobile UI Automation), Cucumber(For Test Execution ), Junit(For Report)
Language - Java 
Gradle 7.3

## Project Setup 
- Feature file - /app/src/androidTest/assets/features/login.feature
- Step Defenition - /app/src/androidTest/java/com/freenow/android_demo/activities/MainActivitySteps.java
- Runner file - /app/src/androidTest/java/com/freenow/android_demo/activities/Instrumentation.java


## Prerequisites 
    Mac OS/Linux/Windows
    Android Studio (Emulator should be running already) - https://developer.android.com/studio
    Java 8 and above 
    Gradle 7.3 (Current stable version - https://gradle.org/install/ )
    
    
   
## Steps for Local Execution
- Download and Extract this project to your local or use git clone https://github.com/sarputheen/freenow_home_task
- Open project in Android Studio - Please wait untill the project gets loaded completely
- Open the Terminal in the Android Studio or Navigate to the poject directory in the deskop terminal 

        Run Command -  ./gradlew connectedAndroidTest ( Mac or Linux)
        Run Command -  gradlew connectedAndroidTest (Windows)

- If you get the permission denied error like this "zsh: permission denied: ./gradlew " on your local, please run this command   chmod 777 * (For Mac and linux this command) . Then use the Run Command
- Once the test execution completed go to the below path in the project directory to view the test reports
        
        /app/build/reports 

There you can see 2 types of report folders
1. androidTests - Test execution report
2. coverage	- Test coverage report

## Steps for CircleCI Execution
- Go to https://app.circleci.com/pipelines/github/sarputheen/freenow_home_task
- Click on the latest build job
- Click on the "ARTIFACTS" Tab to see the test execution report files

## Scenarios that needs to be covered
- input field validation ( min and max length, username/password combinations(alphabets - upper/lower,digits,special characters), empty field , inavalid username/password, 
- Search Driver input field - No search result found when there is no matching driver name
- location - get the current location and its coordinate ( latitude & longitude)
- Driver profile validation - profile image, name, location icon and name , calender icon and date

    
  

















