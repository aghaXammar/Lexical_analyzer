# Lexical Analyzer Readme

This Java program serves as a lexical analyzer designed to assist in the analysis of Java source code files. The primary objective of the program is to break down the source code into smaller units called lexemes and categorize them based on their syntactical roles, such as keywords, identifiers, operators, and symbols.

## Preprocessing

The `preprocessor` class is responsible for the initial cleaning and preparation of the source code. It performs the following tasks:

1. Eliminates blank lines to enhance readability.
2. Removes comments, both single-line (//) and multi-line (/* ... */).
3. Removes unnecessary spaces and tabs, ensuring consistent formatting.
4. Eliminates import statements and annotations.
5. Writes the processed code to an output file named "out1.txt".

## Processing the Output File

The `processor` class takes the preprocessed code from "out1.txt" and carries out the following steps:

1. Creates a new output file named "out2.txt".
2. Copies the cleaned code from "out1.txt" to "out2.txt".
3. Appends a "$" symbol at the end of the file to mark its completion.

## Lexical Analysis

The `lexical_analyzer_` class performs the actual lexical analysis on the processed code within "out2.txt":

1. Reads the content of "out2.txt" and processes it line by line.
2. Adds spaces around specific characters to ensure proper token separation.
3. Splits each line into individual tokens, considering spaces as separators.
4. Iterates through the list of tokens, identifying and displaying lexemes.
5. Lexemes include keywords (e.g., "public", "class"), identifiers (e.g., variable names), operators (e.g., "+", "=="), and symbols (e.g., "{", "}").

## How to Use

1. Place the Java source code file you wish to analyze, named "in1.java," in the same directory as the program.
2. Execute the Java program. It will automatically perform preprocessing, processing, and lexical analysis.
3. The program will generate intermediate files "out1.txt" and "out2.txt" during these steps.
4. The final results of the lexical analysis will be displayed on the console.

Please note that the current implementation contains a hardcoded list of keywords and symbols for recognition. Depending on your specific use case, you might need to customize these lists to match your programming language or domain-specific requirements.

This program provides an illustrative example of a lexical analyzer. For real-world applications, further enhancements and considerations, such as error handling and extensibility, should be taken into account.
