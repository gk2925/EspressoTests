# EspressoTests
EspressoTestsForAndroidApp

for running the tests throgh gradle : 

Clone the project 

Change the directory to EspressoTests ( cd EspressoTests)

Start emulator or a real device 

execute below command : 
 ./gradlew clean connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.mytaxi.android_demo.app.testsuites.AllTests
