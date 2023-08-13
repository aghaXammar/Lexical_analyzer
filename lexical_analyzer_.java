


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.io.BufferedReader;
import java.io.FileWriter;



//  Name: Agha Ammar Haider
//  Roll No: 241564746

//                        *About Assignment*
// I have commented the file input part as it was not working on my Visual Studio, it
// should be due to some bug. During viva I will make it run on another laptop.
// I hard coded the file name but every other thing works fine. 
class preprocessor {

    public void preprocessing(){
        // System.out.print("Enter the file name for preprocessing, File: in1.java: ");
        // Scanner sc = new Scanner(System.in);
        // String file = sc.next();
        // Asking for file name to enter

        // while (!(file.equals("in1.java"))) {
        //     System.out.print("****Enter the correct file name****");
        //     System.out.print("Enter the file name for preprocessing, File: in1.java: ");
            
        //     file = sc.next();
        //     //Will ask for the file name untill and unless it is "in1.txt"
        // }

        // //Checking if the file exists in the folder
        System.out.println();
        System.out.println("               ***Preprocessing Part***");
        System.out.println();
       
        File myfile = new File("in1.java");
        if (myfile.exists()) {
            System.out.println("File Exists, File: in1.txt");

            //Creating a new file, File: out1.txt 
            File myFile = new File("out1.txt");
            try {//Checking if it doesn't exists, it will create a new file.
                if (myFile.createNewFile()) {
                    System.out.println("File created - "+""+myFile.getName());

                
                } else {//Else if will tell about the existence of the file
                    System.out.println("File Exists, File: out1.txt");
                
                }
            
            } catch (Exception e) { //It will handle the error if any thing happens while creating the file
                // TODO: handle exception
                System.out.println("Error: Terminated While Creating The File");
                e.printStackTrace();
            }
            

            /*-Eliminating any blank lines in the program.
              -Identifying and eliminating all double slash and slash star comments.
              -Eliminating unnecessary tabs and spaces in the program.
              -Eliminating import statements and annotations.
              -Writing the updated program to a separate file named "out1.txt".
              -Displaying the contents of the output file on the console. 
              
                Executing these functions in the mentioned while loop        */

            try( BufferedReader reader = new BufferedReader(new FileReader("in1.java")) ) {
                FileWriter fileWriter = new FileWriter("out1.txt");
                System.out.println();
                System.out.println("----------------------------------------------------------------");
                System.out.println("|| **The Text To Be Written On, File: out1.txt Is Following** ||");
                System.out.println("----------------------------------------------------------------");
                System.out.println();
                String line; //For saving up a new line
            
                //It will read one line line at a time, saving it to "line" variable of type "String"
                while ((line = reader.readLine()) != null) {
                

                    if (line.length() == 0) {
                        continue; //If the line is empty, loop will continue to the next line
                    }

                    String trimmed = line.trim();// .trim() method removes the leading and trailing spaces
                    if (trimmed.isEmpty()) {
                        continue; //It will check if the trimmed line is empty, if it is then will continue to the next line
                    
                    }

                
                
                    if (Character.isWhitespace(trimmed.charAt(0)) || trimmed.startsWith("/") ) {
                        continue; //Checks if the first character is whitespace or line starts with "/"(checks whether it's a comment), if it is true it will skip to the next line
                    } else {
                        if (trimmed.length()>7) { //Checks if the length of the trimmed line is > than 7
                            char i = trimmed.charAt(0);
                            char t = trimmed.charAt(5); //Checks if the line starts with "import" word
                            if (i=='i'&&t=='t') {
                                continue;
                            
                            }else{
                                String trimed1=trimmed.replaceAll("\\s+", " "); //It will replace multiple spaces with one space
                                trimed1=trimed1.replace(" ;", ";");//Will replace space before ";" to no space
                                fileWriter.write(trimed1); //It will write to "out1.txt"
                                System.out.println(trimed1); //Will print it to screen
                                fileWriter.write(System.lineSeparator()); //It will also write a new line char


                            }
                        
                        
                        }else{
                            //It will repeat the above functions if the length of trimmed line is less than 7
                            String trimed1=trimmed.replaceAll("\\s+", " ");
                            trimed1=trimed1.replace(" ;", ";");
                            fileWriter.write(trimed1);
                            System.out.println(trimed1);
                            fileWriter.write(System.lineSeparator());

                        }
                    
                    }
                }
                fileWriter.close();


                // System.out.println(line);

            
            
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

                
        } else {
            System.out.println("File doesn't exists");
                
        }
            

        System.out.println("                x----------------------------x");

    }
        
        

}
//Now the processor class
class processor{
    public void processing_output_file(){
        // System.out.println();
        // System.out.println("**** NOW PROCESSING THE OUTPUT FILE PART*** ");
        // System.out.print("Enter the file name for preprocessing, File: out1.txt: ");
        // Scanner sc = new Scanner(System.in);
        // String file = sc.next();
        // // Asking for file name to enter

        // while (!(file.equals("out1.txt"))) {
        //     System.out.println("****Enter the correct file name****");
        //     System.out.print("Enter the file name for preprocessing, File: out1.txt: ");
            
        //     file = sc.next();
        //     //Will ask for the file name untill and unless it is "in1.txt"
        // }


    //Now it will check the file "out1.txt" and then other functions will be implemented
    System.out.println();
    System.out.println("               ***Processing Output File Part***");
    System.out.println();
    File myfile = new File("out1.txt");
    if (myfile.exists()) {
        System.out.println("File Exists, File: out1.txt");//Will check the availability of "out1.txt"

        File myFile = new File("out2.txt"); //Will create a new file "out2.txt"
        try {
            if(!myFile.exists()){
                myFile.createNewFile(); //Checks "out2.txt" file
                System.out.println("File created - "+""+myFile.getName());
            } else {
                System.out.println("File Exists, File: out2.txt");
            }

            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error occured");
            e.printStackTrace();
        }


        try(BufferedReader reader = new BufferedReader(new FileReader("out1.txt"))) {
            FileWriter fileWriter = new FileWriter("out2.txt");
            String line;
            while ((line = reader.readLine()) != null){ //Reading the line one by one from "out1.txt"
                
                fileWriter.write(line); //Writing it to "out2.txt"




            }
            fileWriter.write("$"); //Will write "$" at the end
            fileWriter.close();

            try(BufferedReader reader2 = new BufferedReader(new FileReader("out2.txt"))) {
                String line2 = reader2.readLine();
                System.out.println(); //Will read lines from "out2.txt" and will print it to the screen
                System.out.println("----------------------------------------------------------------");
                System.out.println("|| **Text That Is written On The file 'out2.txt' Is Following** ||");
                System.out.println("----------------------------------------------------------------");
                System.out.println(line2);


                
            } catch (Exception e) {
                // TODO: handle exception 
                e.printStackTrace();
            }

            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }






            


    } else {
        System.out.println("File does't exist");
    }

    System.out.println();
    System.out.println("                x----------------------------x");
    }



    
    



}


public class lexical_analyzer_ {

