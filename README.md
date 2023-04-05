# TestVagrantAssignment
This is a Java program that implements an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity. It can store a list of song-user pairs, with each song linked to a user. It can fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.

Installation
To use this program, you need to have Java 8 or Java 11 installed on your system. You can download Java from the official website: https://www.oracle.com/java/technologies/downloads/

You can clone the repository from GitHub by running the following command:

bash
Copy code
git clone https://github.com/anupanupkhandare26/TestVagrantAssignment.git
To run the program, you can simply run the TestNG test suite by running the testng.xml file. The test suite includes all the test cases for the program.

To view the test report, you can check the report folder, which includes an extent report of the test.

Usage
To use the program, you can modify the RecentlyPlayedSongsStore class to include any additional functionality that you need. The program includes two classes in src/RecentlyPlaySongCode:

RecentlyPlayedSongsStore: This is the main class that implements the recently played songs store.

RecentlyPlayedSongsStoreTest: This is the TestNG test script that includes all the test cases for the program.

The program is a Maven project, so the pom.xml file is already included to install all the required dependencies. You will need to have TestNG installed to run the test cases. You can download TestNG from the official website: http://testng.org/

Contributing
Contributions to this program are always welcome. If you find any bugs or want to suggest improvements, please feel free to open an issue or submit a pull request.
