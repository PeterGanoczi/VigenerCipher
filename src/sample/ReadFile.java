package sample;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    private String parentPath;
    private String path;

    public ReadFile(String parentPath, String path) {
        this.parentPath = parentPath;
        this.path = path;
    }

    public String getParentPath() {
        return parentPath;
    }

    public String getPath() {
        return path;
    }

    public String loadFile(String path){
    StringBuilder data=new StringBuilder();
        try{
            File myFile=new File(path);
            Scanner myReader=new Scanner(myFile);
            while(myReader.hasNextLine()){
                data.append("\n").append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();

    }


}