    public void lexical_analysis(){
        System.out.println();
        System.out.println("                 ***Lexical Analysis Part***");
        try (BufferedReader reader = new BufferedReader(new FileReader("out2.txt"))) {
            String line = reader.readLine();
            // System.out.println(line);
            line = line.replace("{", " { ");
            line = line.replace("}", " } ");
            line = line.replace(";", " ; ");
            line = line.replace("(", " ( "); //It will the single spaced char with a leading and trailing space
            line = line.replace(",", " , ");
            line = line.replace("--", " --");
            line = line.replace("++", " ++");
            line = line.replace(")", " ) ");               

            // System.out.println(line);

            String[] substrings = line.split(" ");
            List<String> substringsList = Arrays.asList(substrings); //It splits every char by a " " and saving every char to a new index of a list
            
            for (int i = 0; i < substrings.length; i++) {
                if (substrings[i]=="") {
                    continue;
                    
                } else {
                    // if(substrings[i]=="public" || substrings[i]=="class" || substrings[i]=="in1" || substrings[i]=="{" || substrings[i]=="}" || substrings[i]=="static" || substrings[i]=="void" || substrings[i]=="main" || substrings[i]=="(" || substrings[i]==")" || substrings[i]=="String" || substrings[i]=="[" || substrings[i]=="]" || substrings[i]=="args" || substrings[i]=="=" || substrings[i]=="2" || substrings[i]=="j"||substrings[i]==";"||substrings[i]=="motor"||substrings[i]=="0"||substrings[i]==","||substrings[i]=="sensorValue"||substrings[i]=="if"||substrings[i]=="=="||substrings[i]=="1"||substrings[i]=="else"||substrings[i]=="--"||substrings[i]=="++") {
                    //     System.out.println("Lexeme "+substrings[i]);
                    
                    // }
                    System.out.println("Lexeme: "+substrings[i]);

                }
                
            }



            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        preprocessor prepro = new preprocessor(); //new object for preprocessor class
        prepro.preprocessing();

        processor pr = new processor();
        pr.processing_output_file(); //new object for processor class

        lexical_analyzer_ lexi = new lexical_analyzer_();
        lexi.lexical_analysis(); //new object for lexical_analyzer_ class
        
    }
}
