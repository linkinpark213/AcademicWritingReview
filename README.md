# NAIST Research Writing Review Assistant

Review assistant for the research writing course in NAIST.

This project is based on JavaFX, which is included in Java 1.8.

## Usage
### 1. Install Java Runtime Environment.
Please make sure that you have installed [Java Runtime Environment](https://java.com/en/download/).
### 2. Create the practice file
Create a file `sentences.txt`(You can download the default file [here](https://raw.githubusercontent.com/linkinpark213/naist-research-writing-review/master/sentences.txt)) in the same directory as the .jar file, put one sentence on each line and surround the word(s) to be filled in with `$`.
 For example:
```
The key to a successful method is to provide just the right amount of $details$
```
### 3. Run the jar file
After creating the txt file, run 
```
java -jar ResearchWritingReview-1.0.jar
```     
in the directory.