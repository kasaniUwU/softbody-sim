import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mesh {
    List<Vector2> points=new ArrayList<>();
    List<List<Integer>> faces=new ArrayList<>();
    public mesh(String fileString){
        try {
            File file = new File(fileString);
            Scanner fileIn = new Scanner(file);
            while (fileIn.hasNextLine()) {
                String data = fileIn.nextLine();
                if(data.substring(0,2).equals("v ")){
                    String temp=data.substring(2);
                    double x= Double.parseDouble(temp.substring(0,temp.indexOf(" ")));
                    temp=temp.substring(temp.indexOf(" ")+1);
                    double y= Double.parseDouble(temp.substring(temp.indexOf(" ")+1));
                    points.add(new Vector2(x*100,y*100));
                }
                if(data.substring(0,2).equals("f ")){
                    String temp=data.substring(1);
                    List<Integer> tempList=new ArrayList<>();
                    while(temp.indexOf(" ")!=-1) {
                        tempList.add(Integer.valueOf(temp.substring(temp.indexOf(" ")+1,temp.indexOf("/"))));
                        temp=temp.substring(1);
                        if(temp.indexOf(" ")!=-1) {
                            temp = temp.substring(temp.indexOf(" "));
                        }
                    }
                    tempList.add(Integer.valueOf(temp.substring(1,temp.indexOf("/"))));
                    faces.add(tempList);
                }
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("file \""+fileString+"\" does not exist");
        }
    }
}