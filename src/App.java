import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.Stack; 

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();

        try{
            File file = new File("Calc1.stk");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){

                String data = reader.nextLine();
                
                if(data.equals("+")){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b + a;
                    stack.push(result);

                }else if(data.equals("-") ){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b - a;
                    stack.push(result);

                }else if(data.equals("*") ){    
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b * a;
                    stack.push(result);

                }else if(data.equals("/") ){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b / a;
                    stack.push(result);

                }else{
                    stack.push(Integer.parseInt(data));
                }
            }
            reader.close();
            System.out.println(stack.pop());
        }catch(FileNotFoundException e){
            System.out.println("We not found the file!");
            e.printStackTrace();
        }
        
    }
}
