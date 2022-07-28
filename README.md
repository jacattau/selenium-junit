Run all tests with gradle with the terminal command

``./gradlew test``

Run all tests with specific browser (Chrome or Firefox) with the terminal command

``./gradlew test -DbrowserName=firefox``

Run all tests with custom parallel parameter with the terminal command

``./gradlew test -Dparallel=4``

Run specific tests class with terminal command

``./gradlew test --tests DropdownTest``

Run specific test method with terminal command

``./gradlew test --tests DropdownTest.selectBothOptionsInDropdown``